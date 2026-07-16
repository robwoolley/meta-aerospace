SUMMARY = "Lightweight, extensible schema and data validation tool for Pythondictionaries."
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=48f8e9432d0dac5e0e7a18211a0bacdb"

SRC_URI = "git://github.com/pyeve/cerberus.git;protocol=https;branch=1.3.x"

SRCREV = "f2221c5a901bbf8618efb694ef9364bd0882ac9a"

S = "${WORKDIR}/git"

inherit python_setuptools_build_meta

BBCLASSEXTEND = "native nativesdk"
