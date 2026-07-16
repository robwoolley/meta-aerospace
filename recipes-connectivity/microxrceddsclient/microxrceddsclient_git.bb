SUMMARY = "eProsima Micro XRCE-DDS Client (PX4 fork)"
DESCRIPTION = "Client library implementing the DDS-XRCE protocol, built \
from PX4's fork with the exact configuration PX4's uxrce_dds_client \
module expects. Replaces the nested ExternalProject build inside PX4, \
which fetches Micro-CDR from the network at build time."
HOMEPAGE = "https://github.com/PX4/Micro-XRCE-DDS-Client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "microcdr"

# SRCREV must match the SHA of the PX4 submodule
# src/modules/uxrce_dds_client/Micro-XRCE-DDS-Client for the PX4 revision
# being built (branch "px4"). If PX4 is configured with
# CONFIG_UXRCE_DDS_CLIENT_USE_DDS_V3, use the Micro-XRCE-DDS-Client-v3 pin
# instead (branch "px4-release/3", c88fb537e89a1095c49a6a535a55378d4c14cf2c)
# together with microcdr 2.0.2.
SRC_URI = "git://github.com/PX4/Micro-XRCE-DDS-Client.git;protocol=https;branch=px4 \
           file://remove-dependency-on-px4-autopilot.patch"
SRCREV = "711aef423edd1820347b866d1e4164832df35d04"

PV = "2.0.1+git"

S = "${WORKDIR}/git"

inherit cmake

# Mirror the configuration PX4 applies in
# src/modules/uxrce_dds_client/CMakeLists.txt. The UCLIENT_PROFILE_* options
# change the library ABI (they are baked into the client config header), so
# they must match what the PX4 module was built against.
# UCLIENT_SUPERBUILD=OFF together with UCLIENT_BUILD_MICROCDR=OFF makes the
# build use find_package(microcdr) from the sysroot instead of fetching
# Micro-CDR with ExternalProject.
EXTRA_OECMAKE = " \
    -DBUILD_SHARED_LIBS=OFF \
    -DUCLIENT_SUPERBUILD=OFF \
    -DUCLIENT_BUILD_MICROCDR=OFF \
    -DUCLIENT_PIC=OFF \
    -DUCLIENT_PROFILE_TCP=OFF \
    -DUCLIENT_PROFILE_UDP=ON \
    -DUCLIENT_PROFILE_SERIAL=ON \
    -DUCLIENT_PROFILE_DISCOVERY=OFF \
    -DUCLIENT_PROFILE_CUSTOM_TRANSPORT=OFF \
    -DUCLIENT_PROFILE_MULTITHREAD=OFF \
    -DUCLIENT_PROFILE_SHARED_MEMORY=OFF \
    -DUCLIENT_PLATFORM_POSIX=ON \
    -DUCLIENT_BUILD_TESTS=OFF \
    -DUCLIENT_BUILD_EXAMPLES=OFF \
"

# Static library and headers only.
ALLOW_EMPTY:${PN} = "1"

FILES:${PN}-dev += "${datadir}/microxrcedds_client"
