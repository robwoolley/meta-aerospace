SUMMARY = "Generate code from DSDL using Jinja2 templates."
HOMEPAGE = "https://opencyphal.org"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=3a5c3e2a83f5250497fa70efb124fdec \
                    file://submodules/CETL/LICENSE;md5=618fd3130e30b46e6c5fa640ad7dd4c4 \
                    file://submodules/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://submodules/o1heap/LICENSE;md5=04de8f5e31b94d40ba7ecb3cdedc92ff \
                    file://submodules/public_regulated_data_types/LICENSE;md5=7d3361f05b20861672f15a7e1b7ac533 \
                    file://submodules/unity/LICENSE.txt;md5=b7dd0dffc9dda6a87fa96e6ba7f9ce6c"

SRC_URI = "gitsm://github.com/OpenCyphal/nunavut.git;protocol=https;branch=main"

SRCREV = "7ecfd68a38fc652d3bb40e1e97975ce78cc2c9b1"

S = "${WORKDIR}/git"

inherit setuptools3

RDEPENDS:${PN} += "python3-core python3-doctest python3-io python3-json python3-logging python3-unittest"

BBCLASSEXTEND = "native"
