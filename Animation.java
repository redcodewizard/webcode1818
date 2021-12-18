/*GitHub*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.JFrame;


public class Animation extends JFrame implements Runnable {


	private static final long serialVersionUID = 1L;
	static int dot = 1000;
	private Image dbImage;
	private Graphics dbg; 
    static int x[] = new int [dot];
    static int y[] = new int [dot];
    int rn1 = new Random().nextInt(2);


	public void run() {
		try{
			
			while(true) {
				move();
				Thread.sleep(10);
			}
		}
		catch(Exception e) {System.out.println("Error");}
	}
	

	public void move() {
			

			for(int index = 1; index<dot; index++) {
				
			if(x[index] < 9) {x[index] = 9;}
			if(x[index] > 390) {x[index] = 390;}		
			
			if(y[index] < 31) {y[index] = 31;}
			if(y[index] > 400) {y[index] = 400;}


		    rn1 = new Random().nextInt(4);
	        if(rn1 == 0) {x[index] = x[index] + 1;}
	        if(rn1 == 1) {x[index] = x[index] - 1;}
	        if(rn1 == 2) {y[index] = y[index] + 1;}
	        if(rn1 == 3) {y[index] = y[index] - 1;}		
		}	
		
 		

		
      
		}
	
	
	public Animation() {
		
		
		setTitle("DOTS ANIMATION");
		setSize(400, 410);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
	    
		for(int index = 1; index<dot; index++) {
			x[index] = 195;
			y[index] = 200;
		}

	    
	}
	
	
public static void main(String[] args) {
	Animation jg1 = new Animation();
	
	Thread t1 = new Thread(jg1);
	t1.start();		
}


public void paint(Graphics g) {
	
	dbImage = createImage(getWidth(), getHeight());
	dbg = dbImage.getGraphics();
	paintComponent(dbg);
	
    g.drawImage(dbImage, 0, 0, this);   
}


	public void paintComponent (Graphics g) {

		g.setColor(Color.red);
		
		for(int index = 1; index<dot; index++) {
		g.fillRect(x[index], y[index],4,4);}
		repaint();
}
	
	
}