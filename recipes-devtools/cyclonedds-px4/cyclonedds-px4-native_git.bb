SUMMARY = "Eclipse Cyclone DDS idlc compiler (PX4 fork with cdrstream-desc)"
DESCRIPTION = "Host build of the CycloneDDS IDL compiler from PX4's fork. \
PX4's cdrstream support (CONFIG_LIB_CDRSTREAM) needs an idlc with the \
cdrstream-desc feature, which released CycloneDDS tool packages do not \
ship; PX4 normally bootstraps it at configure time with the host's \
/usr/bin/gcc. This recipe provides it from the native sysroot instead \
(PX4 is then configured with -DPX4_BUILD_IDLC=OFF)."
HOMEPAGE = "https://github.com/px4/cyclonedds"
LICENSE = "EPL-2.0 | EDL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ca2dafd1f07f3cd353d0454d3c4d9e80"

DEPENDS = "bison-native"

# SRCREV must match the SHA of the PX4 submodule src/lib/cdrstream/cyclonedds
# for the PX4 revision being built, so that the host idlc and the target-side
# cdr serializer sources stay in sync.
SRC_URI = "git://github.com/px4/cyclonedds;protocol=https;nobranch=1"
SRCREV = "314887ca403c2fb0a0316add22672102936ed36c"

PV = "0.11+git"

S = "${WORKDIR}/git"

inherit cmake native

# Feature set copied from PX4's configure-time idlc bootstrap in
# msg/CMakeLists.txt (minus the hardcoded compiler and ccache launchers).
EXTRA_OECMAKE = " \
    -DBUILD_EXAMPLES=OFF \
    -DENABLE_SSL=OFF \
    -DENABLE_SECURITY=OFF \
    -DBUILD_DDSPERF=OFF \
    -DENABLE_LTO=OFF \
    -DENABLE_LIFESPAN=OFF \
    -DENABLE_DEADLINE_MISSED=OFF \
    -DENABLE_NETWORK_PARTITIONS=OFF \
    -DENABLE_SOURCE_SPECIFIC_MULTICAST=OFF \
    -DENABLE_IPV6=OFF \
    -DENABLE_TYPE_DISCOVERY=OFF \
    -DENABLE_TOPIC_DISCOVERY=OFF \
"
