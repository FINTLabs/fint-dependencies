# FINT dependencies

[![Build Status](https://travis-ci.org/FINTlibs/fint-dependencies.svg?branch=master)](https://travis-ci.org/FINTlibs/fint-dependencies) 
[![Coverage Status](https://coveralls.io/repos/github/FINTlibs/fint-dependencies/badge.svg?branch=master)](https://coveralls.io/github/FINTlibs/fint-dependencies?branch=master)

## Installation

```groovy
repositories {
    maven {
        url  "http://dl.bintray.com/fint/maven" 
    }
}

compile('no.fint:fint-dependencies:0.0.2')
```

## Usage

Add `@EnableFintDependencies` to the main Application class

```java
@EnableFintDependencies
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

Add `dependencyReport.gradle` to the build.gradle file:  
https://github.com/FINTlibs/fint-buildscripts#dependencyreportgradle

Send a GET request to `/fint-dependencies`
