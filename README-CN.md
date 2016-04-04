JJSearchViewAnim
============================
![](http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2kefqi8ekj205s05s749.jpg)

####一个炫酷的SearchView搜索动画库，希望你希望！

###说说
<table>
  <thead>
    <tr>
      <th>设计图</th>
      <th> App Demo </th>
      <th>设计者</th>
      <th>相关类名</th>
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
      <td>Nicol¨¢s J. Engler</td>
      <td>JJChangeArrowController</td>
    </tr>
    <tr>
      <td><img src="http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2gzyzljmyg20an05h0t0.gif" width="240"></td>
       <td><img src="http://ww3.sinaimg.cn/mw690/7ef01fcagw1f2kfx644s8g20b505lglq.gif" width="240"></td>
        <td>Rahul Bhosale</td>
      <td>JJCircleToLineAlphaController</td>
    </tr>
    <tr>
      <td><img src="http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2gzywvmklg20an05hk2w.gif" width="240"></td>
       <td><img src="http://ww2.sinaimg.cn/mw690/7ef01fcagw1f2kfx6egogg20b505lq3r.gif" width="240"></td>
       <td>Boris Kirov</td>
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
* 注意：最后一个效果[MaterialSearchView](https://github.com/android-cjj/MaterialSearchView)，由于之前有写过，就没有集合进去了.

###使用说明
#### (1) 在布局文件xml中
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
#### (2) 在java代码中
```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JJSearchView mJJSearchView = (JJSearchView) findViewById(R.id.jjsv);
        mJJSearchView.setController(new JJChangeArrowController());
    }
```
#### (3) 设置动画开启及恢复
```java
mJJSearchView.startAnim();
mJJSearchView.resetAnim();
```




####前言：周末强撸一个库,差点灰飞烟灭.无妨,人生自古谁无死，来生继续撸代码.

立马如主题，几乎每个App都有搜索功能，然后形式都是千篇一律。我举个例子吧，就微信来说：

![](https://camo.githubusercontent.com/866cc7d275236caddf7330c35ebeda6a94f94d40/687474703a2f2f7777772e61706b6275732e636f6d2f646174612f6174746163686d656e742f666f72756d2f3230313530382f30372f313631303231723330336a6e73707377366b336a6d702e706e67)

显示一个搜索的图标，点击跳到另一个界面，输入要搜索的东西

![](https://camo.githubusercontent.com/b6808c86f8456b9f9e2b34d88108ecb6476fdab7/687474703a2f2f7777772e61706b6275732e636f6d2f646174612f6174746163686d656e742f666f72756d2f3230313530382f30372f3136313032326f6c6d726e75696d6d66696d316d6d622e706e67)

现在大部分App都是用这种方式了。我是希望能有App把这个功能做得酷炫点，毕竟它也是用户经常要用到的，给用户良好的体验还是很重要的。
为此，我实现了别人设计的一些SearchView酷炫效果，可能不是很像，你就勉强看看吧。

<img src="http://ww3.sinaimg.cn/mw690/7ef01fcagw1f2gzz0570bg20an05hmxv.gif" width="380">

<img src="http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2gzyysygrg20an05h3zb.gif" width="380">

<img src="http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2gzyzdp5vg20an05hgng.gif" width="380">










####杂谈
SearchView几乎是每个App必备的，做得炫酷点可以给用户好的体验。但是，我们都知道，一个App只能有一种风格，所以加入很多样式的动画是没必要的。我觉得你可以参考我的实现，修改成合适自己的。当然，水平有限及写的随意，该库还是有不少问题，也希望你能PR,完善它。


####关于我
如果你喜欢这个东东的话，可以关注我[github](https://github.com/android-cjj) ,也可以关注我微博[Android_cJJ](http://weibo.com/chenjijun2011/).


License
=======

    The MIT License (MIT)

	Copyright (c) 2015 android-cjj

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










