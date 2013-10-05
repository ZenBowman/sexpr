sexpr
=====

A simple s-expression parser in Scala


Usage:
  val tokens = ExpressionParser.parse("(hello there (my friend) lewin)")
  
  RETURNS: SList(List(Atom(hello), Atom(there), SList(List(Atom(my), Atom(friend))), Atom(lewin)))
