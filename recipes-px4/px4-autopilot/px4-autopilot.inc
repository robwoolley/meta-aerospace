SUMMARY = "PX4 Autopilot Software"
DESCRIPTION = "PX4 is an open-source autopilot stack for drones and unmanned vehicles."
HOMEPAGE = "https://px4.io/"

LICENSE = "Apache-2.0 & BSD-3-Clause & ISC & MIT & GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=70b583e99896377e3306b74b7f33e5de \
                    file://Tools/simulation/flightgear/flightgear_bridge/LICENSE;md5=6e1e7dde6925b01deaa93b4e5853b6ea \
                    file://Tools/simulation/flightgear/flightgear_bridge/models/Rascal/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464 \
                    file://Tools/simulation/flightgear/flightgear_bridge/models/TF-G1/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464 \
                    file://Tools/simulation/flightgear/flightgear_bridge/models/TF-G2/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464 \
                    file://Tools/simulation/flightgear/flightgear_bridge/models/TF-R1/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464 \
                    file://Tools/simulation/gazebo-classic/sitl_gazebo-classic/external/OpticalFlow/external/klt_feature_tracker/LICENSE;md5=8bb358cc3157b80a69724c9680c3b87f \
                    file://Tools/simulation/gazebo-classic/sitl_gazebo-classic/models/ocean/media/materials/textures/License%20and%20source%20for%20textures.txt;md5=9c9e3236534721ac654b0c0d338433f5 \
                    file://Tools/simulation/gz/LICENSE;md5=1de42fefa17996d3d39a9404c2da8d0e \
                    file://Tools/simulation/gz/models/OakD-Lite/LICENSE;md5=ffa9f9db859f4b53a3c93714239abc99 \
                    file://Tools/simulation/gz/models/x500/LICENSE;md5=ffa9f9db859f4b53a3c93714239abc99 \
                    file://Tools/simulation/gz/models/x500_base/LICENSE;md5=ffa9f9db859f4b53a3c93714239abc99 \
                    file://Tools/simulation/gz/models/x500_depth/LICENSE;md5=ffa9f9db859f4b53a3c93714239abc99 \
                    file://Tools/simulation/jmavsim/jMAVSim/LICENSE;md5=cccfa0c50190456a6308dc5bcb75eeb5 \
                    file://Tools/simulation/jsbsim/jsbsim_bridge/LICENSE;md5=918f8ed22291f6002f70c5a7c08832f7 \
                    file://Tools/simulation/jsbsim/jsbsim_bridge/models/Rascal/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464 \
                    file://docs/LICENSE;md5=db2af4f6a0ef6a0f57b72a097e76d2ba \
                    file://docs/en/contribute/licenses.md;md5=6ac1ddb93cce7a296b7dac68998b7c3d \
                    file://docs/ko/contribute/licenses.md;md5=d81505353294d7b04be0040b3c405d64 \
                    file://docs/uk/contribute/licenses.md;md5=371a370f7b49fa6f8fbe3f7726de6000 \
                    file://docs/zh/contribute/licenses.md;md5=017561ddc7f12da26744741a01709e15 \
                    file://platforms/nuttx/NuttX/apps/LICENSE;md5=1ddfd55530e9f49cbfcc703b10638a35 \
                    file://platforms/nuttx/NuttX/apps/graphics/nxwidgets/COPYING;md5=7bd4cc5a141251192750c279e8be8f6b \
                    file://platforms/nuttx/NuttX/apps/graphics/nxwm/COPYING;md5=c44f2315b8feef0873c49daff0240584 \
                    file://platforms/nuttx/NuttX/apps/graphics/twm4nx/COPYING;md5=52452772c13f978024a5799171e95f93 \
                    file://platforms/nuttx/NuttX/apps/system/hexed/docs/license.txt;md5=655700dfbbb29a076e37352fcbb01043 \
                    file://platforms/nuttx/NuttX/nuttx/LICENSE;md5=873a0a5a678a06cb9fbb60defd25f709 \
                    file://src/drivers/actuators/vertiq_io/iq-module-communication-cpp/LICENSE;md5=2304387b6dd02f5e04d86cb2f1110b74 \
                    file://src/drivers/cyphal/legacy_data_types/LICENSE;md5=7d3361f05b20861672f15a7e1b7ac533 \
                    file://src/drivers/cyphal/libcanard/LICENSE;md5=4920367cf871a7928f658aea4914bda5 \
                    file://src/drivers/cyphal/public_regulated_data_types/LICENSE;md5=7d3361f05b20861672f15a7e1b7ac533 \
                    file://src/drivers/gps/devices/LICENSE.md;md5=05a6b7c503be243204bcaebe8000a3d0 \
                    file://src/drivers/ins/microstrain/mip_sdk/LICENSE.txt;md5=3b198295ba53ae4033b1907a75d3d5f8 \
                    file://src/drivers/ins/sbgecom/sbgECom/LICENSE.md;md5=54d358db04e52500540ef351e03fdb77 \
                    file://src/drivers/ins/sbgecom/sbgECom/src/commands/sbgEComCmdLicense.c;md5=8d7951d7f15bac60f6f2d1f0ac9e51da \
                    file://src/drivers/ins/sbgecom/sbgECom/src/commands/sbgEComCmdLicense.h;md5=1af7a9b35f4a065ca55308e2888b2f7d \
                    file://src/drivers/transponder/sagetech_mxs/sg_sdk/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327 \
                    file://src/drivers/uavcan/libdronecan/LICENSE;md5=1b59e4524bdc7bdb14e2af001b180e14 \
                    file://src/drivers/uavcan/libdronecan/dsdl/LICENSE;md5=b6720e1ab791531c9f4f63a0ab732ca9 \
                    file://src/drivers/uavcan/libdronecan/libuavcan/dsdl_compiler/pydronecan/LICENSE;md5=0249574e7552cd65846752d7e94660b9 \
                    file://src/lib/cdrstream/cyclonedds/LICENSE;md5=ca2dafd1f07f3cd353d0454d3c4d9e80 \
                    file://src/lib/cdrstream/cyclonedds/WiX/LICENSE.rtf;md5=2721e883b5b04330ce0faa3a6373a88d \
                    file://src/lib/cdrstream/rosidl/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://src/lib/cdrstream/rosidl/rosidl_generator_tests/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://src/lib/crypto/libtomcrypt/LICENSE;md5=23e7e0a32e53a2b1d35f5fd9ef053402 \
                    file://src/lib/crypto/libtommath/LICENSE;md5=23e7e0a32e53a2b1d35f5fd9ef053402 \
                    file://src/lib/crypto/monocypher/LICENCE.md;md5=16153f85fadd31fe5729ace3b46039de \
                    file://src/lib/events/libevents/LICENSE.md;md5=92eb10e2bbc58e0d704de5f23dd755ef \
                    file://src/lib/heatshrink/heatshrink/LICENSE;md5=1521f3544e7cbd0c54a8f84119828198 \
                    file://src/lib/tensorflow_lite_micro/tflite_micro/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://src/lib/tensorflow_lite_micro/tflite_micro/third_party/hexagon/LICENSE;md5=7dc66db49cc2507821318be87ca796ad \
                    file://src/lib/tensorflow_lite_micro/tflite_micro/third_party/xtensa/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://src/modules/mavlink/mavlink/COPYING;md5=54ad3cbe91bebcf6b1823970ff1fb97f \
                    file://src/modules/mavlink/mavlink/pymavlink/COPYING;md5=6ea13ec5f0f3dd35ac5b53afdc3ed9ff \
                    file://src/modules/mavlink/mavlink/pymavlink/generator/javascript/local_modules/jspack/LICENSE;md5=312dd5360f685408b04fb52e84940c4a \
                    file://src/modules/mavlink/mavlink/pymavlink/generator/javascript/local_modules/long/LICENSE;md5=d273d63619c9aeaf15cdaf76422c4f87 \
                    file://src/modules/uxrce_dds_client/Micro-XRCE-DDS-Client/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://src/modules/zenoh/zenoh-pico/LICENSE;md5=d296d6e2747ca8f5caae4b30fdad6b21 \
                    file://test/fuzztest/LICENSE;md5=f4b36d5be4d90b652fde6c285eecd437"

#         python3-pandas-native 

DEPENDS += "\
    microcdr \
    microxrceddsclient \
    cyclonedds-px4-native \
    nunavut-native \
    pymavlink-native \
    pyros-genmsg-native  \
    python3-argcomplete-native \
    python3-cerberus-native \
    python3-coverage-native \
    python3-empy-native \
    python3-future-native \
    python3-jinja2-native \
    python3-jsonschema-native  \
    python3-kconfiglib-native \
    python3-lark-parser-native \
    python3-lxml-native \
    python3-matplotlib-native \
    python3-numpy-native \
    python3-packaging-native \
    python3-pkgconfig-native \
    python3-psutil-native \
    python3-pycryptodome-native \
    python3-pygments-native \
    python3-pyserial-native \
    python3-pyyaml-native \
    python3-requests-native \
    python3-setuptools-native \
    python3-six-native \
    python3-sympy-native \
    python3-toml-native \
    python3-wheel-native \
    pyulog-native \
"
inherit cmake python3native pkgconfig
