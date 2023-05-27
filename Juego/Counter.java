import greenfoot.*;  

public class Counter extends Actor
{
    private int score;
    
    public Counter()
    {
        score = 0;
        setImage (new GreenfootImage(200, 30));
        update();
    }
    
    public void addScore()
    {
        score++;
        update();
    }
    
    private void update()
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setColor(Color.WHITE);
        img.setFont(img.getFont().deriveFont(24.0F));
        img.drawString("Score: " + score, 4, 20);
    }
}
