# ACheckBox
 [ ![Download](https://api.bintray.com/packages/bigmercu/maven/cBox/images/download.svg) ](https://bintray.com/bigmercu/maven/cBox/_latestVersion)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ACheckBox-green.svg?style=true)](https://android-arsenal.com/details/1/4183)

This is a simple CheckBox for Android with cool animation. 

## Import to your project
### Gradle
```
compile 'com.bigmercu.cBox:cbox:1.08'
```

### Maven
#### in  build.gradle of your project
``` 
allprojects {
    repositories {
        jcenter()
        maven {
            url 'https://dl.bintray.com/bigmercu/maven/'
        }
    }
}
...
```
#### in build.gradle of your Module
```
dependencies {
  ...
    compile 'com.bigmercu.cBox:cbox:1.08'
}

```


## Attrs
|attr|format|
|---|:---|:---:|
|stroke_width|dimension|
|color_before|color|
|color_after|color|
|check_text|string|
|check_style|fork/hook|
|show_border|boolean|
|is_circle_border|boolean|


## Usage
### In Layout File
``` xml
<com.bigmercu.cBox.CheckBox
        android:padding="5dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:check_text="算法"
        app:show_border="true"
        app:color_after="@color/colorAccent"
        app:color_before="@color/colorPrimary"
        app:check_style="hook"
        app:is_circle_border="true"/>
```

### In Java File
``` java
        mCheckBox.setChecked(boolean);
        mCheckBox.setOnCheckedChangeListener(new CheckBox..OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
            }
        });
        mCheckBox.isChecked()
```

---

## screenShot
![](http://ww2.sinaimg.cn/large/b45f56f6gw1f71mvl0htlg20ds06igmg.gif)
![](http://ww3.sinaimg.cn/large/b45f56f6gw1f71ml8iizyg204y08su0x.gif)


## what's new
- 2016-08-21:add the circle border and lots of Code refactoring.
- 2016-08-15:first update.

---

## About
- 新浪微博: [@bigmercu](http://weibo.com/bigmercu)
- Email: bigmercu@gmail.com

##License
```
   Copyright 2016 bigmercu

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
