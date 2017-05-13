package code.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {

 public static int mouseY = -1;
 public static int mouseX = -1;
 public static int mouseB = -1;

 public int mouseX() {
  return mouseX;
 }

 public int mouseY() {
  return mouseY;
 }

 public int mouseB() {
  return mouseB;
 }

 public void mouseDragged(MouseEvent e) {
  mouseX = e.getX();
  mouseY = e.getY();

 }

 public void mouseMoved(MouseEvent e) {
  mouseX = e.getX();
  mouseY = e.getY();
 }

 public void mouseClicked(MouseEvent e) {
  
 }

 public void mouseEntered(MouseEvent e) {

 }

 public void mouseExited(MouseEvent e) {

 }

 public void mousePressed(MouseEvent e) {
  mouseB = e.getButton();

 }

 public void mouseReleased(MouseEvent e) {
  mouseB = -1;

 }

}
