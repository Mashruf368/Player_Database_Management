package Clubs;
//package Players;

import java.util.Vector;

import Database.Player;
import Database.PlayerList;

public class Club_search {
    Vector<Player> team = new Vector<>();
    public long max_salary()
    {
        long max=-1;
        Vector<Player> v= new Vector<>();
        for(int i=0;i<team.size();i++)
        {
            
            if(team.get(i).salary > max) 
            {
                max = team.get(i).salary;
                v.clear();
                v.add(team.get(i));
            }
            if(team.get(i).salary == max) v.add(team.get(i));
        }
        PlayerList.printvector(v);
        //return v;
        return max;
        
    }

    void printteam()   //works
    {
        for(int i=0;i<team.size();i++)
        {
            System.out.println(team.get(i).name + "\n");
        }
    }

    public int max_age()
    {
        int max=-1;
        int index=-1;
        for(int i=0;i<team.size();i++)
        {
            
            if(team.get(i).age > max) 
            {
                max = team.get(i).age;
                index=i;
            }
        }
        team.get(index).printplayer();
        return max;
    }
    public double max_height()
    {
        double max=-1;
        int index=-1;
        for(int i=0;i<team.size();i++)
        {
            
            if(team.get(i).height > max) 
            {
                max = team.get(i).height;
                index=i;
            }
        }
        team.get(index).printplayer();
        return max;
    }

    public long total_yearly_salary()
    {
        long s=0;
        for(int i=0;i<team.size();i++)
        {
            s+=team.get(i).salary*52;
        }
        //return s;
        System.out.println("Total yearly salary is " + s);
        return s;
    }
}
