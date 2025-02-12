package io.github.arainko.ducktape.internal.modules

import scala.quoted.*

private[ducktape] object Uninlined {
  def unapply(using Quotes)(term: quotes.reflect.Term): Some[quotes.reflect.Term] = {
    import quotes.reflect.*

    term match {
      case Inlined(_, Nil, tree) => unapply(tree)
      case other                 => Some(other)
    }
  }
}
