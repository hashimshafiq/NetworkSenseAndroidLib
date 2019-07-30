# NetworkSenseAndroidLib

This android librray checks whether the device has the active internet connection or not. Based on the result it shows snackbar in the bottom of the app.

## Images

![Internet Not Connected](/images/no-internet.jpg)


![Internet Connected](/images/connected.jpg)


## How to Add in your project?

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
  





