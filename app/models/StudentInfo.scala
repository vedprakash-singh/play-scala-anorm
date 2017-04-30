package models

//import anorm._
import javax.inject.Singleton

import anorm.{SQL, SqlParser}
import anorm.{Macro, RowParser}
import com.google.inject.Inject
import play.api.db.Database


/**
  * Created by imana on 4/30/2017.
  */
@Singleton
class StudentInfo @Inject()(db: Database) {

  val parser: RowParser[Students] = Macro.namedParser[Students]

  def create(students: Students) {
    db.withConnection { implicit connection =>
      SQL(
        """
        INSERT INTO students (name, stream, section, email)
        VALUES ({name}, {stream}, {section}, {email})
        """
      ).on(
        'name -> students.name,
        'stream -> students.stream,
        'section -> students.section,
        'email -> students.email
      )
    }
  }


  def findByName(name: String): Option[Students] = {
    db.withConnection { implicit connection =>
      SQL("select * from students where name = {name}").on('name -> name).as(parser.singleOpt)
    }
  }

  def findAll(): List[Students] = {
    db.withConnection { implicit connection =>
      SQL("select * from students").as(parser *)
    }
  }


}

case class Students
(name: String,
 stream: String,
 section: String,
 email: String
)