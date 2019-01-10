package Exercise

import scala.swing._

object window extends SimpleSwingApplication{

  def top = new MainFrame {
    title = "Hello World"
    size = new Dimension(400,150)
  }

}
