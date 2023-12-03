//[app](../../../index.md)/[com.violetta.nbatriviagame.model](../index.md)/[Question](index.md)

# Question

[androidJvm]\
data class [Question](index.md)(val text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val options: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, val answer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Represents a trivia question with multiple choice answers.

Class encapsulates the data for a single trivia question, including the question text, a list of possible answers, and the index of the correct answer.

## Constructors

| | |
|---|---|
| [Question](-question.md) | [androidJvm]<br>constructor(text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), options: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, answer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [answer](answer.md) | [androidJvm]<br>val [answer](answer.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The correct answer to the trivia question. |
| [options](options.md) | [androidJvm]<br>val [options](options.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;<br>A list of possible answers for the trivia question. |
| [text](text.md) | [androidJvm]<br>val [text](text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The text of the trivia question. |
