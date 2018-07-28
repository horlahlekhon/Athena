package models
import org.joda.time.DateTime

case class Job(description:String,jobId:String,jobStArt:DateTime,jobEnd:DateTime,state:Boolean)