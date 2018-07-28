package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._

import models._

import org.joda.time.DateTime
import play.api.i18n.{I18nSupport, MessagesProvider}
import play.api.data.Form
import javax.inject.Inject
import org.joda.time.DateTime
import play.api._
import play.api.mvc._
import views.html.helper.form
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Success, Failure}

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
//@Singleton
class HomeController @Inject()(cc: ControllerComponents,user:User) extends AbstractController(cc) 
             with I18nSupport{

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

   val userForm:Form[User] = 
      Form(
          mapping(
            "firstName" -> nonEmptyText,
            "lastName" -> nonEmptyText,
            "password" -> nonEmptyText,
            "email" -> email)
          )(User.apply)(User.unapply)
    



  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index(userForm))
  }
}
