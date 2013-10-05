package org.zenbowman.sexpr

import scala.collection.mutable.ListBuffer

class InvalidSExpressionException extends Exception

object ExpressionParser {
  private var remainingTokens: List[String] = List()

  def tokenize(expression: String): List[String] = {
    expression.replace("(", " ( ").replace(")", " ) ").trim().split("\\s+").toList
  }

  def parse(expression: String): SList = {
    remainingTokens = tokenize(expression)
    parseTokens()
  }

  def parseTokens(): SList = {
    val elements = new ListBuffer[Element]

    while (!remainingTokens.isEmpty) {
      val first = remainingTokens.head
      remainingTokens = remainingTokens.tail
      if (first == "(") {
        val element = parseTokens()
        elements.append(element)
      }
      else if (first == ")") {
        return SList(elements.toList)
      } else {
        elements.append(new Atom(first))
      }
    }

    try {
      elements.head.asInstanceOf[SList]
    } catch {
      case _: Exception => throw new InvalidSExpressionException
    }
  }
}
