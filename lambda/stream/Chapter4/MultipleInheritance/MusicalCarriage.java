package stream.Chapter4.MultipleInheritance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.Level;

import java.util.Optional;

/**
 * Which methods it should inherit?
 */
public class MusicalCarriage implements Carriage,Jukebox {
    //solution
    @Override
    public  String rock()
    {
        return Jukebox.super.rock();
    }


}


