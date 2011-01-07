package org.scalariform

import scalariform.formatter.preferences._
import scalariform.formatter.ScalaFormatter
import scalariform.parser.ScalaParserException
import scalariform.utils.Utils.writeText

import java.io.{ File, FilenameFilter, FileFilter }

import scala.collection.JavaConversions._

import scala.io.Source

/**
 * Goal which formats scala source files
 *
 * @goal format
 * 
 * @phase process-sources
 */
object MojoFormatter {

  val scalaFilter = new FilenameFilter {
    def accept(dir : File, name : String)  : Boolean = name.endsWith(".scala")
  }

  val dirFilter = new FileFilter() {
    def accept(dir : File ) = dir.isDirectory
  }

  private def findScalaFiles(dirpath : String) : List[String] = {
     def findScalaFilesByFile(path : File, list : List[String]) : List[String] = {
       val runningList = path.listFiles(scalaFilter).map { _.getAbsolutePath }.toList ::: list
       path.listFiles(dirFilter).foldLeft(runningList) { (sum,dir) =>
         findScalaFilesByFile(dir, sum)
       }
     }     
     findScalaFilesByFile(new File(dirpath), Nil)
  }

  def format(path : String) {
    findScalaFiles(path).foreach { file =>
      val original = Source.fromFile(file).mkString
      writeText(new File(file), ScalaFormatter.format(original))
    }
  }

}
