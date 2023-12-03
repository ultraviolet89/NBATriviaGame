//[app](../../../index.md)/[com.violetta.nbatriviagame.model](../index.md)/[QuestionRepository](index.md)/[loadQuestions](load-questions.md)

# loadQuestions

[androidJvm]\
fun [loadQuestions](load-questions.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), mode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Question](../-question/index.md)&gt;

Loads questions for the trivia game.

Retrieves a list of questions based on the specified mode. Allows accesses of a data source, such as a local database or a JSON file, to obtain the questions.

#### Return

A list of questions for the specified mode.

#### Parameters

androidJvm

| | |
|---|---|
| context | The context used for accessing resources. |
| mode | The mode of the trivia game for which questions are loaded. |
