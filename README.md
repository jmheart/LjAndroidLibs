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
