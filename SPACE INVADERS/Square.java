public class Square
{
	private int x;
	private int y;

	private int life;
	private boolean alive;
		// true= alive
		// false= dead

	public Square (int px, int py, boolean a,int l)
	{
		x=px;
		y=py;
		alive=a;
		life=l;

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
	public int getLife()
		{
			return life;
	}

	public Boolean getAlive()
	{
		return alive;
	}


	public void die()
	{
		life--;
		if (life==0)
		alive=false;

	}

}