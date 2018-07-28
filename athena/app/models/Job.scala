package models
//import org.joda.time.Date
import models.JobTypes
import java.util.Date._
import java.time.LocalDate
import java.util.Date

case class Job(description:String, jobId:String,jobStArt:LocalDate,jobEnd:LocalDate,pending:Boolean,jtype:JobTypes)

case class JobFormClass(description:String, jobId:String,jobStart:java.util.Date,jobEnd:java.util.Date,state:Boolean,jtype:String)