import greenfoot.*;  

public class lines extends Actor
{
    private Ball myBall; 

    public lines()
    {
    }
    
    public void addedToWorld(World world)
    {
        newBall();
    }
    
    public void act() 
    {
        if (Greenfoot.isKeyDown ("left")) {
            moveSideways(-9);
        }
        if (Greenfoot.isKeyDown ("right")) {
            moveSideways(9);
        }
        if (haveBall() && Greenfoot.isKeyDown ("space")) {
            releaseBall();
        }
        
    }
    
    private void moveSideways(int dist)
    {
        setLocation (getX() + dist, getY());
        if (myBall != null) {
            myBall.move (dist);
        }
    }
    
    public void newBall()
    {
        myBall = new Ball();
        getWorld().addObject (myBall, getX(), getY()-20);
    }
        
    public boolean haveBall()
    {
        return myBall != null;
    }
        
    public void releaseBall()
    {
        myBall.release();
        myBall = null;
    }
        
}