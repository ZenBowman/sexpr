package org.zenbowman.sexpr

import junit.framework.{Assert, TestCase, Test}


class TestExpressionParser extends TestCase {

  def testTokenize() {
    val tokens = ExpressionParser.tokenize("(hello there (my friend) lewin)")
    Assert.assertEquals(List("(", "hello", "there", "(", "my", "friend", ")", "lewin", ")"), tokens)
  }

  def testParse() {
    val tokens = ExpressionParser.parse("(hello there (my friend) lewin)")
    Console.println(tokens)
  }

  def testAtom() {
    val atom = ExpressionParser.parse("(hi)")
    Console.println(atom)
  }

  def testBadExpression() {
    try {
      val tokens = ExpressionParser.parse("(hello there (my friend) lewin")
      throw new Exception("Failed to catch invalid s-expr")
    }
    catch {
      case _: InvalidSExpressionException => "Passed"
    }
  }
}
