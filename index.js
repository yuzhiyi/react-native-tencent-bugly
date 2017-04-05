import {
    NativeModules,
    Platform,
    DeviceEventEmitter
} from 'react-native';

const BuglyModule = NativeModules.BuglyModule;

class Bugly {
    checkUpgrade() {
        BuglyModule.checkUpgrade();
    }
}

module.exports = BuglyModule;