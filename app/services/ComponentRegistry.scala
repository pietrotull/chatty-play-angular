package services

import dao.UserRepoComponent

/**
 * Created by tgdkepi1 on 18.10.2014.
 */
object ComponentRegistry extends UserServiceComponent with UserRepoComponent {
  val userRepo = new UserRepo
  val userService = new UserService
}
