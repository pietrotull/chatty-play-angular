package model

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import play.api.libs.json.{Format, Json, JsValue}
import play.api.test.PlaySpecification


case class FooBar(field1: String,
                  field2: String,
                  field3: String,
                  field4: String,
                  field5: String,
                  field6: String,
                  field7: String,
                  field8: String,
                  field9: String,
                  field10: String,
                  field11: String,
                  field12: String,
                  field13: String,
                  field14: String,
                  field15: String,
                  field16: String,
                  field17: String,
                  field18: String,
                  field19: String,
                  field20: String,
                  field21: String,
                  field22: String,
                  field23: String,
                  field24: String,
                  field25: String)

object FooBar {
  implicit val fooBarFormat: Format[FooBar] = Json.format[FooBar]
}

@RunWith(classOf[JUnitRunner])
object JsonParsingTest extends PlaySpecification {


  val foobarJson: JsValue = Json.parse( """ {
  "field1":"value",
  "field2":"value",
  "field3":"value",
  "field4":"value",
  "field5":"value",
  "field6":"value",
  "field7":"value",
  "field8":"value",
  "field9":"value",
  "field10":"value",
  "field11":"value",
  "field12":"value",
  "field13":"value",
  "field14":"value",
  "field15":"value",
  "field16":"value",
  "field17":"value",
  "field18":"value",
  "field19":"value",
  "field20":"value",
  "field21":"value",
  "field22":"value",
  "field23":"value",
  "field24":"value",
  "field25":"value"
  } """)

  "Testing" should {
    "works" in {

      val foobar = foobarJson.as[FooBar]
      foobar.field1 === "value"
    }
  }
}
