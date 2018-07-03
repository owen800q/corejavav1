package stream;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlbumTest {

    public static void main(String []args)
    {
        Album obj=new Album("Cstle in the sky");
        obj.addMusicians(new Artist("kwan", "Hong Kong"));
        obj.addMusicians(new Artist("Thewika", "Canada"));
        obj.addMusicians(new Artist("aaaa", "London"));
        obj.addMusicians(new Artist("Thebbbb", "London"));
     obj.getMusicians()
                .filter(e->e.getName().startsWith("The"))
                .map(f->f.getOrigin())
                .forEach(System.out::println);

    }
}
