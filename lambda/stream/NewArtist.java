package stream;

public class NewArtist extends Artist
{

    private boolean solo;
    private boolean band;

    public NewArtist(String aName, String aOrigin,boolean aSolo,boolean aBand)
    {
        super(aName,aOrigin);
        this.solo=aSolo;
        this.band=aBand;
    }

    public boolean isSolo()
    {
        return solo;
    }

    public boolean isBand()
    {
        return band;
    }


}

