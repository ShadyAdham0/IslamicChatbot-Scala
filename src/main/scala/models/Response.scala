package models

case class Response(
  text: String,
  keywords: List[String],
  category: String,
  source: String
) 