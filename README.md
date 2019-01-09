# react-native-tencent-bugly

tencent bugly for react native

### Install 安装
```
npm i git+https://github.com/yuzhiyi/react-native-tencent-bugly.git --save
```

### Import 导入
```
react-native link react-native-tencent-bugly
```

在 app/src/main/res 下新建文件夹 xml，在 xml 目录下新建文件 provider_paths_bugly.xml，provider_paths_bugly.xml 里
填写以下代码．
```
<?xml version="1.0" encoding="utf-8"?>
<paths xmlns:android="http://schemas.android.com/apk/res/android">
    <!-- /storage/emulated/0/Download/${applicationId}/.beta/apk-->
    <external-path name="beta_external_path" path="Download/"/>
    <!--/storage/emulated/0/Android/data/${applicationId}/files/apk/-->
    <external-path name="beta_external_files_path" path="Android/data/"/>
</paths>
```

在 MainApplication 同级目录下新建文件夹 utils，utils 目录下新建文件 BuglyFileProvider.java，BuglyFileProvider.java 里
填写以下代码．
```
package <这里填写包名字>.utils;

import android.support.v4.content.FileProvider;

public class BuglyFileProvider extends FileProvider {

}
```

在 AndroidManifest.xml 文件中，在和 package 同层的地方添加 xmlns:tools.
```
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.yunpingweb"
    xmlns:tools="http://schemas.android.com/tools">
</manifest>
   
```

在 application 标签内部(Activity 注册同层)填写以下代码.
```
provider
    android:name=".utils.BuglyFileProvider"
    android:authorities="<这里填写包名>.fileProvider"
    android:exported="false"
    android:grantUriPermissions="true"
    tools:replace="name,authorities,exported,grantUriPermissions">
    <meta-data
        android:name="android.support.FILE_PROVIDER_PATHS"
        android:resource="@xml/provider_paths_bugly"
        tools:replace="name,resource"/>
</provider>
```

在 MainApplication.java 文件中导入 Bugly，在顶部填写以下代码.
```
import com.bugly.BuglyModule;
```
在 MainApplication.java 的 onCreate 方法内填写以下代码.
```
BuglyModule.init(getApplicationContext(), <这里填写在 bugly 申请到的App ID>, false);
```

如果不想在 debug 版本收到更新消息,可以在 BuglyModule.init 前加上 if(!BuildConfig.DEBUG).
```
if(!BuildConfig.DEBUG){
  BuglyModule.init(getApplicationContext(), <这里填写在bug申请到的App ID>, false);
}
```

### Usage
```
import Bugly from 'react-native-tencent-bugly';

// 手动检测更新
Bugly.checkUpgrade(); 
```

PR's welcome!

