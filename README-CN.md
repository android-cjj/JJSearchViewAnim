JJSearchViewAnim
============================
![](http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2kefqi8ekj205s05s749.jpg)

####一个炫酷的SearchView搜索动画库，希望你喜欢！


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

###概要

#####前言：周末强撸一个库,差点灰飞烟灭.无妨,人生自古谁无死，来生继续撸代码.

立马入主题，几乎每个App都有搜索功能，然而形式千篇一律。我举个例子吧，就微信来说：

![](https://camo.githubusercontent.com/866cc7d275236caddf7330c35ebeda6a94f94d40/687474703a2f2f7777772e61706b6275732e636f6d2f646174612f6174746163686d656e742f666f72756d2f3230313530382f30372f313631303231723330336a6e73707377366b336a6d702e706e67)

显示一个搜索的图标，点击跳到另一个界面，输入要搜索的东西

![](https://camo.githubusercontent.com/b6808c86f8456b9f9e2b34d88108ecb6476fdab7/687474703a2f2f7777772e61706b6275732e636f6d2f646174612f6174746163686d656e742f666f72756d2f3230313530382f30372f3136313032326f6c6d726e75696d6d66696d316d6d622e706e67)

现在大部分App都是用这种方式了。我是希望能有App把这个功能做得酷炫点，毕竟它也是用户经常要用到的，给用户良好的体验还是很重要的。
为此，我实现了别人设计的一些SearchView酷炫效果，可能不是很精致，你就勉强看看吧。

此时，如果你看完表格那些动画，喜欢上它时，想知道他们是怎么在代码中实现的，没问题，我这就手把手教你撩一个绚丽的SearchViewAnim ， 呵呵，有点吹大了，说说我怎么实现的吧。

###实现思路

我们先对第一行表格的设计图进行仔细观察 ,效果是SearchView是由一个圆圈和一条直线（尾巴）构成的，开启动画时，尾巴慢慢消失成一点，然后这一点（dot） 进入圆圈内时，泛起波纹，在圈内四处逗留，然后在圆圈中心点停留闪烁，短暂的思考了下人生，又冲出去乖乖做一条尾巴。

咳，这是一个顿悟生命的dot啊!

相信大家通过我形象的描述已经知道效果是怎样了，现在就把刚刚描叙的画出来吧。

###实现绘制

####(1) 自定义类SearchView继承View

重写` onDraw(Canvas canvas)`方法,利用画笔Paint在画布Canvas绘制一个普通的的视图，如下：

![](http://ww1.sinaimg.cn/mw690/7ef01fcagw1f2knk6pazwj20b408cmwz.jpg)

这里有两种画法：

1.横向画圆、画直线后，旋转画布45度
```java
canvas.rotate(45, cx, cy);
canvas.drawLine(cx + cr, cy, cx + cr * 2, cy, paint);
canvas.drawCircle(cx, cy, cr, paint);
```
2.直接算出坐标点绘制
```java
 canvas.drawCircle(cx, cy, cr, paint);
 canvas.drawLine(cx + cr * sign, cy + cr * sign, scx, cy + cr * 2 * sign, paint);
```
这一步比较简单，就不多说了。

####(2) 实现动画效果，这里的动画有dot进入圈圈时泛起的波浪效果和dot在圈圈内的运行轨迹。

因为运行轨迹是固定的，我们把经过的路径设置给Path,在构造`PathMeasure`函数（不知道PathMeasure用法的同学自己搜索学习），使用它两个方法`getLength()`,.可获取dot运行路径的长度,`getPosTan(float distance, float pos[],float tan[])`可根据distance可以获取dot的坐标点pos[].
写成代码就是：
```java
//创建0~mPathMeasure.getLength()的过度动画值
 ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, mPathMeasure.getLength());
 valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mPro = (float) valueAnimator.getAnimatedValue();
                if (null != pathMeasure)
                    pathMeasure.getPosTan(mPro, mPos, null);//获取当前点坐标保存到mPos[]
                getSearchView().invalidate();//调用ondraw()函数
            }
        });
```

至于dot进入圈圈时泛起的波浪效果，其实就是曲线的不断扩大而已，这里我们可以利用贝塞尔函数`quadTo()`,不断改变控制点来实现该效果。

####（3）收尾Reset

因为结束动画之后，视图和开始时一样，所以我们并不需要绘制Reset时的动画，只需重置状态就可以了，而如果是有些情况，比如动画停止后是箭头的效果，就需要要逆着回去绘制SearchView的过程了。

其他动画效果也是这样一步一步把复杂的东西简单化，最后你发现无非就是画线、画曲线、画弧、画圆这些，我就偷个懒，不讲剩下效果的的实现方式了，自己看看源码，可能比我吹水有用的多。

###杂谈
写这些花费的时间、精力还是挺多的，因为需要一些数学计算（我数学烂）和不断的调试才能绘制满意的效果，所以建议如果项目需要，可以在别人实现的轮子上改改就好。我们都知道，一个App只能有一种风格，所以加入很多样式的动画是没必要的，修改一种合适自己的就好。

水平有限及写的随意，该库还是有不少问题，也希望你能PR,完善它。


###关于我
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










