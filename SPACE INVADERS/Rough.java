import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;

public class Rough extends JPanel implements KeyListener,Runnable,MouseListener
{

	Enemy a[][] = new Enemy[5][10];
	//int s[] = new int[4];
	Square q[][] = new Square[8][4];

	private float angle;
	private int x;
	private int y;
	private int count;
	private int range;
	private int u=100;
	private int xx=0;
	private int yy=0;
	private int rr;
	private int cc;
	private int lives=3;
	private int life;
	private int tt;
	private int qx;
	private int qy;
	private boolean al;
	private boolean dd=true;
	private boolean aa=true;
	private boolean bb;
	private int adjustment=0;
	private int sx=-20;
	private int sy;
	private int tr;
	private int rd=0;
	private int od=0;
	private int score=0;
	private int level=0;
	private JFrame frame;
	private Thread t;
	private boolean gameOn;
	private boolean up;
	private boolean down;
	private boolean right;
	private boolean left;
	private boolean shot;
	private boolean space;
	private boolean o;
	private Font f;
	private Polygon poly, sammy;
	private GradientPaint gp;
	private Image imageName, invader, invader2, invader3, invader4, port,sq1,sq2,sq3,sq4,invader11,invader21,invader31;
	public Rough()
	{
		frame=new JFrame();
		x=400;
		y=700;
		createEnemies();
		createShields();

		xx=(int)(Math.random()*330)+130;
		yy=(int)(Math.random()*330)+50;
		while (Math.abs(xx-sx)<10||Math.abs(yy-sy)<10&&Math.abs(xx-x)<20&&Math.abs(yy-y)<20)
		{
			xx=(int)(Math.random()*320)+130; //use range of x and y
			yy=(int)(Math.random()*320)+50;
		}
		gameOn=true;
		f=new Font("courier",Font.PLAIN,36);
		frame.addKeyListener(this);
		addMouseListener(this);
		frame.add(this);
		frame.setSize(1146,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		imageName = new ImageIcon(this.getClass().getResource("Varunj.jpg")).getImage();
		invader = new ImageIcon(this.getClass().getResource("0.0.png")).getImage();
		invader2 = new ImageIcon(this.getClass().getResource("1.0.png")).getImage();
		//invader3 = new ImageIcon(this.getClass().getResource("2.1.png")).getImage();
		invader4 = new ImageIcon(this.getClass().getResource("2.0.png")).getImage();
		invader11 = new ImageIcon(this.getClass().getResource("0.1.png")).getImage();
		invader21 = new ImageIcon(this.getClass().getResource("1.1.png")).getImage();
		invader31 = new ImageIcon(this.getClass().getResource("2.1.png")).getImage();
		port = new ImageIcon(this.getClass().getResource("port.png")).getImage();
		sq1 = new ImageIcon(this.getClass().getResource("sqa.png")).getImage();
		sq2 = new ImageIcon(this.getClass().getResource("sqa1.png")).getImage();
		sq3 = new ImageIcon(this.getClass().getResource("sqa2.png")).getImage();
		sq4 = new ImageIcon(this.getClass().getResource("sqa3.png")).getImage();
		MediaTracker m = new MediaTracker(this);
		m.addImage(imageName, 0);
		try
		{
			m.waitForID(0);
		}
		catch (InterruptedException e){}
		t=new Thread(this);
		t.start();
	}

	public void resetGame()
	{
		tr=0;
		score=0;
		x=(int)(Math.random()*320)+130;
		y=(int)(Math.random()*320)+50;
		xx=(int)(Math.random()*320)+130; //use range of x and y
		yy=(int)(Math.random()*320)+50;

		while (Math.abs(xx-sx)<10||Math.abs(yy-sy)<10&&Math.abs(xx-x)<20&&Math.abs(yy-y)<20)
		{
			xx=(int)(Math.random()*320)+130; //use range of x and y
			yy=(int)(Math.random()*320)+50;
		}

		// for (int r=0;r<5;r++)
		 //for (int c=0;c<10;c++)
//		reclear list, start moving again
		 gameOn=true;
		 lives=3;

	}

	public void run()
	{
		while(true)
		{

			if(gameOn)
			{
				if (right && x<900)
					x++;
				if (left && x>30)
					x--;
				if (space)
				{	sx=x+25;
				 	sy=y-20;
				 	shot=true;
			    }
			    if (shot==true)
			    {
					sy-=1;

				}
				if (sy==10)
				{
					shot=false;

				}


//for (Enemy e : list)
//	e.move();

count++;
	for (int r=0;r<5;r++)
		 for (int c=0;c<10;c++)
		 {
		{
			if ((c==0)&&(a[r][c].getx()<=50)&&a[r][c].getDirection()==false)
			for (int vr=0;vr<5;vr++)
				 for (int vc=0;vc<10;vc++)
		 			a[vr][vc].changeDirectionTrue();
			if ((c==9)&&(a[r][c].getx()>=930&&a[r][c].getDirection()==true))
			for (int vr=0;vr<5;vr++)
				 for (int vc=0;vc<10;vc++)
				 	a[vr][vc].changeDirectionFalse();

		if (count%3==0)
		a[r][c].move();

		 }
		 }
				Ellipse2D.Double circle=new Ellipse2D.Double(x,y,20,20);
			//	reset enemy list
				if(circle.intersects(new Rectangle(sx,sy,5,15))) //This code is what happens to advance to the next level
				{
					score+=5;

					System.out.println("NEXT LEVEL");
					level+=1;






							//new enemy list



				}

				Rectangle missile=new Rectangle(sx,sy,5,15);
					for (int r=0;r<5;r++)
					   for (int c=0;c<10;c++)
					    if (a[r][c].getAlive()&& missile.intersects(new Rectangle(a[r][c].getx(),a[r][c].gety(),30,30)) )
					    {
								a[r][c].die();
								if (a[r][c].gett()==0)
								score+=30;
								if (a[r][c].gett()==1)
								score+=20;
								if (a[r][c].gett()==2)
								score+=10;

								a[r-1][c].changeBottom();
								sy=-20;
								shot=false;

						}

				for (int hr=0;hr<8;hr++)
		    	for (int hc=0;hc<4;hc++)
			     if (q[hr][hc].getAlive()&& missile.intersects(new Rectangle(q[hr][hc].getx(),q[hr][hc].gety(),25,25)) )
			  	 {
					q[hr][hc].die();
					if (hr!=0)



					shot=false;


				 }

					for (int r=0;r<5;r++)
					 for (int c=0;c<10;c++)

					if (a[r][c].shot())
					  {
				      Rectangle missile2=new Rectangle(a[r][c].getMx(),a[r][c].getMy(),5,15);
				      for (int hr=0;hr<8;hr++)
					   for (int hc=0;hc<4;hc++)
				        if (q[hr][hc].getAlive()&& missile2.intersects(new Rectangle(q[hr][hc].getx(),q[hr][hc].gety(),25,25)) )
				       	{
							q[hr][hc].die();
							a[r][c].shotEnd();
						}

					}
						for (int r=0;r<5;r++)
					 for (int c=0;c<10;c++)
					 {Rectangle missile3=new Rectangle(a[r][c].getMx(),a[r][c].getMy(),5,15);
						if (missile3.intersects(new Rectangle(x,y,80,30)) )
						{
							a[r][c].shotEnd();
							lives--;
							//move yourself back to center
							//remove missile from list of missiles?
						}

					 }




				 for (int hr=0;hr<5;hr++)
		    	for (int hc=0;hc<10;hc++)
		    	{
					range=(int)(Math.random()*10000);
					if (range<10&&a[hr][hc].getBottom())
					a[hr][hc].shoot();

}
			 for (int hr=0;hr<5;hr++)
		    	for (int hc=0;hc<10;hc++)
			if (a[hr][hc].shot())
						a[hr][hc].moveShot();



			}
			try
			{
				t.sleep(5);
			}
			catch(InterruptedException e)
			{

			}
			repaint();
		}
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(imageName,0,0,this);



		g2d.setColor(Color.BLUE);
		for (int r=0;r<5;r++)
		    for (int c=0;c<10;c++)
		    if (a[r][c].getAlive()==true)
		    	{

				if (a[r][c].gett()==0 && (a[r][c].getx()/25)%2==0)
					g2d.drawImage(invader,a[r][c].getx(),a[r][c].gety(),this);
				if (a[r][c].gett()==1 && (a[r][c].getx()/25)%2==0)
					g2d.drawImage(invader2,a[r][c].getx(),a[r][c].gety(),this);
				if (a[r][c].gett()==2 && (a[r][c].getx()/25)%2==0)
					g2d.drawImage(invader4,a[r][c].getx(),a[r][c].gety(),this);

				if (a[r][c].gett()==0 && (a[r][c].getx()/25)%2==1)
					g2d.drawImage(invader11,a[r][c].getx(),a[r][c].gety(),this);
				if (a[r][c].gett()==1 && (a[r][c].getx()/25)%2==1)
					g2d.drawImage(invader21,a[r][c].getx(),a[r][c].gety(),this);
				if (a[r][c].gett()==2 && (a[r][c].getx()/25)%2==1)
					g2d.drawImage(invader31,a[r][c].getx(),a[r][c].gety(),this);

g2d.setColor(Color.WHITE);
	for (int hr=0;hr<8;hr++)
	for (int hc=0;hc<4;hc++)
				if (a[r][c].shot())
				g2d.fillRect(a[r][c].getMx(),a[r][c].getMy(),5,15);
				}

		g2d.setColor(Color.GREEN); // hero
		g2d.drawImage(port,x,y,this);
		if (lives>=1)
		g2d.drawImage(port,0,30,this);
		if (lives>=2)
		g2d.drawImage(port,100,30,this);
		if (lives==3)
		g2d.drawImage(port,200,30,this);

		if (sy!=10)
		{
		g2d.setColor(Color.WHITE); //  square
		g2d.fillRect(sx+13,sy+15,5,15);


		}
		if (lives==0)
				{	g2d.setColor(Color.WHITE);
					g2d.drawString("GAME OVER",220,190);

				}
				g2d.setColor(Color.WHITE);
						g2d.drawString("Score:",1,300);
						String score2 = ""+score;
						g2d.setColor(Color.GREEN);
		g2d.drawString(score2,50,330);
	g2d.setColor(Color.GREEN);
	for (int hr=0;hr<8;hr++)
	for (int hc=0;hc<4;hc++)
			{
				if (q[hr][hc].getAlive()==true)
				{
					if (q[hr][hc].getLife()==4)
						g2d.drawImage(sq1,q[hr][hc].getx(),q[hr][hc].gety(),this);
					if (q[hr][hc].getLife()==3)
						g2d.drawImage(sq2,q[hr][hc].getx(),q[hr][hc].gety(),this);
					if (q[hr][hc].getLife()==2)
						g2d.drawImage(sq3,q[hr][hc].getx(),q[hr][hc].gety(),this);
					if (q[hr][hc].getLife()==1)
						g2d.drawImage(sq4,q[hr][hc].getx(),q[hr][hc].gety(),this);




					}

			}
	}
	public void keyPressed(KeyEvent ke)
	{
		System.out.println(ke.getKeyCode());

		if (ke.getKeyCode()==37)
			left=true;

		if (ke.getKeyCode()==39)
			right=true;
		if (ke.getKeyCode()==32&&shot==false)
			space=true;



	}
	public void keyReleased(KeyEvent ke)
	{
		if (ke.getKeyCode()==37)
			left=false;

		if (ke.getKeyCode()==39)
			right=false;
		if (ke.getKeyCode()==32)
			space=false;


	}
	public void keyTyped(KeyEvent ke)
	{

	}
	public void mouseExited(MouseEvent me)
	{

	}
	public void mouseEntered(MouseEvent me)
	{

	}
	public void mouseReleased(MouseEvent me)
	{
	adjustment=0;
	}
	public void mouseClicked(MouseEvent me)
	{
		int mx=me.getX();
		int my=me.getY();

		Rectangle newButton=new Rectangle(9,170,100,45);

		if (newButton.contains(mx,my))
		{
			System.out.println("NEW GAME");
			resetGame();
		}
	}
	public void mousePressed(MouseEvent me)
	{
	adjustment=3;
	}
	public void createEnemies()
	{


	   for (int r=0;r<5;r++)
		   for (int c=0;c<10;c++)
		   {

		  xx=30+(c*76);
		  yy=96+(r*76);
		   if (r==4)
		   bb=true;
		   if (r==0)
		   tt=0;
		   if ((r==1)||(r==2))
		   tt=1;
		   if ((r==3)||(r==4))
		   tt=2;
		   else bb=false;
		   aa=true;
		   dd=true;
		   a[r][c]=new Enemy(xx,yy,r,c,tt,dd,aa,bb);

		   }
	}

	public void createShields()
	{

		qx=80;
		qy=600;
		al=true;

	for (int hr=0;hr<8;hr++)
	for (int hc=0;hc<4;hc++)
			{
				if (hc==0)
				u=0;
				if (hc==1)
				u=225;
				if (hc==2)
				u=450;
				if (hc==3)
				u=675;

					if (hr==0)
					q[hr][hc]=new Square(80+u,650,al,4);
					if (hr==1)
					q[hr][hc]=new Square(80+u,625,al,4);
					if (hr==2)
					q[hr][hc]=new Square(80+u,600,al,4);
					if (hr==3)
					q[hr][hc]=new Square(105+u,600,al,4);
					if (hr==4)
					q[hr][hc]=new Square(130+u,600,al,4);
					if (hr==5)
					q[hr][hc]=new Square(155+u,600,al,4);
					if (hr==6)
					q[hr][hc]=new Square(155+u,625,al,4);
					if (hr==7)
					q[hr][hc]=new Square(155+u,650,al,4);


			}
	}


	public static void main(String args[])
	{
		Rough app=new Rough();
	}
}