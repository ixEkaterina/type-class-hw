package messages.inheritance

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks

class MessagesSpec extends AnyFlatSpec with should.Matchers with TableDrivenPropertyChecks {

  import language._

  private val languages = Table(
    ("Language", "Hello Message", "Goodbye Message"),
    (EnglishLanguage, "Hello", "Goodbye"),
    (RussianLanguage, "Привет", "До свидания"),
    (SpanishLanguage, "Hola", "Adios")
  )

  import Messages._

  "hello" should "return hello message in appropriate language" in {
    forAll (languages) { (language, helloMessage, _) =>
      hello(language) should be (helloMessage)
    }
  }

  "goodbye"should "return goodbye message in appropriate language" in {
    forAll (languages) { (language, _, goodbyeMessage ) =>
      goodbye(language) should be (goodbyeMessage)
    }
  }
}
