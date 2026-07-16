SUMMARY = "Standalone Python library for generating ROS message and service data structures for various languages."
HOMEPAGE = "http://wiki.ros.org/genmsg"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/genmsg/__init__.py;beginline=1;endline=31;md5=1efb5d9a0c0d143cb13e879ab1fce08d"

SRC_URI = "git://github.com/ros/genmsg.git;protocol=https;branch=noetic-devel \
           file://replace-catkin.patch"

SRCREV = "393871225e1458d2a8db41761759e57ca01a1801"

S = "${WORKDIR}/git"

inherit python_setuptools_build_meta

RDEPENDS:${PN} += "python3-core python3-math python3-empy"

BBCLASSEXTEND = "native nativesdk"
