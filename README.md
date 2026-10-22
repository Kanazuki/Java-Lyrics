# Java Lyrics

A small Java project that plays an MP3 file while printing its
synchronized `.lrc` lyrics in the terminal.

This is a personal learning project built to experiment with Java,
threads, file handling, external libraries, and timed text output. It is
a work in progress.

## Current Features

-   Plays MP3 audio using **JLayer**.
-   Reads an `.lrc` lyrics file as UTF-8.
-   Parses timestamped lyrics with **LrcParser**.
-   Prints lyrics to the terminal in time with the song.
-   Prints each lyric character by character, spreading the line's
    duration across its characters.

## Requirements

-   A Java JDK installed.
-   Visual Studio Code with the Java extensions, or another Java IDE.
-   The dependency JAR files in the `lib/` directory.

## Project Structure

``` text
Java-Lyrics/
├── .vscode/
│   └── settings.json
├── lib/
│   ├── jlayer-1.0.1.jar
│   └── lrcparser.jar
├── src/
│   ├── App.java
│   └── assets/
│       └── Kiss-I_Was_Made_For_Lovin'_You/
│           ├── Kiss-I_Was_Made_For_Lovin'_You.mp3
│           └── Kiss-I_Was_Made_For_Lovin'_You.lrc
└── README.md
```

The `bin/` directory contains compiled output and is ignored by Git.

## Running the Project

1.  Clone or download this repository.
2.  Open the project folder in Visual Studio Code.
3.  Make sure the JAR files are present in `lib/` and the Java extension
    recognizes them as referenced libraries.
4.  Run `src/App.java` from the **project root** so the relative asset
    paths resolve correctly.

The song and lyrics paths are currently defined directly in `App.java`,
so changing the selected song requires updating those paths.

## Dependencies

-   [JLayer
    1.0.1](https://repo1.maven.org/maven2/javazoom/jlayer/1.0.1/jlayer-1.0.1.jar)
    for MP3 playback.
-   [LrcParser](https://github.com/authorfu/LrcParser) for parsing
    timestamped `.lrc` files.

## Current Limitations

-   The song and lyrics file paths are hard-coded.
-   Playback and lyric output run on separate threads, so the timing
    approach is still relatively simple.
-   The character-by-character effect divides a line's duration across
    its characters; it does not use word- or character-level timestamps
    from the lyrics file.
-   This project is still being developed, and edge cases in lyric
    timing may need additional handling.

## License and Media

The code and third-party dependencies may have different licensing
terms; check each dependency's repository for its license. Any included
music and lyrics remain the property of their respective rights holders.
