package models
import org.joda.time.DateTime
import models.JobTypes
import java.util.Date._

case class Job(description:String, jobId:String,jobStArt:DateTime,jobEnd:DateTime,state:Boolean,jtype:JobTypes)

case class JobFormClass(description:String, jobId:String,jobStart:java.util.Date,jobEnd:java.util.Date,state:Boolean,jtype:String)