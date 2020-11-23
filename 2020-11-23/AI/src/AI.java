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
class MainCanvas extends Canvas implements Runnable
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int heroX,heroY,bossX,bossY;
	int Flag=1;
	Thread thread;
	Image bossImg;
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
			bossImg = Image.createImage("/zuzu000.png");
			heroX = 120;
			heroY = 100;
			bossX = 0;
			bossY = 0;

			thread = new Thread(this);
			thread.start();
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void changePicAndMove(int direction){
		if(Flag == 1){
				currentImg=img[direction][1];
			    Flag++;
			}else{
				currentImg=img[direction][2];
				Flag=1;
			}
	}

	public void run(){
		while(true){

			try{
				thread.sleep(200);//fps:刷新率
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(bossX < heroX){
				bossX++;
			}else{
				bossX--;
			}
			if(bossY < heroY){
				bossY++;
			}else{
				bossY--;
			}
			repaint();
			}
	}



	public void paint(Graphics g){
		g.setColor(0,255,255);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(bossImg,bossX,bossY,0);
		g.drawImage(currentImg,heroX,heroY,0);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/

		if(action==LEFT){
			changePicAndMove(1);
			heroX = heroX-5;		
		}
		if(action==RIGHT){
			changePicAndMove(2);
			heroX = heroX+5;
		}
		 if(action==UP){
			changePicAndMove(3);
			heroY = heroY - 5;
		}
	  if(action==DOWN){
			changePicAndMove(0);
			heroY = heroY + 5;
	  }
	}
	
}



