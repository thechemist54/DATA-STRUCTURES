
public class Archer extends GameCharacter  //sub class that inherits from super class
{

    private boolean value; //instance variable for this class which is used as a boolean variable in attack method


    /**
     * Initializes Archer class and calls parameters from super class
     * @param name Initializes name of archer
     * @param x Gives X coordinate of  archer
     * @param y Gives y coordinate of archer
     */

    public Archer(String name, int x, int y)

    {
        super(name,x,y);
    }

    /**
     * Defines Archers movement
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
                if (distance>0 && distance<=5)
                {
                    setY(getY() + distance);
                }

                else if(distance<=0)
                {
                    setY(getY());
                }

                else if(distance>5)
                {
                    setY(getY()+5);
                }
            }

            else if(direction=='S')
            {
                if (distance>0 && distance<=5)
                {
                    setY(Math.abs(getY() - distance));

                }

                else if(distance<=0)
                {
                    setY(getY());
                }

                else if(distance>5)
                {
                    setY(Math.abs(getY()-5));
                }
            }

            else if(direction=='E')
            {
                if (distance>0 && distance<=5)
                {
                    setX(getX() + distance);
                }

                else if(distance<=0)
                {
                    setX(getX());
                }

                else if(distance>5)
                {
                    setX(getX()+5);
                }
            }

            else if(direction=='W')
            {
                if (distance>0 && distance<=5)
                {
                    setX(Math.abs(getX() - distance));

                }

                else if(distance<=0)
                {
                    setX(getX());
                }

                else if(distance>5)
                {
                    setX(Math.abs(getX()-5));
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
     * Method for the archer to attack another character
     * @param target The target to which the attacker attacks
     * @return True or False if the attack is successful or unsuccessful respectively
     */

    public boolean attack (GameCharacter target)
    {

        //distance between archer and other character(target)

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
            if(distance1<=30)
            {

                target.healthPoints = target.healthPoints-10;
                value = true;

                if(target.getHealthPoints()<=0)
                {
                    target.healthPoints = 0;
                    value = true;

                }

            }

            else if (distance1 > 30)
            {
                value = false;
            }

        }

        return value;
    }

    /**
     * Method to get the required strings
     * @return A string value that returns all the information about the archer.
     */

    public String toString()
    {
        return "Name: "+super.getName()+"\n"+
               "Type: Archer\n"+
               "Health points: "+super.getHealthPoints()+"\n"+
               "(x,y): ("+super.getX()+","+super.getY()+")\n";
    }


}
