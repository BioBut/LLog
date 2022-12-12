# LLog
Log util

## Download


### Gradle
Add the dependency below to your **module**'s `build.gradle` file:
```gradle
dependencies {
    implementation "io.github.hsongxian:log:1.0.0"
}
```


### SNAPSHOT
[![Bindables](https://img.shields.io/static/v1?label=snapshot&message=bindables&logo=apache%20maven&color=C71A36)](https://oss.sonatype.org/content/repositories/snapshots/com/github/skydoves/bindables/) <br>
Snapshots of the current development version of Bindables are available, which track [the latest versions](https://oss.sonatype.org/content/repositories/snapshots/com/github/skydoves/bindables/).
```Gradle
repositories {
   maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
}


## Hello World
The second is to write the Hello World program:


```java
public class HelloWorld {
    public static void main(String[] args) {
        LLog.init("TAG",true);
        LLog.d("Hello world");
    }
}
```
