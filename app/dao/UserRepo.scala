package dao

import models.User
import play.api.Logger

/**
 * Created by tgdkepi1 on 18.10.2014.
 */
trait UserRepoComponent {
  val userRepo: UserRepo

  class UserRepo {
    def createUser(user: User) = {
      Logger.info(s"creating user: $user")
    }

    def deleteUser(user: User) = {
      Logger.debug("deleting user: " + user.id)
    }
  }
}