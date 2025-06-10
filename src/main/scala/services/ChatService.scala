package services

class ChatService {
  private val fileService = new FileService()
  private val responses = fileService.loadResponses()
  private val keywords = fileService.loadKeywords()

  def processQuestion(question: String): Unit = {
    val normalizedQuestion = question.toLowerCase
    val matchedKeywords = keywords.filter(kw => normalizedQuestion.contains(kw.toLowerCase))
    
    if (matchedKeywords.isEmpty) {
      println("I apologize, but I don't have enough information to answer that question accurately. " +
              "Please try rephrasing your question or ask something else about Islam.")
      return
    }

    val relevantResponses = responses.filter(response =>
      matchedKeywords.exists(kw => response.keywords.map(_.toLowerCase).contains(kw.toLowerCase))
    )

    if (relevantResponses.isEmpty) {
      println("I understand you're asking about " + matchedKeywords.mkString(", ") + 
              ", but I don't have a specific answer for that question. " +
              "Please try asking in a different way or ask another question.")
      return
    }

    // Find the response with the most keyword matches
    val bestResponse = relevantResponses.maxBy(response =>
      matchedKeywords.count(kw => response.keywords.map(_.toLowerCase).contains(kw.toLowerCase))
    )

    println(bestResponse.text)
    if (bestResponse.source.nonEmpty) {
      println(s"\nSource: ${bestResponse.source}")
    }
  }
} 