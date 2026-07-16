require python3-empy.inc

inherit setuptools3

SRC_URI += " file://0001-setup.py-distutils.core-setuptools.patch"

BBCLASSEXTEND = "native nativesdk"
