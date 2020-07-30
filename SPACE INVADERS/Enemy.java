public class Enemy
{
	private int x;
	private int y;

	private int r;
	private int c;

	private int Mx;
	private int My;

	private int t;
	//0 small
	//1 medium
	//2 big


	private boolean bottom;
	// true= yes
	// false= no

	private boolean shot;

	private boolean direction;
	// true= moving right
	// false= moving left

	private boolean alive;
		// true= alive
		// false= dead

	public Enemy (int px, int py, int rc, int cc, int ty, boolean d, boolean a, boolean b)
	{

		direction=d;
		x=px;
		y=py;
		alive=a;
		bottom=b;
		t=ty;
		r=rc;
		c=cc;

	}

//////////////////GET////////////////////////////////////////////////////
	public int getx()
	{
		return x;
	}
	public int gety()
	{
		return y;
	}
	public int getr()
	{
			return r;
	}
	public int getc()
	{
			return c;
	}
	public int gett()
	{
				return t;
	}
	public Boolean getBottom()
	{
		return bottom;
	}
	public Boolean getDirection()
		{
			return direction;
	}
	public Boolean getAlive()
	{
		return alive;
	}

//////////////////////////////////////////////////
	public void move()
	{


				if (direction)
					x+=1;
				else
					x-=1;



	}
	public void changeDirectionTrue()
	{
		direction=true;
		y+=3;

	}
	public void changeDirectionFalse()
	{
		 direction=false;
		 y+=3;
	}
	public void die()
	{
		alive=false;
	}
		public void shoot()
		{	shot=true;
			Mx=x+12;
			My=y+10;


	}
		public boolean shot()
			{
				return shot;
		}
		public int getMx()
		{
			return Mx;
		}
		public int getMy()
		{
			return My;
	}
	public void moveShot()
	{
		My++;




	}
	public void changeBottom()
	{
		bottom=true;
	}
	public void shotEnd()
	{
		shot=false;
	}

}
