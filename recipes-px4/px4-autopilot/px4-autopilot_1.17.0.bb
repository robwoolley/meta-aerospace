require px4-autopilot.inc

SRC_URI = "gitsm://github.com/PX4/PX4-Autopilot.git;protocol=https;branch=release/1.17 \
           file://0001-cmake-kconfig-respect-an-externally-provided-CMAKE_T.patch \
           file://0002-uxrce_dds_client-support-linking-pre-built-Micro-XRC.patch \
           file://0003-msg-support-using-a-pre-built-CycloneDDS-idlc.patch \
           file://0004-build-add-px4-sitl-deb-packages.patch \
           file://0005-replace-dpkg-with-option.patch"

SRCREV = "d6f12ad1c4f70ad3230afd7d86e971421e02fef4"

S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
    -DCMAKE_INSTALL_PREFIX=/opt/px4 \
    -DCONFIG=px4_sitl_default \
    -DPX4_PACKAGE=ON \
    -DPX4_BINARY_DIR=/opt/px4 \
"

FILES:${PN} += "/opt/px4"
FILES:${PN} += " \
    /opt/px4/etc \
    /opt/px4/share \
"
