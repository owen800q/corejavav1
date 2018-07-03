package basic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

public class DateFormatTest {


        static final  ThreadLocal<DateFormat> n= ThreadLocal.withInitial(()-> new SimpleDateFormat("dd-MM-yyyy"));


}