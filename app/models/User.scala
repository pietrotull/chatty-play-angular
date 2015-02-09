package models

import java.util.Date
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class User(
  id: Option[Long],
  email: String,
  password: String,
  name: String,
  dateOfBirth: Option[Date],
  createdAt: Date = new Date
)

object User {

  implicit val UserFromJson: Reads[User] = (
    (__ \ "id").readNullable[Long] ~
    (__ \ "email").read(Reads.email) ~
    (__ \ "password").read[String] ~
    (__ \ "name").read[String] ~
    (__ \ "dateOfBirth").readNullable[Date] ~
    (__ \ "createdAt").read(new Date)
  )(User.apply _)

  implicit val UserToJson: Writes[User] = (
    (__ \ "id").writeNullable[Long] ~
    (__ \ "email").write[String] ~
    (__ \ "password").writeNullable[String] ~ // don't write the password
    (__ \ "name").write[String] ~
    (__ \ "dateOfBirth").writeNullable[Date] ~
    (__ \ "createdAt").write[Date]
  )((user: User) => (
    user.id,
    user.email,
    None,
    user.name,
    user.dateOfBirth,
    user.createdAt
  ))


  def findOneById(id: Long): Option[User] = {
    // TODO: find the corresponding user
    //
    // For now return a fake user
    id match {
      case 1 => Some(User(Some(1L), "mar@gmail.com.com", "mypassword", "Martha Barcenas", None))
      case 2 => Some(User(Some(2L), "ket@gmail.com", "mypassword", "Pietari Kettunen", None))
      case 3 => Some(User(Some(3L), "test@test.com", "mypassword", "John Smith", None))
      case _ => None
    }
  }

  def findByEmailAndPassword(email: String, password: String): Option[User] = {
    // TODO: find the corresponding user; don't forget to encrypt the password
    //
    // For now return a fake user
    email match {
      case "mar@gmail.com" => Some(User(Some(1L), email, password, "Martha Barcenas", None))
      case "ket@gmail.com" => Some(User(Some(2L), email, password, "Pietari Kettunen", None))
      case _ => Some(User(Some(3L), email, password, "John Smith", None))
    }
  }
}
