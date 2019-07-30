# NetworkSenseAndroidLib [![](https://jitpack.io/v/hashimshafiq/NetworkSenseAndroidLib.svg)](https://jitpack.io/#hashimshafiq/NetworkSenseAndroidLib)

This android librray checks whether the device has the active internet connection or not. Based on the result it shows snackbar in the bottom of the app.

![Internet Connected](/images/internet.png)


## How to Add in your project?

## For Gradle

### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

``` javascript
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	} 
```

### Step 2. Add the dependency

```javascript
dependencies {
	        implementation 'com.github.hashimshafiq:NetworkSenseAndroidLib:v0.0.1'
	}
```

## For Maven

### Step 1. Add the JitPack repository to your build file

``` javascript
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

### Step 2. Add the dependency

```javascript
<dependency>
	    <groupId>com.github.hashimshafiq</groupId>
	    <artifactId>NetworkSenseAndroidLib</artifactId>
	    <version>v0.0.1</version>
	</dependency>
```
  





