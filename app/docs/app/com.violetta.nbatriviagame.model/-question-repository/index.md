//[app](../../../index.md)/[com.violetta.nbatriviagame.model](../index.md)/[QuestionRepository](index.md)

# QuestionRepository

[androidJvm]\
class [QuestionRepository](index.md)

Repository for managing trivia questions.

Class provides functionality to load trivia questions from a data source. Intermediary between the data source and the application logic.

## Constructors

| | |
|---|---|
| [QuestionRepository](-question-repository.md) | [androidJvm]<br>constructor()<br>Creates a QuestionRepository instance. |

## Functions

| Name | Summary |
|---|---|
| [loadQuestions](load-questions.md) | [androidJvm]<br>fun [loadQuestions](load-questions.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), mode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Question](../-question/index.md)&gt;<br>Loads questions for the trivia game. |
