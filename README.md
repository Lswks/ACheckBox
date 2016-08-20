# ACheckBox
[ ![Download](https://api.bintray.com/packages/bigmercu/maven/b-checkbox/images/download.svg) ](https://bintray.com/bigmercu/maven/b-checkbox/_latestVersion)

This is a simple CheckBox for Android with cool animation. 

## Import to your project
### Gradle
```
dependencies {
...
    compile 'com.example.checkbox:checkbox:1.02'
}
```

### Maven
** in project build.gradle **
``` 
 maven {
            url 'https://dl.bintray.com/bigmercu/maven/'
        }
...
```
** in module build.gradle **
```
dependencies {
  ...
    compile 'com.bigmercu.bCheckbox:BCheckbox:1.05'
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


## Usage
### In Layout File
``` xml
    <com.bigmercu.bCheckbox.BBox
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```
or

``` xml
<com.example.checkbox.BBox
        android:padding="5dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:check_text="算法"
        app:show_border="true"
        app:color_after="@color/colorAccent"
        app:color_before="@color/colorPrimary"
        app:check_style="hook"
        android:id="@+id/BBox3" />
```

### In Java File
``` java
 mBBox = (BBox) findViewById(R.id.BBox3);
        mBBox.setChecked(true);
        mBBox.setOnCheckedChangeListener(new BBox.OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
                Toast.makeText(getApplicationContext(),"click",Toast.LENGTH_SHORT).show();
            }
        });
```

---

## About
- 新浪微博@bigmercu
- Email: bigmercu@gmail.com

---

## screenShot
![](http://ww4.sinaimg.cn/large/b45f56f6gw1f6ueokzh07g207a0cxdkl.gif)

![](http://ww3.sinaimg.cn/large/b45f56f6gw1f6ueatdq0jg207a0cy40t.gif)


![](http://ww4.sinaimg.cn/large/b45f56f6gw1f6uorqbo03j219628aguj.jpg)

![](http://ww1.sinaimg.cn/large/b45f56f6gw1f6up4942pwj219628awnk.jpg)

---


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
