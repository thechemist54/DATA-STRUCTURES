
public abstract class GameCharacter    //defining abstract class
{
    //instance variables where healthPoints is public instance variable initialized to 100

    private String name;
    public int healthPoints = 100;
    private int x;
    private int y;

    /**
     * Initializes GameCharacter object with all properties specified
     * @param name The name of the Game Character
     * @param x The x co-ordinate
     * @param y The y co-ordinate
     */

    public GameCharacter(String name,  int x, int y)
    {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the name of character
     * @return Name of character
     */

    public String getName()
    {
        return name;
    }

    /**
     * Gets the health points of character
     * @return health points of character
     */

    public int getHealthPoints()
    {
        return healthPoints;
    }

    /**
     * Gets the x coordinate of character
     * @return x coordinate of character
     */

    public int getX()
    {
        return x;
    }

    /**
     * Gets the y coordinate of character
     * @return y coordinate of character
     */

    public int getY()
    {
        return y;
    }

    /**
     * Sets the x coordinate of character
     * @param x value to set to x
     */

    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * Sets the y coordinate of character
     * @param y value to set to y
     */

    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * Abstract method for character movement
     * @param direction The direction in which the character moves
     * @param distance The distance in which the character moves
     */

    public abstract void move(char direction, int distance);

    /**
     * Abstract method for character to attack
     * @param target The target to which the attacker attacks
     * @return True or False if the attack is successful or unsuccessful respectively
     */
    public abstract boolean attack (GameCharacter target);

    /**
     * Abstract method to get the required string
     * @return A string value with all the information about the character
     */
    public abstract String toString();
}
