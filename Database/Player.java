package Database;
//package Players;

public class Player {
    public String name;
    public String country;
    public int age;
    public double height;
    public String club;
    public String position;
    public int jersey_no;
    public long salary;
    Player(String a,String b,int c,double d,String e,String f,int g,long h)
    {
        name = a;
        country = b;
        age = c;
        height = d;
        club = e;
        position = f;
        jersey_no = g;
        salary = h;
    }
    public Player()
    {
        
    }

    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
    public int getAge() {
        return age;
    }
    public double getHeight() {
        return height;
    }
    public String getClub() {
        return club;
    }
    public String getPosition() {
        return position;
    }
    public int getJersey_no() {
        return jersey_no;
    }
    public long getSalary() {
        return salary;
    }

    public void printplayer()
    {

        System.out.println(this.toString());
    }

    @Override
    public String toString()
    {
        String r;
        String s = "Name : " +name +"\nCountry : " + country + "\nAge : " + age + "\nHeight : " + height + "m\nClub : " + club + "\nPosition : " + position;
        if(jersey_no!=0) r = "\nJersey Number : " + jersey_no ;
        else r = "\nJersey Number : ";
        String t = "\nWeekly Salary : " + salary + "\n";
        return s+r+t;

    }
}
