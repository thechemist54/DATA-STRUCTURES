public class DriverClass
{
    public static void main(String[] args)
    {
        StateCapitals stat = new StateCapitals();
        stat.addState();
        System.out.println(stat.capital("FL"));

    }
}
