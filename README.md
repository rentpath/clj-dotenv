# dotenv.core

A Clojure library designed to impliment the functionality of the dotenv RubyGem on the JVM


## Usage

Add your application configuration to your .env file in the root of your project:

    S3_BUCKET=YOURS3BUCKET
    SECRET_KEY = "YOURSECRETKEYGOESHERE"

You can also create files per environment, such as .env.test.

    S3_BUCKET=tests3bucket
    SECRET_KEY = "testsecretkey"

An alternate yaml-like syntax is supported:

    S3_BUCKET: yamlstyleforyours3bucket
    SECRET_KEY: thisisalsoanokaysecret

Your application only needs to call dotenv.core/load-env once:

    (:require [dotenv.core :as dotenv])

    (dotenv/load-env)  ;; Filename defaults to ".env"

    (dotenv/load-env ".env.test")

    
Whenever your application loads, these variables will be available in the JVM System Properties:

    (System/getProperty "S3_BUCKET")

The dotenv library is intended to be used with the environs.core library:

    (:require [environs.core :as environs])

    (environs/get-env "S3_BUCKET")


## License

Copyright (c) 2013 by Jack Morrill. All rights reserved. 

Distributed under the Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php).
