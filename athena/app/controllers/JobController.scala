package controllers

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

//@Singleton
class JobController @Inject()(job:Job,cc:ControllerComponents, messages:MessagesProvider) 
                   extends AbstractController(cc) with I18nSupport{

// val jobForm: Form[Job] = {
//     Form(

//     )
// }


def index = Action{
    implicit request =>
    Ok(views.html.jobIndex())
}



}