LICENSE = "BSD-3-Clause & GPL-3.0-only & MIT"
LIC_FILES_CHKSUM = "file://3rd_party/libevents/LICENSE.md;md5=92eb10e2bbc58e0d704de5f23dd755ef \
                    file://3rd_party/libevents/libs/cpp/parse/nlohmann_json/LICENSE.MIT;md5=f969127d7b7ed0a8a63c2bbeae002588 \
                    file://3rd_party/libevents/libs/cpp/parse/nlohmann_json/LICENSES/GPL-3.0-only.txt;md5=8da5784ab1c72e63ac74971f88658166 \
                    file://3rd_party/libevents/libs/cpp/parse/nlohmann_json/docs/mkdocs/docs/home/license.md;md5=970ea048f6ea7d04eeb3ba3ef9ebca40 \
                    file://LICENSE.md;md5=33dbe0b02d34253608e222966ba8a875"

SRC_URI = "gitsm://github.com/PX4/pyulog.git;protocol=https;branch=main"

SRCREV = "3cf17793f14709713ab297d3743314c658874068"

S = "${WORKDIR}/git"

inherit python_setuptools_build_meta setuptools3

RDEPENDS:${PN} += "python3-core python3-crypt python3-io python3-json python3-sqlite3 python3-unittest"

do_configure:prepend () {
    sed -i -e 's|^license = "BSD-3-Clause"|license = { text = "BSD-3-Clause" }|' ${S}/pyproject.toml
}

BBCLASSEXTEND = "native nativesdk"
