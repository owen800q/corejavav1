package stream.Chapter4;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RefactorAritistTest
{


    public static void main(String []args)
    {
        final Logger logger = LoggerFactory.getLogger(RefactorAritist.class);
        Random random = new Random();
        List<Artist> list= Arrays.asList(new Artist(generateString(random,"abcd",4),generateString(random,"zxcv",4)),new Artist(generateString(random,"abcd",4),generateString(random,"zmnf",4)));

        //Test
        RefactorAritist unit=new RefactorAritist(list);


        logger.info("index 1: {} index 5: {}",unit.getArtistName(1),unit.getArtistName(5));
    }

    private static String generateString(Random rng, String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

}
