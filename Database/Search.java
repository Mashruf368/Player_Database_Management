package Database;
//package Players;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Search {
    
    List<Player> real = PlayerList.getlist();
    

    public Player by_name(String a)
    {
        for(int i=0;i<real.size();i++)
        {
            if(real.get(i).name.equalsIgnoreCase(a)) 
            {
                real.get(i).printplayer();
                return real.get(i);
            }

        }
        System.out.println("No such player with this name\n");
        return null;
    }

    public Vector<Player> by_country(String a)
    {
        Vector <Player> v = new Vector<>();
        for(int i=0;i<real.size();i++)
        {
            if(real.get(i).country.equalsIgnoreCase(a)) 
            {
                v.add(real.get(i));
            }
        }
        PlayerList.printvector(v);
        return v;
    }

    public Vector<Player> by_club(String a)
    {
        Vector <Player> v = new Vector<>();
        for(int i=0;i<real.size();i++)
        {
            if(real.get(i).club.equalsIgnoreCase(a)) 
            {
                v.add(real.get(i));
            }
           
        }
        PlayerList.printvector(v);
        return v;
    }
    public Vector<Player> by_position(String a)
    {
        Vector <Player> v = new Vector<>();
        for(int i=0;i<real.size();i++)
        {
            if(real.get(i).position.equalsIgnoreCase(a)) 
            {

                v.add(real.get(i));
            }
        }
        PlayerList.printvector(v);
        return v;
    }
    public Vector<Player> by_salaryrange(int a,int b)
    {
        Vector <Player> v = new Vector<>();
        for(int i=0;i<real.size();i++)
        {
            if(real.get(i).salary >=a && real.get(i).salary <=b) 
            {
                v.add(real.get(i));
            }
        }
        PlayerList.printvector(v);
        return v;
    }

    public HashMap<String,Integer> country_count()
    {
        HashMap<String,Integer> M =new HashMap<>();
        for(int i=0;i<real.size();i++)
        {
            String s = real.get(i).country;
            if(M.containsKey(s)) M.put(s,(M.get(s)+1));
            else M.put(s,1);
        }
        for(String country : M.keySet())
        {
            System.out.println("Players from " +country + "-" + M.get(country));
        }
        return M;
    }

}
