import services._

object Main extends App {
  println("As-salamu alaykum!")
  println("Welcome to the Islamic Chatbot!")
  println("Type 'help' for available commands or 'exit' to quit.")
  println("Type 'quiz' to start a quiz session.\n")

  val chatService = new ChatService()
  val quizService = new QuizService()
  var userPreferences = new UserPreferences()

  def processCommand(input: String): Boolean = {
    input.toLowerCase match {
      case "exit" => 
        println("Ma'a as-salama! (Goodbye!)")
        false
      case "help" =>
        println("\nAvailable commands:")
        println("- Ask any question about Islam")
        println("- 'quiz' - Start a quiz session")
        println("- 'quiz <topic>' - Start a quiz on a specific topic")
        println("- 'difficulty <level>' - Set quiz difficulty (easy/medium/hard)")
        println("- 'explanations <on/off>' - Turn quiz explanations on/off")
        println("- 'exit' - Exit the program")
        true
      case s if s.startsWith("quiz") =>
        val topic = if (s == "quiz") None else Some(s.substring(5).trim)
        quizService.startQuiz(topic, userPreferences)
        true
      case s if s.startsWith("difficulty") =>
        val level = s.substring(11).trim.toLowerCase
        if (Set("easy", "medium", "hard").contains(level)) {
          userPreferences = userPreferences.copy(quizDifficulty = level)
          println(s"Quiz difficulty set to: $level")
        } else {
          println("Invalid difficulty level. Use: easy, medium, or hard")
        }
        true
      case s if s.startsWith("explanations") =>
        val setting = s.substring(12).trim.toLowerCase
        if (Set("on", "off").contains(setting)) {
          userPreferences = userPreferences.copy(showExplanations = setting == "on")
          println(s"Quiz explanations turned ${setting}")
        } else {
          println("Invalid setting. Use: on or off")
        }
        true
      case question =>
        chatService.processQuestion(question)
        true
    }
  }

  var continue = true
  while (continue) {
    print("\nYou: ")
    val input = scala.io.StdIn.readLine()
    if (input != null && input.trim.nonEmpty) {
      continue = processCommand(input.trim)
    }
  }
} 