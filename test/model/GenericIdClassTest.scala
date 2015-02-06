package model

import org.specs2.runner.JUnitRunner
import play.api.test._
import org.junit.runner.RunWith
import play.api.libs.json._

/**
 * Created by tgdkepi1 on 22.10.2014.
 */
class GenericIdClassTest {
/*
  @RunWith(classOf[JUnitRunner])
  object GenericIdObjectSpec extends PlaySpecification {

    class GenericId[T](val value: String) {
    }

    object GenericId {
      implicit val genIdFormat = Format[GenericId[_]] = new Format[GenericId[_]] {
        def reads(json: JsValue): JsResult[GenericId[_]] = json match {
          case JsString(value) => JsSuccess(new GenericId[_](value))
          case _ => JsError(s"Unexpected JSON value $json")
        }

        def writes(id: GenericId[_]): JsValue = JsString(id.value)
      }
    }

    implicit def genericIdReads[T]: Reads[GenericId[T]] = (JsPath).read[String].map(GenericId[T])
    implicit def genericIdWrites[T]: Writes[GenericId[T]] = Writes { (id: GenericId[T]) => JsString(id.value) }

    case class User(id: GenericId[User], name: String)

    object User {
      implicit val userFormat: Format[User] = Json.format[User]
    }

    /*
    case class Safe(id: GenericId[Safe], owner: GenericId[User])

    object Safe {
      implicit val safeFormat: Format[Safe] = Json.format[Safe]
    }
    */

    val user: JsValue = Json.parse( """ {
      "id":"111",
      "name":"John"
    } """)

    val safe: JsValue = Json.parse( """ {
      "id":"222",
      owner:"111"
    }	""")

    "Parsing generic id object" should {

      "Test1 will be parsed correctly" in {
        val test = user.as[User]
        test.id === new GenericId[User]("111")
      }

      "Test2 will be parsed correctly" in {
        val test = safe.as[Safe]
        test.id === new GenericId[Safe]("222")
      }
    }
  }
  */
}
