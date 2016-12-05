JJSearchViewAnim
============================
[中文版文档及相关文章](https://github.com/android-cjj/JJSearchViewAnim/blob/master/README-CN.md)

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-JJSearchViewAnim-green.svg?style=true)](https://android-arsenal.com/details/1/3390)

![](http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2kefqi8ekj205s05s749.jpg)

####A cool search view animation library ,I hope you like it.

###look
<table>
  <thead>
    <tr>
      <th>Design</th>
      <th>Demo</th>
      <th>Designer</th>
      <th>Class</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><img src="http://ww3.sinaimg.cn/mw690/7ef01fcagw1f2gzz0570bg20an05hmxv.gif" width="240"></td>
        <td><img src="http://ww2.sinaimg.cn/mw690/7ef01fcagw1f2kfx45rqyg20b505lq3b.gif" width="240"></td>
      <td>Nick</td>
      <td>JJDotGoPathController</td>
    </tr>
    <tr>
      <td><img src="http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2gzyysygrg20an05h3zb.gif" width="240"></td>
       <td><img src="http://ww3.sinaimg.cn/mw690/7ef01fcagw1f2kfx4n06bg20b505l0te.gif" width="240"></td>
       <td>Oleg Frolov</td>
      <td>JJAroundCircleBornTailController</td>
    </tr>
    <tr>
      <td><img src="http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2gzyx8egbg20an05h3zl.gif" width="240"></td>
       <td><img src="http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2kfx516l3g20b505laa3.gif" width="240"></td>
      <td>sandeep virk</td>
      <td>JJBarWithErrorIconController</td>
    </tr>
    <tr>
      <td><img src="http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2gzz1dsvsg20an06ltbr.gif" width="240"></td>
       <td><img src="http://ww3.sinaimg.cn/mw690/7ef01fcagw1f2kfx5ckjsg20b505lt97.gif" width="240"></td>
     <td>Jurre Houtkamp</td>
      <td>JJScaleCircleAndTailController</td>
    </tr>
    <tr>
      <td><img src="http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2gzyzdp5vg20an05hgng.gif" width="240"></td>
       <td><img src="http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2kg8o2htzg20b505ljrj.gif" width="240"></td>
      <td> Rahul Bhosale</td>
      <td>JJChangeArrowController</td>
    </tr>
    <tr>
      <td><img src="http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2gzyzljmyg20an05h0t0.gif" width="240"></td>
       <td><img src="http://ww3.sinaimg.cn/mw690/7ef01fcagw1f2kfx644s8g20b505lglq.gif" width="240"></td>
        <td>Nicolás J. Engler</td>
      <td>JJCircleToLineAlphaController</td>
    </tr>
    <tr>
      <td><img src="http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2gzywvmklg20an05hk2w.gif" width="240"></td>
       <td><img src="http://ww2.sinaimg.cn/mw690/7ef01fcagw1f2kfx6egogg20b505lq3r.gif" width="240"></td>
       <td>  Boris Kirov </td>
      <td>JJCircleToBarController</td>
    </tr>
    <tr>
      <td><img src="http://ww4.sinaimg.cn/mw690/7ef01fcagw1f2gzyxopnfg20an05haaa.gif" width="240"></td>
       <td><img src="http://ww4.sinaimg.cn/mw690/7ef01fcagw1f2kfx6owemg20b505laav.gif" width="240"></td>
       <td>Anish Chandran</td>
      <td>JJCircleToSimpleLineController</td>
    </tr>
     <tr>
      <td><img src="http://ww2.sinaimg.cn/mw690/7ef01fcagw1f2gzz0xbkfg20an05hq47.gif" width="240"></td>
       <td><img src="https://camo.githubusercontent.com/8220bd55683ee57442aef6c833e1a971d07b6429/687474703a2f2f7777772e61706b6275732e636f6d2f646174612f6174746163686d656e742f666f72756d2f3230313530382f30372f313632343332673033696c7a7a69373335696d686d382e676966" width="240"></td>
        <td>Antonio Di Nardo</td>
      <td> MaterialSearchView</td>
    </tr>
  </tbody>
</table>
* The last effect you can find here:[MaterialSearchView](https://github.com/android-cjj/MaterialSearchView)

###Usage
#### (1) In xml
```xml
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.cjj.jjsearchviewanim.MainActivity">

    <com.cjj.sva.JJSearchView
        android:id="@+id/jjsv"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
 </RelativeLayout>
```
#### (2) In java
```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JJSearchView mJJSearchView = (JJSearchView) findViewById(R.id.jjsv);
        mJJSearchView.setController(new JJChangeArrowController());
    }
```
#### (3) Setting
```java
mJJSearchView.startAnim();
mJJSearchView.resetAnim();
```

####Thanks:

[http://www.materialup.com/posts/search-0c73a055-dcc9-486f-8540-f9517204edf8](http://www.materialup.com/posts/search-0c73a055-dcc9-486f-8540-f9517204edf8)

[http://www.materialup.com/posts/search-bar-concept](http://www.materialup.com/posts/search-bar-concept)

[http://www.materialup.com/posts/search-inspiration](http://www.materialup.com/posts/search-inspiration)

[http://www.materialup.com/posts/search](http://www.materialup.com/posts/search)

[http://www.materialup.com/posts/search-input-focus-animation](http://www.materialup.com/posts/search-input-focus-animation)

[http://www.materialup.com/posts/material-search](http://www.materialup.com/posts/material-search)

[http://www.materialup.com/search?q=search](http://www.materialup.com/search?q=search)

[http://www.materialup.com/posts/css3-jquery-material-design-close-animation](http://www.materialup.com/posts/css3-jquery-material-design-close-animation)


####About me
A low-level android software development engineer, like watching cartoons, like playing football, love life ! If you want to make friends with me, You can email tell me.Email address: cjjcjj2014@gmail.com.


License
=======

    The MIT License (MIT)

	Copyright (c) 2016 android-cjj

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all
	copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	SOFTWARE.










