package Database;
//package Players;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;


public class PlayerList
{
    public static List<Player> playerList = new ArrayList<>();
    //public static void main(String [] args)
    //{
        public static void makelist(){
        try(BufferedReader me= new BufferedReader(new FileReader("players.txt")))
        {
        //BufferedReader me = new BufferedReader(new FileReader("players.txt"));
        // BufferedReader me = new BufferedReader(new InputStreamReader(
        // Main.class.getResourceAsStream("players.txt")
        // )   );
        String s;
        
            while((s=me.readLine())!=null)
            {
                //s=me.readLine();
                
                int index=0;
                int j=0;
                Player temp = new Player();
                //System.out.println(s);
                for(int i=0;i<s.length();i++)
                {
                    //System.out.println(s.charAt(i));
                    if(s.charAt(i)==',' || i==s.length()-1)
                    {
                        //System.out.println("found at " + i + " " +j);
                        switch(index)
                        {
                            case 0:
                                {
                                    temp.name = s.substring(j, i);
                                    break;
                                }
                            case 1:
                                {
                                    temp.country = s.substring(j, i);
                                    break;
                                }
                            case 2:
                                {
                                    temp.age = Integer.parseInt(s.substring(j, i));
                                    break;
                                }
                            case 3:
                                {
                                    temp.height = Double.parseDouble(s.substring(j,i));
                                    break;

                                }
                            case 4:
                                {
                                    temp.club = s.substring(j,i);
                                    break;
                                }
                            case 5:
                                {
                                    temp.position = s.substring(j,i);
                                    break;
                                }
                            case 6:
                                {
                                    if((s.charAt(j)==',')) temp.jersey_no=0;
                                    else
                                    temp.jersey_no = Integer.parseInt(s.substring(j,i));
                                    break;
                                }

                            default:
                                {
                                    temp.salary = Integer.parseInt(s.substring(j, i));
                                    break;
                                }
                        }
                        j=i+1;
                        index++;
                    }
                    
                }
                //System.out.println(temp.name + " " + temp.country + " " + temp.age + " " + temp.club + " " + temp.height + " " + temp.salary + " " + temp.jersey_no + " " + temp.position);
                playerList.add(temp);
                
            }
            me.close();
        } catch(Exception ex){
            System.out.println("error 3");
            ex.printStackTrace();
        }
    }
    public static void printlist(){
    for(int i=0;i<playerList.size();i++)
    {
        //System.out.println(playerList.get(i).name + " " + playerList.get(i).country + " " + playerList.get(i).age + " " + playerList.get(i).club + " " + playerList.get(i).height + " " + playerList.get(i).salary + " " + playerList.get(i).jersey_no + " " + playerList.get(i).position);
        playerList.get(i).printplayer();
    }
    }

    public static List<Player> getlist()
    {
        return playerList;
    }

    public static void  addplayer()
    {
        Scanner t = new Scanner(System.in);
        System.out.println("Enter player name");

        String a = t.nextLine();
        boolean q=PlayerList.checklist(a);
        if(!q)
        {
            System.out.println("Player with name already exists");
            return;
        }

        System.out.println("Enter country");
        String b = t.nextLine();
        System.out.println("Enter player age");
        int c = t.nextInt();
        t.nextLine();
        System.out.println("Enter player height");
        double d = t.nextDouble();
        t.nextLine();
        System.out.println("Enter club name");
        String e = t.nextLine();
        System.out.println("Enter position of player");
        String f = t.nextLine();
        System.out.println("Enter jersey number");
        String g = t.nextLine();
        int g_no=0;
        if(g != null ) g_no = Integer.parseInt(g);
        System.out.println("Enter salary");
        long h = t.nextInt();
        t.nextLine();

        Player temp = new Player(a, b, c, d, e, f, g_no, h);
        playerList.add(temp);

    }

    public static void printvector(Vector<Player> v)
    {
        System.out.println("Number of players found : " + v.size());
        int index=1;
        for(int i=0;i<v.size();i++) 
        {
            System.out.println("Player " + index++);
            v.get(i).printplayer();
        }
    }
    static boolean  checklist(String a)
    {
        for(int i=0;i<playerList.size();i++)
        {
            if(playerList.get(i).name.equalsIgnoreCase(a)) return false;
        }
        return true;
    }
   
}
