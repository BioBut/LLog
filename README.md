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
