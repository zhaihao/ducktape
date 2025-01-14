package io.github.arainko.ducktape.internal.modules

import scala.quoted.*

extension (tpe: Type[?]) {
  private[ducktape] def fullName(using Quotes): String = {
    import quotes.reflect.*

    TypeRepr.of(using tpe).show(using Printer.TypeReprCode)
  }
}
