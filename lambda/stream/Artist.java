package stream;


import java.util.ArrayList;

public class Artist
{

    private String name;
    private ArrayList<Artist> members;
    private String origin;


    protected Artist(String aName, String aOrigin)
    {
        this.name=aName;
        this.origin=aOrigin;
        this.members=new ArrayList<>();
    }

    protected void addMember(Artist member)
    {
        this.members.add(member);
    }

    protected String getName() {
        return name;
    }

    protected String getOrigin() {
        return origin;
    }

    protected ArrayList<Artist> getMembers() {
        return members;
    }

    protected boolean isFrom(String city)
    {
        return city.equals(this.getOrigin());
    }
}


