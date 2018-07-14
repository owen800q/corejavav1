package stream.Chapter4;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.Level;


public class LoggerWithLambda {

    private static final Logger logger =(Logger) LogManager.getLogger(LoggerWithLambda.class);
    public static void main(String args[])
    {
        logger.trace("Entering application.");
        logger.setLevel(Level.DEBUG);
        if(logger.isDebugEnabled())
        {
            logger.debug(String.valueOf(logger.isDebugEnabled()));
            logger.debug("look ai this: ");
        }

        //Using lambda expression to simplify the above logging code

        /*
        	debug(MessageSupplier msgSupplier)
            Logs a message which is only to be constructed if the logging level is the DEBUG level.
         */
        logger.debug(()->"look ai this: ");

    }

}
