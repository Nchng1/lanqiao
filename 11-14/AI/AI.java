import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image img,img1,img2,img3,currentImg;
	public MainCanvas(){
	try{
		/*
		给变量赋值
		*/
		img = Image.createImage("/sayo10.png");//down
		img1 = Image.createImage("/sayo12.png");//left
		img2 = Image.createImage("/sayo14.png");//up
		img3 = Image.createImage("/sayo16.png");//right
		currentImg = img;
	}
	catch(IOException e){
		e.printStackTrace();
	}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,120,100,0);//120:x坐标，100：y坐标
	}
	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);
		/*
			action的值为UP,DOWN,LEFT,RIGHT
		*/
		if(action == LEFT){
			/*
			实现转向代码
			给变量重新赋值即可
			*/
			currentImg = img1;
			System.out.println("向左转");
			repaint();
		}
		else if(action == UP){
			/*
			实现转向代码
			给变量重新赋值即可
			*/
			currentImg = img2;
			System.out.println("向上转");
			repaint();
		}
		else if(action == RIGHT){
			/*
			实现转向代码
			给变量重新赋值即可
			*/
			currentImg = img3;
			System.out.println("向右转");
			repaint();
		}else if(action == DOWN){
			/*
			实现转向代码
			给变量重新赋值即可
			*/
			currentImg = img;
			System.out.println("向下转");
			repaint();
		}else{
			System.out.println("咋瓦鲁多");
		}
		
	}