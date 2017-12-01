
public class Knight extends GameCharacter  //sub class that inherits from super class
{
    private boolean value; //instance variable for this class which is used as a boolean variable in attack method

    /**
     * Initializes Knight class and calls parameters from super class
     * @param name Initializes name of Knight
     * @param x Gives X coordinate of  Knight
     * @param y Gives y coordinate of Knight
     */

    public Knight(String name, int x, int y)
    {
        super(name,x,y);
    }

    /**
     * Defines Knights movement
     * @param direction The direction in which the character moves
     * @param distance The distance in which the character moves
     */

    public void move(char direction, int distance)
    {
        if(super.getHealthPoints()>=10)    //checks whether health point is >=10
        {
            /**
             * Checks the direction and limitations of distance to move
             * and lets the character move accordingly using setters and getters from
             * super class.
             */

            if(direction=='N')
            {
                if (distance>0 && distance<=2)
                {
                    setY(getY() + distance);
                }

                else if(distance<=0)
                {
                    setY(getY());
                }

                else if(distance>2)
                {
                    setY(getY()+2);
                }
            }

            else if(direction=='S')
            {
                if (distance>0 && distance<=2)
                {
                    setY(Math.abs(getY() - distance));

                }

                else if(distance<=0)
                {
                    setY(getY());
                }

                else if(distance>2)
                {
                    setY(Math.abs(getY()-2));
                }
            }

            else if(direction=='E')
            {
                if (distance>0 && distance<=2)
                {
                    setX(getX() + distance);
                }

                else if(distance<=0)
                {
                    setX(getX());
                }

                else if(distance>2)
                {
                    setX(getX()+2);
                }
            }

            else if(direction=='W')
            {
                if (distance>0 && distance<=2)
                {
                    setX(Math.abs(getX() - distance));

                }

                else if(distance<=0)
                {
                    setX(getX());
                }

                else if(distance>2)
                {
                    setX(Math.abs(getX()-2));
                }
            }
        }

        else if(super.getHealthPoints()<10)
        {
            setX(getX());
            setY(getY());
        }


    }

    /**
     * Method for the Knight to attack another character
     * @param target The target to which the attacker attacks
     * @return True or False if the attack is successful or unsuccessful respectively
     */

    public boolean attack (GameCharacter target)
    {

        //distance between knight and other character(target)

        double distance1 = Math.sqrt(Math.pow(target.getX()-super.getX(),2)
                +Math.pow(target.getY()-super.getY(),2));

        /**
         * Determines whether the attacker can attack or not and decreases health
         * points accordingly.
         */

        if(super.getHealthPoints()<10)
        {
            target.healthPoints = target.healthPoints;
            value = false;
        }

        else if(super.getHealthPoints()>=10)
        {
            if (distance1 <= 5)
            {
                target.healthPoints = target.healthPoints-20;
                value = true;

                if(target.getHealthPoints()<=0)
                {
                    target.healthPoints = 0;
                    value = true;

                }

            }

            else if (distance1 > 5)
            {
                value = false;
            }

        }

        return value;
    }

    /**
     * Method to get the required strings
     * @return A string value that returns all the information about the Knight.
     */

    public String toString()
    {
        return "Name:"+super.getName()+"\n"+
                "Type: Knight\n"+
                "Health points: "+super.getHealthPoints()+"\n"+
                "(x,y): ("+super.getX()+","+super.getY()+")\n";
    }

}
