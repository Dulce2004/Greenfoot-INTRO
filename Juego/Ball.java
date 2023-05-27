import greenfoot.*;  

public class Ball extends Actor
{
    private int deltaX;         
    private int deltaY;         
    private int count = 2;
    
    private boolean stuck = true; 
    
    public Ball()
    {
    }
    
    public void act() 
    {
        if (!stuck) 
        {
            move();
            checkOut();
            checkBlock();
        }
    }
    
    public void move()
    {
        setLocation (getX() + deltaX, getY() + deltaY);
        checklines();
        checkWalls();
    }
    
    private void checkWalls()
    {
        if (getX() == 0 || getX() == getWorld().getWidth()-1) {
            deltaX = -deltaX;
        }
        if (getY() == 0) {
            deltaY = -deltaY;
        }
    }
    
    private void checkOut()
    {
        if (getY() == getWorld().getHeight()-1) {
            ((Board) getWorld()).ballIsOut();
            getWorld().removeObject(this);
        }
    }
    
    private void checkBlock()
    {
        Actor block = getOneIntersectingObject(Block.class);
        
        if (block != null)
        {
            getWorld().removeObject(block);
            deltaY = -deltaY;
        }
    }
    
    private void checklines()
    {
        Actor paddle = getOneIntersectingObject(lines.class);
        if (paddle != null) {
            deltaY = -deltaY;
            int offset = getX() - paddle.getX();
            deltaX = deltaX + (offset/10);
            if (deltaX > 7) {
                deltaX = 7;
            }
            if (deltaX < -7) {
                deltaX = -7;
            }
            Board myBoard = (Board) getWorld();
            myBoard.score();
        }            
    }

    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
    }
    
    public void release()
    {
        deltaX = Greenfoot.getRandomNumber(11) - 5;
        deltaY = -5;
        stuck = false;
    }
}