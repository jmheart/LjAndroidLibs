# LjAndroidLibs
android studio快速开发工具包
2017年2.20号想做一件有有意义的事情，维护一个android studio的android快速开发工具包。
一.使用方式
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.jmheart:LjAndroidLibs:-SNAPSHOT'
	}
二.程序分为四个模块
1.Base基类
    BaseActivity
    BaseAdapter
    BaseApplication
    BaseFragment
2.Net网络请求类
    LjNet
3.utils工具类
    CommTools
4.views自定义view
    CustomerScrollView弹性的scrollview
