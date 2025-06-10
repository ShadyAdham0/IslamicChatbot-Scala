package services

case class UserPreferences(
  quizDifficulty: String = "easy",
  showExplanations: Boolean = true
) 