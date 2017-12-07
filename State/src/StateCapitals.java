import java.util.*;
import java.io.*;
public class StateCapitals
{

    private Map<String,String> set1;
    private Map<String,String> set2;
    public StateCapitals()
    {
        set1 = new HashMap<>();
        set2 = new HashMap<>();

    }

    public void addState()
    {
        set2.put("Alabama","AL");
        set2.put("Alaska","AK");
        set2.put("Alberta","AB");
        set2.put("American Samoa","AS");
        set2.put("Arizona","AZ");
        set2.put("Arkansas","AR");
        set2.put("Armed Forces (AE)","AE");
        set2.put("Armed Forces Americas","AA");
        set2.put("Armed Forces Pacific","AP");
        set2.put("British Columbia","BC");
        set2.put("California","CA");
        set2.put("Colorado","CO");
        set2.put("Connecticut","CT");
        set2.put("Delaware","DE");
        set2.put("District Of Columbia","DC");
        set2.put("Florida","FL");
        set2.put("Georgia","GA");
        set2.put("Guam","GU");
        set2.put("Hawaii","HI");
        set2.put("Idaho","ID");
        set2.put("Illinois","IL");
        set2.put("Indiana","IN");
        set2.put("Iowa","IA");
        set2.put("Kansas","KS");
        set2.put("Kentucky","KY");
        set2.put("Louisiana","LA");
        set2.put("Maine","ME");
        set2.put("Manitoba","MB");
        set2.put("Maryland","MD");
        set2.put("Massachusetts","MA");
        set2.put("Michigan","MI");
        set2.put("Minnesota","MN");
        set2.put("Mississippi","MS");
        set2.put("Missouri","MO");
        set2.put("Montana","MT");
        set2.put("Nebraska","NE");
        set2.put("Nevada","NV");
        set2.put("New Brunswick","NB");
        set2.put("New Hampshire","NH");
        set2.put("New Jersey","NJ");
        set2.put("New Mexico","NM");
        set2.put("New York","NY");
        set2.put("Newfoundland","NF");
        set2.put("North Carolina","NC");
        set2.put("North Dakota","ND");
        set2.put("Northwest Territories","NT");
        set2.put("Nova Scotia","NS");
        set2.put("Nunavut","NU");
        set2.put("Ohio","OH");
        set2.put("Oklahoma","OK");
        set2.put("Ontario","ON");
        set2.put("Oregon","OR");
        set2.put("Pennsylvania","PA");
        set2.put("Prince Edward Island","PE");
        set2.put("Puerto Rico","PR");
        set2.put("Quebec","QC");
        set2.put("Rhode Island","RI");
        set2.put("Saskatchewan","SK");
        set2.put("South Carolina","SC");
        set2.put("South Dakota","SD");
        set2.put("Tennessee","TN");
        set2.put("Texas","TX");
        set2.put("Utah","UT");
        set2.put("Vermont","VT");
        set2.put("Virgin Islands","VI");
        set2.put("Virginia","VA");
        set2.put("Washington","WA");
        set2.put("West Virginia","WV");
        set2.put("Wisconsin","WI");
        set2.put("Wyoming","WY");
        set2.put("Yukon Territory","YT");



    }

    public String capital(String stateCode)
    {

        Iterator iter1 = set2.keySet().iterator();
        String item="";

        while(iter1.hasNext())
        {
            item = (String) iter1.next();
            if(set2.get(item).equals(stateCode))
            {

                break;
            }

        }
        return item;

    }
}
