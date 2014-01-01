# dotenv

### A Clojure library designed to impliment the functionality of the dotenv RubyGem on the JVM.

Read a file of environment key=value pairs and load them into the JVM's System Properties.

#### Usage

##### In project.clj :dependencies

    [com.rentpath/dotenv "1.0.1"]

##### In your application ns macro

    (:require [com.rentpath.dotenv.core :as dotenv])

##### In your application program (the environment variable file name defaults to ".env" if ENVIRONMENT is not defined).

    (dotenv!)

or specify a filename

    (load-env ".env.anything")

The dotenv! function will load the .env file specified by the ENVIRONMENT environment variable into JVM System Properties:

    env ENVIRONMENT=test lein test

    env ENVIRONMENT=development lein ring server-headless 3000

Add your application configuration to your .env.* files in the root of your project.

    S3_BUCKET=YOURS3BUCKET
    SECRET_KEY = "YOURSECRETKEYGOESHERE"

You can also create files per environment, such as .env.test. These .env.* files usually mimic the Rails pattern; .env.development, .env.test, .env.ci, .env.qa, .ene.staging, .env.production.  Any environment can be used, defined by the ENVIRONMENT environment variable.  A special file .env.local will override any definitions in .env.* files; usefull for sensitive information that shouldn't be checked into a public repository.

    S3_BUCKET=tests3bucket
    SECRET_KEY = "test-secret-key"

An alternate yaml-like syntax is supported:

    S3_BUCKET: yamlstyleforyours3bucket
    SECRET_KEY: this-is-also-an-okay-secret

Your application only needs to call (dotenv!) once, preferably as early as possible in the application startup.
    
When your application loads, the variables defined in the .env{.*} files will be available in the JVM System Properties.

    (System/getProperty "S3_BUCKET")

The dotenv library is intended to be used with the [com.rentpath/environs "1.0.1"] library.

    (:require [com.rentpath.environs.core :as environs])

Retrieve a System Property

    (Env "S#_BUCKET")

Throws "MissingEnvVarError" if FOO is not an environment variable or JVM System Property.

    (Env "FOO" allow-nil)

Just return nil if FOO is not an environment variable or JVM System Property.
