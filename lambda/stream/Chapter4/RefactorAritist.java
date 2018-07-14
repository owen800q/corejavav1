package stream.Chapter4;

import java.util.List;
import java.util.Optional;

public class RefactorAritist {

    private List<Artist> group;

    protected RefactorAritist(List<Artist> group) {
        this.group = group;

    }


    private Optional<Artist> getArtist(int index) {

        if (index < 0 || index >= group.size())
        {

            return Optional.empty();
        }

        return Optional.of(group.get(index));

    }

    protected String getArtistName(int index)
    {
        Optional <Artist> artist=getArtist(index);
        /*
        if(artist.isPresent())
        {
            return artist.get().getName();
        }

        return "unknown";*/
        return artist.map(Artist::getName)
                .orElse("unknown");

    }

}
