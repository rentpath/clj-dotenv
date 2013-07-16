# dotenv

#### A Clojure library designed to impliment the functionality of the dotenv RubyGem on the JVM.

Read a file of environment key=value pairs and load them into the JVM's System Properties.

## Usage

In project.clj :dependencies

    [org.clojars.jackmorrill/dotenv "0.1.0"]

In your application ns macro

    (:require [dotenv.core :as dotenv])

In your application program (the environment variable file name defaults to ".env").

    (dotenv/load-env)

or specify a filename

    (dotenv/load-env ".env.test")


Add your application configuration to your .env file in the root of your project.

    S3_BUCKET=YOURS3BUCKET
    SECRET_KEY = "YOURSECRETKEYGOESHERE"

You can also create files per environment, such as .env.test.

    S3_BUCKET=tests3bucket
    SECRET_KEY = "testsecretkey"

An alternate yaml-like syntax is supported:

    S3_BUCKET: yamlstyleforyours3bucket
    SECRET_KEY: thisisalsoanokaysecret

Your application only needs to call dotenv.core/load-env once

    
Whenever your application loads, these variables will be available in the JVM System Properties.

    (System/getProperty "S3_BUCKET")

The dotenv library is intended to be used with the [org.clojars.jackmorrill/environs "0.1.0"] library.

    (:require [environs.core :as environs])

    (environs/get-env "S3_BUCKET")


## License

Copyright (c) 2013 by Jack Morrill. All rights reserved. 

Distributed under the Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php).
