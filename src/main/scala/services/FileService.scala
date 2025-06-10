package services

import models.Response
import scala.io.Source
import scala.util.{Try, Using}
import scala.collection.mutable.ArrayBuffer
import ujson._

class FileService {
  def loadKeywords(): List[String] = {
    try {
      val jsonString = Using(Source.fromFile("data/keywords.json"))(_.mkString).get
      val json = ujson.read(jsonString)
      json.arr.map(_.str).toList
    } catch {
      case e: Exception =>
        println(s"Error loading keywords: data/keywords.json (${e.getMessage})")
        List.empty[String]
    }
  }

  def loadResponses(): List[Response] = {
    val responses = ArrayBuffer[Response]()
    try {
      Using(Source.fromFile("data/responses.csv")) { source =>
        for (line <- source.getLines.drop(1)) { // Skip header
          Try {
            val fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)").map(_.trim.stripPrefix("\"").stripSuffix("\""))
            if (fields.length >= 3) {
              val keywords = fields(1).split(";").map(_.trim).toList
              responses += Response(fields(0), keywords, fields(2), if (fields.length > 3) fields(3) else "")
            }
          }
        }
      }
    } catch {
      case e: Exception =>
        println(s"Error loading responses: data/responses.csv (${e.getMessage})")
    }
    responses.toList
  }

  def loadQuizQuestions(): List[(String, String, List[String], String, String)] = {
    val questions = ArrayBuffer[(String, String, List[String], String, String)]()
    try {
      Using(Source.fromFile("data/quizzes.csv")) { source =>
        for (line <- source.getLines.drop(1)) { // Skip header
          Try {
            val fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)").map(_.trim.stripPrefix("\"").stripSuffix("\""))
            if (fields.length >= 5) {
              val options = fields(2).split(";").map(_.trim).toList
              questions += ((fields(0), fields(1), options, fields(3), fields(4)))
            }
          }
        }
      }
    } catch {
      case e: Exception =>
        println(s"Error loading quiz questions: data/quizzes.csv (${e.getMessage})")
    }
    questions.toList
  }
} 