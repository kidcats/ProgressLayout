# ProgressLayout

ProgressLayout是一个实现了类似于进度条的layout
继承自RelativeLayout

![ProgressLayout Demo](/images/demo.png)


## 使用

引用

```gradle
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}

dependencies {
	        compile 'com.github.kidcats:ProgressLayout:eab2c4cabc
	}

```


```XML
<com.example.progresslayout.ProgressLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/progresslayout"
    android:layout_width="match_parent"
    android:layout_height="30dp"
    android:layout_marginTop="5dp"
    app:reaccolor="@color/rectcolor">

    <TextView
        android:id="@+id/text"
        android:layout_centerInParent="true"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="progresslayout"/>

</com.example.progresslayout.ProgressLayout>
```


然后在JAVA代码中

```JAVA
progressLayout= (ProgressLayout) itemView.findViewById(R.id.progresslayout);
ReadyAttrs attrs=new ReadyAttrs();
attrs.setMaxprogress(100)
                    .setAnimationdurction(2000)
                    .setProgress(15)
                    .setPaintAlpha(100)
                    .setReacolor(Color.GRAY);
 progressLayout.setReadyAttrs(attrs);
```


如果想精确的控制进度,只需要设置


```JAVA

prgresslayout.setProgress(25);
```


设置监听事件:


```JAVA
progressLayout.setOnProgressCompleteListener(this);
```

实现以下两个方法:


```JAVA
        @Override
        public void OnProgressListener(int progress) {      
    
      }

        @Override
        public void OnCompleteListener() {
    
        }
```

结束 以上~




