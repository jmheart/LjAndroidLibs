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
	      compile 'com.github.jmheart:LjAndroidLibs:0.01'
	}
	
	
网络请求：

	LjNet.get(String url,Map<String,String> map,final LjNetCallBack nLjNetCallBack);
        
	
图片加载
  LJTools.showPxFrescoImage(SimpleDraweeView, "http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg", wight, hight);
