import greenfoot.*;  

public class Board extends World
{
    private static final int GAP = 12;

    private lines paddle;
    private Counter counter;

    public Board()
    {    
        super(460, 460, 1);
        counter = new Counter();
        addObject (counter, 113, 440);

        paddle = new lines();
        addObject ( paddle, getWidth() / 2, getHeight() - 40);

        createBlocks();
        prepare();
    }

    public void drawRandomCircles(int howMany)
    {
        int i = 0;
        while (i < howMany) 
        {
            i = i+1;
        }
    }

    private void createBlocks()
    {
        int y = 30;

        while ( y <= 94 ) {
            createRow(y);
            y = y + 20 + GAP;
        }
    }

    private void createRow(int y)
    {
        int x = 50;
        while ( x < 460 ) 
        {
            addObject( new Block(), x, y);
            x = x + 60 + GAP;
        }
    }

    public void ballIsOut()
    {
        paddle.newBall();
    }

    public void score()
    {
        counter.addScore();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}

