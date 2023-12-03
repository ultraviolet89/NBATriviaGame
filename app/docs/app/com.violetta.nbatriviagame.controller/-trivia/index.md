//[app](../../../index.md)/[com.violetta.nbatriviagame.controller](../index.md)/[Trivia](index.md)

# Trivia

[androidJvm]\
class [Trivia](index.md)(questions: [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Question](../../com.violetta.nbatriviagame.model/-question/index.md)&gt;)

Controller class for managing trivia game logic. Handles the progression of the trivia game, including keeping track of questions, the current score, and whether the game has ended.

## Constructors

| | |
|---|---|
| [Trivia](-trivia.md) | [androidJvm]<br>constructor(questions: [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Question](../../com.violetta.nbatriviagame.model/-question/index.md)&gt;) |

## Properties

| Name | Summary |
|---|---|
| [currentQuestion](current-question.md) | [androidJvm]<br>val [currentQuestion](current-question.md): [Question](../../com.violetta.nbatriviagame.model/-question/index.md)<br>Retrieves the current question from the list of questions |
| [isGameOver](is-game-over.md) | [androidJvm]<br>val [isGameOver](is-game-over.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [score](score.md) | [androidJvm]<br>var [score](score.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Current score of the player |

## Functions

| Name | Summary |
|---|---|
| [checkAnswer](check-answer.md) | [androidJvm]<br>fun [checkAnswer](check-answer.md)(selectedIndex: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks if the selected answer is correct for the current question. Increments the score if the answer is correct. |
| [getCurrentQuestionOptions](get-current-question-options.md) | [androidJvm]<br>fun [getCurrentQuestionOptions](get-current-question-options.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [nextQuestion](next-question.md) | [androidJvm]<br>fun [nextQuestion](next-question.md)(): [Question](../../com.violetta.nbatriviagame.model/-question/index.md)?<br>Advances to the next question |
