package services

import scala.util.Random

class QuizService {
  private val fileService = new FileService()
  private val allQuestions = fileService.loadQuizQuestions()

  def startQuiz(topic: Option[String], preferences: UserPreferences): Unit = {
    val questions = topic match {
      case Some(t) => allQuestions.filter(_._1.toLowerCase == t.toLowerCase)
      case None => allQuestions
    }

    if (questions.isEmpty) {
      topic match {
        case Some(t) => println(s"No questions available for topic: $t")
        case None => println("No questions available")
      }
      return
    }

    val filteredQuestions = questions.filter { case (_, difficulty, _, _, _) =>
      difficulty.toLowerCase == preferences.quizDifficulty
    }

    if (filteredQuestions.isEmpty) {
      println(s"No questions available for difficulty level: ${preferences.quizDifficulty}")
      return
    }

    val selectedQuestions = Random.shuffle(filteredQuestions).take(5)
    var score = 0

    println("\nStarting quiz session...")
    println(s"Difficulty: ${preferences.quizDifficulty}")
    if (topic.nonEmpty) println(s"Topic: ${topic.get}")
    println("Answer by typing the number of your choice (1-4)\n")

    selectedQuestions.zipWithIndex.foreach { case ((_, _, options, correct, explanation), index) =>
      println(s"Question ${index + 1}:")
      options.zipWithIndex.foreach { case (option, i) =>
        println(s"${i + 1}. $option")
      }

      print("\nYour answer (1-4): ")
      val userAnswer = scala.io.StdIn.readLine()

      try {
        val answerIndex = userAnswer.toInt - 1
        if (answerIndex >= 0 && answerIndex < options.length) {
          if (options(answerIndex) == correct) {
            println("Correct! Masha Allah!")
            score += 1
          } else {
            println(s"Incorrect. The correct answer was: $correct")
          }
          if (preferences.showExplanations) {
            println(s"Explanation: $explanation\n")
          }
        } else {
          println("Invalid answer number. Moving to next question.\n")
        }
      } catch {
        case _: NumberFormatException =>
          println("Invalid input. Moving to next question.\n")
      }
    }

    println(s"\nQuiz completed! Your score: $score out of ${selectedQuestions.length}")
    val percentage = (score.toDouble / selectedQuestions.length) * 100
    println(s"Percentage: ${percentage.round}%")

    percentage match {
      case p if p == 100 => println("Excellent! Masha Allah!")
      case p if p >= 80 => println("Very good! Keep learning!")
      case p if p >= 60 => println("Good effort! Keep studying!")
      case _ => println("Keep learning and try again!")
    }
  }
} 