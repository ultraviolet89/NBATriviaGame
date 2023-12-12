# Programming Assignment #4
* CIS 2818 – Android Development 
* Oakland Community College 
* John P. Baugh, Ph.D.

## Project initital Set-up
* Android Studio Hedgehot 2023.1.1
* Empty Views Activity
* API 27 ("Oreo"; Android 8.1)
* Kotlin DSL (build.gradle.kts)
* Package name: com.violetta.nbatriviagame
* Sqllite file is located in ~~res/raw~~ `app/src/main/assets` directory

`dokka` documentation: [here](app/docs/index.md)

To generate `dokka` documentation, run the following command from the root of the project:
`./gradlew dokkaGfm`

## MVC Model
```markdown
Below is the MVC tree structure with descriptions for each component:
NBATriviaGame/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml
│   │   │   │
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── violetta/
│   │   │   │           └── nbatriviagame/
│   │   │   │               ├── model/  # Data handling and logic
│   │   │   │               │   ├── Question.kt  # Defines the data structure for a trivia question
│   │   │   │               │   └── QuestionRepository.kt  # Manages data operations for trivia questions. //TODO Need to be converted json > db source.
│   │   │   │               │
│   │   │   │               ├── views/  # UI components and activities
│   │   │   │               │   └── BaseTriviaActivity.kt  # Base class for trivia game activities
│   │   │   │               │
│   │   │   │               ├── controller/  # Controllers for handling user interactions
│   │   │   │               │   └── Trivia.kt  # Contains the logic to control the game flow
│   │   │   │               │
│   │   │   │               ├── CareerStatsModeActivity.kt  # Activity for Career Stats mode
│   │   │   │               ├── HowToPlayActivity.kt  # Activity that explains how to play the game
│   │   │   │               ├── MainActivity.kt  # The main entry point of the app
│   │   │   │               └── SingleSeasonModeActivity.kt  # Activity for Single Season mode
│   │   │   │
│   │   │   └── res/  # Resources like layouts, strings, images, etc.
│   │   │       └── db.json # //TODO current temporary data source. Need to be replaced with db source.
│   │   │
│   │   └── build.gradle  # Gradle build configuration file
│   │
│   └── build.gradle  # Project-level Gradle build file
│
└── README.md  # Project documentation and instructions
```

## Code Explaination
- CODE:
```kotlin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Globals.setRandomBackground(this)

        val buttonCareer = findViewById<Button>(R.id.button_career_mode)
        buttonCareer.setOnClickListener {
            startActivity(Intent(this, CareerStatsModeActivity::class.java))
        }

        val buttonSingleSeason = findViewById<Button>(R.id.button_single_season_mode)
        buttonSingleSeason.setOnClickListener {
            startActivity(Intent(this, SingleSeasonModeActivity::class.java))
        }

        val buttonHowToPlay = findViewById<Button>(R.id.button_how_to_play)
        buttonHowToPlay.setOnClickListener {
            startActivity(Intent(this, HowToPlayActivity::class.java))
        }
    }
```
Above code initializes three buttons as the main menu of our NBA Trivia Game.<br/>
<br/>

