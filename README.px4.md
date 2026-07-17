# PX4 Autopilot

OpenEmbedded recipes for building PX4-Autopilot (posix platform)

## Layout

| Recipe | Purpose |
|---|---|
| `px4-autopilot` | The flight stack, built with `cmake.bbclass` against PX4's top-level CMakeLists (`-DCONFIG=${PX4_CONFIG}`). |
| `microcdr` | eProsima Micro CDR, normally cloned from GitHub *at compile time* by the Micro-XRCE-DDS-Client SuperBuild. |
| `microxrceddsclient` | eProsima Micro XRCE-DDS Client (PX4 fork), normally built by PX4 as a nested `ExternalProject_Add`. |
| `cyclonedds-px4-native` | Host `idlc` with the `cdrstream-desc` feature, normally bootstrapped by PX4 at configure time with a hardcoded `/usr/bin/gcc`. |

## Quick start (with kas, on ELISA Space Grade Linux)

```sh
git clone <this repo> layers/meta-aerospace
kas build layers/meta-aerospace/kas/px4-sgl-qemuarm64.yml
```

This builds `core-image-minimal` for `qemuarm64` with `px4-autopilot`
installed (default board config `px4_sitl_default`, see below).

## Carried patches (px4-autopilot)

1. **kconfig toolchain guard** — PX4's `cmake/kconfig.cmake` force-overrides
   `CMAKE_TOOLCHAIN_FILE` from the board config (`CONFIG_BOARD_TOOLCHAIN`),
   clobbering the toolchain file bitbake passes and mis-directing any
   subproject that forwards it. The patch makes the board toolchain a
   default only.
2. **`UXRCE_DDS_CLIENT_USE_SYSTEM_LIBS`** — links
   `libmicroxrcedds_client.a`/`libmicrocdr.a` + headers from the target
   sysroot instead of running the nested client build (which fetches
   Micro-CDR from the network).
3. **`PX4_BUILD_IDLC=OFF`** — skips the configure-time `git submodule` calls
   and host-gcc CycloneDDS bootstrap; `idlc` is taken from the native
   sysroot via PATH (cyclonedds' own `Generate.cmake` does
   `find_program(idlc)` when cross-compiling). Only relevant when the board
   config enables `CONFIG_LIB_CDRSTREAM`.

## Version coupling — read before bumping SRCREV

When you bump `px4-autopilot`'s SRCREV you **must** re-sync the subproject
recipes to PX4's submodule pins (`git submodule status` in the PX4 tree):

- `microxrceddsclient` SRCREV ← `src/modules/uxrce_dds_client/Micro-XRCE-DDS-Client`
  (or `…-v3` when the config sets `CONFIG_UXRCE_DDS_CLIENT_USE_DDS_V3`;
  then also switch `microcdr` to 2.0.2 — the client does
  `find_package(microcdr <ver> EXACT)`).
- `cyclonedds-px4-native` SRCREV ← `src/lib/cdrstream/cyclonedds`
  (host idlc and the target-side cdr serializer compiled into PX4 must
  come from the same sources).
- The `UCLIENT_PROFILE_*` options in `microxrceddsclient` must continue to
  match `src/modules/uxrce_dds_client/CMakeLists.txt` — they change the
  client's config header and ABI.

## Selecting the board

`PX4_CONFIG ?= "px4_sitl_default"` — override in a bbappend or your distro
config with any **posix**-platform config (e.g. `emlid_navio2_default`).

## Known limitations / out of scope

- **NuttX configs**: they spawn nested full PX4 builds (px4io coprocessor
  firmware, ROMFS UAVCAN peripheral firmware) that this layer does not
  handle.
- **Simulators**: the gazebo-classic / gz / jsbsim / flightgear
  ExternalProjects are guarded by `find_package` of the simulator dev libs
  and stay disabled as long as those are not in `DEPENDS`. The nested `gz`
  project forwards no toolchain settings, so do not enable it without
  packaging it separately.
- **Board extras**: `beaglebone/blue` fetches librobotcontrol from GitHub,
  `modalai/voxl2` builds libfc-sensor-api at configure time — package these
  separately if you target those boards.
- **Debug builds**: `src/drivers/uavcan/libdronecan` downloads googletest at
  configure time when `CMAKE_BUILD_TYPE=Debug` and the DroneCAN driver is
  enabled. Keep the default Release build type or patch it out.
- **Big-endian targets**: `microcdr` is built with default (little-endian)
  endianness config; pass `-DCONFIG_BIG_ENDIANNESS=ON` for BE machines.
- The python `-native` dependencies come from oe-core and
  meta-openembedded/meta-python (`kconfiglib`, `jsonschema`, `matplotlib`,
  …); the ones neither provides (`empy`, `lark-parser`, `pyros-genmsg`,
  `pymavlink`, `pyulog`, `nunavut`) are carried in this layer under
  `recipes-devtools/`, along with a `cerberus` newer than meta-python's.
  PX4 requires empy < 4 (the layer's 3.3.2 recipe satisfies this).
