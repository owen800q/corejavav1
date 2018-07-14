package stream.Chapter4;


public class Artist
{

    private String name;
    private String origin;


    protected Artist(String aName, String aOrigin)
    {
        this.name=aName;
        this.origin=aOrigin;

    }



    protected String getName() {
        return name;
    }

    protected String getOrigin() {
        return origin;
    }


    protected boolean isFrom(String city)
    {
        return city.equals(this.getOrigin());
    }


}


