package org.zenbowman.sexpr

sealed trait Element

case class Atom(symbol: String) extends Element

case class SList(values: List[Element]) extends Element

