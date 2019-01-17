package Lab11_gr1

import java.io.{BufferedWriter, FileWriter}


import scala.swing._
import scala.swing.event._
import scala.io._



object zad1 extends SimpleSwingApplication {
  def top: MainFrame = new MainFrame{
    title = "Text Editor"
    var left_right = true

    val textField: TextArea = new TextArea("Some text... ", 20, 20){
      background = new Color(0xffc0cb)
      lineWrap = true
      wordWrap = true
    }

    val FileLoader = new FileChooser(null)

    val file_button = new Button("load file")
    listenTo(file_button)
      reactions += {case ButtonClicked(button) if button == file_button =>
        val file = FileLoader.showOpenDialog(null)
        if(file == FileChooser.Result.Approve && FileLoader.selectedFile.canRead) {
          textField.text_=("")
          for(i <- Source.fromFile(FileLoader.selectedFile)) textField.append(i.toString)
        }
      }

    val save_button = new Button("save file")
    listenTo(save_button)
      reactions += {case ButtonClicked(button) if button == save_button =>
        val file = FileLoader.showSaveDialog(null)
        if(file == FileChooser.Result.Approve && FileLoader.selectedFile.canWrite) {
          val output = new BufferedWriter(new FileWriter(FileLoader.selectedFile))
          output.write(textField.text)
          output.close()
        }
      }

    val algin_button = new Button("algin")
    listenTo(algin_button)
      reactions += { case ButtonClicked(button)  if button == algin_button =>
        left_right = !left_right
        if(!left_right) textField.text_=(algin_right(textField.text)) else textField.text_=(algin_left(textField.text))
      }


    contents = new BoxPanel(Orientation.Vertical) {
      contents += textField
      contents += new GridPanel(1,2){
        contents += file_button
        contents += save_button
        contents += algin_button
      }
    }

    def algin_right(str: String): String = {
      val counter = (textField.size.width / 4.5).toInt
      val splited_string = str.split(" ").toList

      def help(list: List[String],temp: String = "", result: String = ""): String = {
        if(list.isEmpty){
          if(temp.isEmpty) return result
          val x = counter - temp.length
          var space = ""
          for(i <- 1 to x) space = space + " "
          return help(list, "", result + space + temp + f"%n")
        }
        if(temp.length + list.head.length >= counter){
          val x = counter - temp.length
          var space = ""
          for(i <- 1 to x) space = space + " "
          return help(list, "", result + space + temp + f"%n")
        }
        help(list.tail, temp + " " + list.head, result)
      }



      help(splited_string)
    }
    def algin_left(str: String): String ={
      val splited = str.split(" ").filter(_.nonEmpty)
      var result = splited.head
      for(i <- splited.tail){
        result = result + " " + i
      }
      result.filter(_ >= ' ')
    }
  }

}
