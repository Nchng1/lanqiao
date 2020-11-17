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

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int x,y;
	int leftFlag=1;
	Image img,imgleft1,imgleft2,currentImg,imgup,imgright;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			img=Image.createImage("/sayo00.png");
			imgleft1=Image.createImage("/sayo02.png");
			imgup =Image.createImage("/sayo04.png");
            imgright =Image.createImage("/sayo06.png");
			imgleft2=Image.createImage("/sayo22.png");
			x = 120;
			y = 100;
			currentImg=img;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			
			if(leftFlag == 1){
				currentImg=imgleft1;
				x = x -2;
			    leftFlag++;
				System.out.println("向左转");
				repaint();
			}else{
				currentImg=imgleft2;
				x = x -2;
				leftFlag--;
				System.out.println("向左转");
				repaint();
			}
			
		}
		if(action==RIGHT){
         currentImg =imgright;
		  x = x + 2;
		 System.out.println("向右转");
		 repaint();
		}
		if(action==UP){
        currentImg =imgup;
		 y = y -2;
		System.out.println("向上转");
		repaint();
		}
	  if(action==DOWN){
		  currentImg =img;
		  y = y+ 2;
		  System.out.println("向下转");
		  repaint();
	  }
	}
}