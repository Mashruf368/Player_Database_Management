package Interface;
//package Players;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Database.Player;
import Database.PlayerList;

import java.io.File;
public class Save_players {
    
    


    static void save(){
        System.out.println("in save function\n");
        List<Player> real = PlayerList.getlist();

        //for(int i=0;i<real.size();i++) real.get(i).printplayer();
    
    
        Set<String> player_names = new HashSet<>();
    ArrayList<Player> initial = new ArrayList<>();
    try{
        //BufferedReader me = new BufferedReader(new FileReader("players.txt"));
        BufferedReader me = new BufferedReader(new InputStreamReader(
        Main.class.getResourceAsStream("players.txt")
        )   );
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
                //temp.printplayer();
                initial.add(temp);
                player_names.add(temp.name);
                //player_number++;
                //System.out.println("no of players is " + player_number);
            }
            me.close();
        } catch(Exception ex){
            System.out.println("error 1");
        }
        //initial has old players
        //playerlist has new players


        try(FileWriter writer = new FileWriter("players.txt",true))
        {
            
            

            for(int i=0;i<real.size();i++)
            {
                    //if(player_names.contains(initial.get(i).name)){}
                    int j=0;
                    int present=0;
                    for(j=0;j<initial.size();j++){
                        if(real.get(i).name.equals(initial.get(j).name)){present=1;}
                    }
                    if(present==0)
                    {
                            //real.get(i).printplayer();
                            writer.write("\n");
                            writer.write(real.get(i).name + ",");
                            writer.write(real.get(i).country + ",");
                            writer.write(real.get(i).age + ",");
                            writer.write(real.get(i).height + ",");
                            writer.write(real.get(i).club + ",");
                            writer.write(real.get(i).position + ",");
                            if(real.get(i).jersey_no !=0)
                            writer.write(real.get(i).jersey_no + ",");
                            else 
                            writer.write(",");
                            writer.write(real.get(i).salary +"");
                    }
                    
                
            }
        }
        catch(IOException ex){
            System.out.println("error 2");
        }

    }

}



//  int i = 0;
    //  try (FileWriter me = new FileWriter("players.txt"))
    // {
    //     while (i<10)
    //     {
    //         System.out.println("in loop\n");
    //         real.get(i).printplayer();
    //         me.write(real.get(i).name + ",");
    //         me.write(real.get(i).country + ",");
    //         me.write(real.get(i).age + ",");
    //         me.write(real.get(i).height + ",");
    //         me.write(real.get(i).club + ",");
    //         me.write(real.get(i).position + ",");
    //         if(real.get(i).jersey_no ==0)
    //         me.write(real.get(i).jersey_no + ",");
    //         else 
    //         me.write(",");
    //         me.write(real.get(i).salary + "\n");

    //         me.flush();
    //         i++;
           
    //     }
        

    // }catch (IOException ex) {
    // System.out.println("Error writing to file: " + ex.getMessage());
    // }

    


