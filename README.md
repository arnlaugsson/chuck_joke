# chuck_joke
(T-303-HUGB, Hugbúnaðarfræði, 2016-3)

Sample program used to show students Gradle in action. Based on [P�la´s Chuck Norris joke app](https://github.com/palaogn/chuck_joke).

## Project content
- **build.gradle** (The gradle build file that we use)
- **gradle** (Folder containing the gradle wrapper)
- **gradlew** (Linux/Unix script to run the gradle wrapper)
- **gradlew.bat** (Windows script to run the gradle wrapper)
- **settings.gradle** (Settings file for gradle, not used in our example, can for example contain definitions if we have multiple projects)
- **src** (Source folder for our code)

## Getting started
1. Fork this repo to your own account (or organization's account).
2. Clone this repo to your computer
    * Using https: `git clone https://github.com/YOUR-GITHUB/chuck_joke.git`
    * Or, better yet, using ssh: `git clone git@github.com:YOUR-GITHUB/chuck_joke.git`
3. Make sure it runs on your setup: `./gradlew check` or `gradlew.bat check` if you are running on Windows.
4. If everything is OK, you can use the scripts in the `bin/` folder to compile, package, run or deploy.
5. To make the server run on a different port, other than 4567, you'll need to do `export PORT=1337` (for port 1337 on \*nix computers) or `set PORT=1337` on Windows.
