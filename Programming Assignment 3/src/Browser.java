import java.util.*;
import java.net.*;          //importing different java classes
import java.io.*;

/**
Defining Browser class which
simulates the navigational tools of an Internet browser,
using Stack object(s) to keep track of the sites visited.
*/

public class Browser
{
    private URL webpage;
    private StackInt<String> after = new LinkedStack<>();
    
    private StackInt<String> ini = new LinkedStack<>();   //defining different stack
                                                            //variables using StackInt type.
    private StackInt<String> fun = new LinkedStack<>();

    /**
     * A non argument constructor which initializes
     * the browser object with url"www.ulm.edu"
     */
    public Browser()
    {
        try     //exception handling
        {
            webpage = new URL("http://www.ulm.edu");
            ini.push("http://www.ulm.edu");
        }
        catch(Exception e)
        {

        }

    }

    /**
     * An argument constructor to initialize the url of the webpage.
     * @param url The url of the webpage the user wants to load.
     */

    public Browser(String url)
    {
        try
        {
            webpage = new URL(url);
            if (webpage.getContent() != null)
            {
                ini.push(url);
            }


        }

        catch(Exception e)
        {

            ini.push("ERROR: CANNOT FIND "+url);
        }
    }

    /**
     * A method that loads the webpage with the URL passed as argument.
     * @param url The url of the webpage the user wants to load.
     * @return Method returns True or False depending on whether the url is valid or not.
     */

    public boolean load(String url)
    {
        boolean t = true;
        try
        {
            webpage = new URL(url);
            if(webpage.getContent() != null)
            {
                ini.push(url);
            }


        }

        catch(Exception e)
        {
            ini.push("ERROR: CANNOT FIND "+url);
            t = false;
        }

        return t;
    }

    /**
     * A method that gives the URL of the current page.
     * @return The top string object in the stack.
     */

    public String currentPage()
    {
        return ini.peek();


    }

    /**
     * A method that determines whether the user can go back to previous page.
     * @return True or False depending upon whether there is a previous page or not.
     */

    public boolean canGoBack()
    {
        String n =ini.pop();
        if(ini.empty())
        {
            ini.push(n);
            return false;

        }
        ini.push(n);
        return !ini.empty();


    }

    /**
     * A method that determines whether the user can go to the next page.
     * @return True or False depending upon whether there is a next page or not.
     */

    public boolean canGoForward()
    {

        return !after.empty();
    }

    /**
     * A method that goes back to the previous page.
     * @return The previous webpage.
     */

    public String goBack()
    {
        String p = "";
        if(!ini.empty())
        {
            after.push(ini.peek());
            p = ini.pop();

        }

        else
        {

            p = after.peek();
        }

        return p;

    }

    /**
     * A method that goes to the next page in the browsing history.
     * @return The next page.
     */

    public String goForward()
    {
        String p = "";
        if(!after.empty())
        {
            ini.push(after.peek());
            p = after.pop();


        }

        else
        {

            p = ini.peek();
        }

        return p;

    }

    /**
     * A method to display web history.
     * @return A list of pages loaded in the current browsing session.
     */

    public String history()
    {
        String p ="";
        System.out.println("\nHistory:");
        String n = "";


        while(!ini.empty())
        {
            try
            {
                webpage = new URL(ini.peek());
                if(webpage.getContent()!=null)
                {
                    fun.push(ini.peek());
                    p += "\n" + ini.pop();
                }
            }

            catch(Exception e)
            {
                n=ini.pop();
            }


        }

        while(!fun.empty())
        {
            ini.push(fun.pop());
        }
        return p;

    }


}
