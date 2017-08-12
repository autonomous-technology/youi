package io.youi.theme

import io.youi.Cursor
import io.youi.paint.Paint
import reactify.Var

trait ComponentTheme extends Theme {
  override def defaultParent: Option[Theme] = None

  private def prnt[T](f: ComponentTheme => T, default: => T): T = parent().collect {
    case p: ComponentTheme => p
  }.map(f).getOrElse(default)

  val cursor: Var[Cursor] = Var(prnt(_.cursor, Cursor.Default))
  val interactive: Var[Boolean] = Var(prnt(_.interactive, true))
  val visible: Var[Boolean] = Var(prnt(_.visible, true))
  val background: Var[Paint] = Var(prnt(_.background, Paint.none))
}