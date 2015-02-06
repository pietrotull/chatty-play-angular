package services

import dao.UserRepoComponent
import models.User
import play.api.Logger

/**
 * Created by tgdkepi1 on 18.10.2014.
 */
trait UserServiceComponent { this: UserRepoComponent =>
  val userService: UserService
  class UserService {

    def printCrap() = {
      Logger.debug("Crap was called !")
      createUser()
    }

    def createUser() = {
      val user: User = new User(new Some[Long](1), "he@he.com", "password", "Mark Test", None)
      userRepo.createUser(user)
    }
  }
}