import {
    NativeModules
} from 'react-native';

const BuglyModule = NativeModules.BuglyModule;

const Bugly = {
    checkUpgrade() {
        BuglyModule.checkUpgrade();
    }
};

module.exports = Bugly;
