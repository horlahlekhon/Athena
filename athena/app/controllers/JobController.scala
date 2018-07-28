package controllers

import models._

import org.joda.time.DateTime
import play.api.i18n.{I18nSupport, MessagesProvider}
import play.api.data.Form
import javax.inject.Inject
import org.joda.time.DateTime
import play.api.data.Forms._
import play.api._
import play.api.mvc._
import views.html.helper.form
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import play.api.Logger

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Success, Failure}
import java.util.Date._

//@Singleton
class JobController @Inject()(job:Job,cc:ControllerComponents, messages:MessagesProvider) 
                   extends AbstractController(cc) with I18nSupport{

                       
    // var jobList = List(
    //     Job("plumber","1213er",new DateTime(2018-3-4),new DateTime(2011-2-1),true,JobType("ghjjks","HJABNCd","yBNXCLQW"))
    // )

 val jobForm: Form[JobFormClass] = Form(
     mapping(
         "description" -> text,
         "jobId" -> nonEmptyText,
         "jobStart" -> date,
         "jobEnd" -> date,
         "state" -> boolean,
         "type" -> nonEmptyText)(models.JobFormClass.apply)(JobFormClass.unapply))


def index = Action{
    implicit request =>
    Ok(views.html.jobIndex(jobForm))
}

// def listJobs = Action{
//     implicit request => 
//     Ok(views.html.jobIndex())
// }
def jobProfile = Action{
    implicit request => 
    Ok(views.html.jobProfile())
  }

//   def addJob = Action{
//       implicit request => 
//       val fm = jobForm.bindFromRequest
//       fm.fold(
//           hasError => {
//               BadRequest(views.html.index(hasError))
//           },
//           success => {
//               val startDate = new DateTime(success.jobStart)
//               val endDate = new DateTime(success.jobEnd)

//              // val job = addJob(success)
//               Redirect(views.html.index(jobForm))
//           }
//       )
//   }

  

           }