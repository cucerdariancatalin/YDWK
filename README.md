[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Kotlin](https://img.shields.io/badge/kotlin-1.7.10-blue.svg?logo=kotlin)](http://kotlinlang.org)

# YDWK
A discord wrapper made in kotlin(Not related to YDW)

## In progress and to be done
- [x] Connect to gateway
- [x] Parse json
- [ ] Handle all op codes - in progress
- [ ] Handle events
- [ ] Handle reconnect and resuming
- [ ] Handle rate limiting in websocket

## Future Features
- [ ] Handle slash commands
- [ ] Caching
- [ ] Create entities
- [ ] Handle Rest API


## Getting started

Add the following to your `build.gradle`:

```gradle
dependencies {
    implementation("io.github.realyusufismail:ydwk:${project.version}")
}
```
To create a default bot, add the following to your main class:

```kotlin
fun main() {
    createDefaultBot("TOKEN")
}
```

A default bot has all the recommend gateway intents.