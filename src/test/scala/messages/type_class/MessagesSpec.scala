package messages.type_class

import language.Language
import messages.type_class.Messages.{goodbye, hello}
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class MessagesSpec extends AnyFlatSpec with MockFactory with should.Matchers {

  "hello" should "return hello message in given language" in {
    val language: Language = mock[Language]
    implicit val helloMessageProvider: HelloMessageProvider[Language] = mock[HelloMessageProvider[Language]]

    (helloMessageProvider.message _).expects().returning("Hello").once()

    hello(language) should be("Hello")
  }

  "goodbye" should "return goodbye message in given language" in {
    val language: Language = mock[Language]
    implicit val goodbyeMessageProvider: GoodbyeMessageProvider[Language] = mock[GoodbyeMessageProvider[Language]]

    (goodbyeMessageProvider.message _).expects().returning("Goodbye").once()

    goodbye(language) should be("Goodbye")
  }
}