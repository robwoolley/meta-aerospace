SUMMARY = "eProsima Micro CDR serialization library"
DESCRIPTION = "A de/serialization mechanism designed for resource-limited \
devices, implementing the OMG CDR standard. Dependency of the eProsima \
Micro XRCE-DDS Client used by PX4's uxrce_dds_client module."
HOMEPAGE = "https://github.com/eProsima/Micro-CDR"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

# The recipe version must match the client's pin exactly: the
# Micro-XRCE-DDS-Client CMakeLists.txt does find_package(microcdr <ver> EXACT).
# The client pinned by PX4's Micro-XRCE-DDS-Client submodule requires 2.0.1;
# the -v3 client (CONFIG_UXRCE_DDS_CLIENT_USE_DDS_V3) requires 2.0.2
# (tag v2.0.2 = be22d10102447fb2ab6e701fee453ca0b2b0ccf6).
SRC_URI = "git://github.com/eProsima/Micro-CDR.git;protocol=https;nobranch=1"
# tag v2.0.1
SRCREV = "3d1b17703c7cf4f22def2910bc845bdb5152d7b5"

S = "${WORKDIR}/git"

inherit cmake

# Match the options PX4 passes when it builds the client itself
# (src/modules/uxrce_dds_client/CMakeLists.txt): static library, no PIC.
EXTRA_OECMAKE = " \
    -DBUILD_SHARED_LIBS=OFF \
    -DUCDR_PIC=OFF \
    -DUCDR_BUILD_TESTS=OFF \
"

# Static library and headers only.
ALLOW_EMPTY:${PN} = "1"
