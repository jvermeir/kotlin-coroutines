# Kotlin and coroutines

## IntelliJ settings

in Project structure
- select Kotlin facet and select 1.3 in 'language version' and 'api version'
- select modules and set 'language level' to '8 - lambdas ...'

in Preferences
- search 'kotlin compiler' and select `1.3' in language and api version. select '1.8' in 'Target JVM version'.

## Usage

1. Start DemoApplication.kt
1. On the commandline do `curl localhost:8080/greeting`
1. Log should look like this

```
2019-08-23 22:12:04.486  INFO 81912 --- [nio-8080-exec-1] Controller                               : GET /greeting
2019-08-23 22:12:05.545  INFO 81912 --- [nio-8080-exec-1] Controller                               : A is done after 1 second
2019-08-23 22:12:06.548  INFO 81912 --- [nio-8080-exec-1] Controller                               : B is done after 2 seconds
2019-08-23 22:12:06.549  INFO 81912 --- [nio-8080-exec-1] Controller                               : Result(text1=this is A, text2=this is B)
```

so 1 second after the `GET ...` message you should see `A is done....` and one second after that `B is done...`.
