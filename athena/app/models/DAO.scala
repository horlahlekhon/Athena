package models

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import org.joda.time.DateTime
import models._
import scala.concurrent.{ Future, ExecutionContext }
// import com.github.tototoshi.slick.PostgresJodaSupport._


@Singleton
class DOA @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec:ExecutionContext){
  private val dbConfig  = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  private class JobTable(tag: Tag) extends Table[Job](tag, "job") {  

    def jobId = column[Int]("id", O.PrimaryKey, O.AutoInc)    

    def description = column[String]("description")

    def jobType = column[String]("jobType")

    def pending = column[String]("pending")

    def jobStart = column[Option[DateTime]]("jobStart")

    def jobEnd = column[Option[DateTime]]("jobEnd")

    def * = ( jobId, description, jobType, pending, jobStart, jobEnd ) <> ((Job.apply _).tupled, Job.unapply)

    // def jobBindJobType = foreignKey("jobType_FK", jobtype, JobTypes )(_.jobType, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)

  }

  private val jobs = TableQuery[JobTable]

  //  Adding Job
  def addJob( job : Job) = db.run{
      jobs += job
    }

    // Return pending Job
  def getAllJob(): Future[Seq[Job]] = db.run(
      jobs.filter(_.pending === "true" ).result)
    

// searching jobs
  def getSpecifiedJob( query : String):Future[Seq[Job]]  = db.run{
        jobs.filter(_.jobType === query).result
  }

//update Job status faulty update!!!!!!!!!!!!!!!!!!
//   def updateStatus( Job_id : Int) = db.run{
//     jobs.filter( _.id === Job_id ).update()
//   }

private class JobTypeTable(tag: Tag) extends Table[JobTypes](tag, "jobType") {

        def id = column[Int]("id", O.PrimaryKey, O.AutoInc)         

        def jtype = column[String]("type")

        def * = ( id, jtype) <> ((JobTypes.apply _).tupled, JobTypes.unapply)
    }

//     private val jobtype = TableQuery[JobTypeTable]

//   def createType( jt : JobTypes) = db.run{         
//        jobtype += jt
//   } 

//   def getAllTypes : Future[Seq[JobTypes]] = db.run{
//       jobtype.result
//   }

//   def removeType( name : String) = db.run{
//       jobtype.filter(_.jtype === name ).delete
//   }

//   private class UserTable(tag: Tag) extends Table[User](tag, "user") {

//         def username = column[String]("username", O.PrimaryKey)  

//         def email = column[String]("email")

//         def fname = column[String]("first_name")

//         def lname = column[String]("last_name")

//         def password = column[String]("password")
 
//         def * = (username, fname, lname, email, password) <> ((User.apply _).tupled, User.unapply)
//     }

//     private val users = TableQuery[UserTable]

//   def addUser( user : User) = db.run{         
//        users += user                        
//   } 

//   def getAllUser : Future[Seq[User]] = db.run{
//       users.result
//   }  

// //   def removeAccount(acc : String) = db.run{
// //       account.filter(_.username === acc).delete
// //   }

}


