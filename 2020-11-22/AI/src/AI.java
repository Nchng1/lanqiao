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
	int upFlag=1;
	int rightFlag=1;
	int downFlag=1;
	Image currentImg;
	Image img[][] = new Image[4][3];//4个方向，3张图片,0表示down，1表示left，2表示right，3表示up

/*一位数组改造

	int x,y;
	int leftFlag=1;
	int upFlag=1;
	int rightFlag=1;
	int downFlag=1;
	Image currentImg;
	Image downimg[] = new img[3];
	Image upimg[] = new img[3];
	Image leftimg[] = new img[3];
	Image rightimg[] = new img[3];
	
	for(int i = 0;i<3;i++){
		upimg[i] = Image.createImage("/sayo" +i+"4.png");
		leftimg[i] = Image.createImage("/sayo" +i+"2.png");
		rightimg[i] = Image.createImage("/sayo" +i+"6.png");
		downimg[i] = Image.createImage("/sayo" +i+"0.png");
	}


*/




	public MainCanvas(){
		try
		{
			
			for(int i =0;i < img.length;i++){
				for(int j = 0;j < img[i].length;j++){
					img[i][j]=Image.createImage("/sayo" +i+j+".png");
				}
			}
			currentImg=img[0][0];
			x = 120;
			y = 100;
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,255,255);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/

		if(action==LEFT){
			
			if(leftFlag == 1){
				currentImg=img[1][1];
			    leftFlag++;
			}else{
				currentImg=img[1][2];
				leftFlag--;
			}
				x = x-2;
				repaint();
			
		}
		if(action==RIGHT){

			if(rightFlag == 1){
					currentImg=img[2][1];
					rightFlag++;
				}else{
					currentImg=img[2][2];
					rightFlag--;
				}
				x = x+2;
				repaint();
		}
		if(action==UP){
			if(upFlag == 1){
					currentImg=img[3][1];
					upFlag++;
				}else{
					currentImg=img[3][2];
					upFlag--;
				}
					
				y = y -2;
				repaint();
		}
	  if(action==DOWN){
			if(downFlag == 1){
					currentImg=img[0][1];
					downFlag++;
				}else{
					currentImg=img[0][2];
					downFlag--;
				}
				 y = y+ 2;
				 repaint();
	  }
	}
	/*
	public void move(int action){
			if(action==DOWN){
			if(downFlag == 1){
					currentImg=img[0][1];
					downFlag++;
				}else{
					currentImg=img[0][2];
					downFlag--;
				}
				 y = y+ 2;
				 repaint();
				}

			if(action==LEFT){
			
			if(leftFlag == 1){
				currentImg=img[1][1];
			    leftFlag++;
			}else{
				currentImg=img[1][2];
				leftFlag--;
			}
				x = x-2;
				repaint();
			
			}
			if(action==RIGHT){

				if(rightFlag == 1){
						currentImg=img[2][1];
						rightFlag++;
					}else{
						currentImg=img[2][2];
						rightFlag--;
					}
					x = x+2;
					repaint();
			}
			if(action==UP){
				if(upFlag == 1){
						currentImg=img[3][1];
						upFlag++;
					}else{
						currentImg=img[3][2];
						upFlag--;
					}
						
					y = y -2;
					repaint();
			}
	}
	*/
}



