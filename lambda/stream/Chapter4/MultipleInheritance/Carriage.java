package stream.Chapter4.MultipleInheritance;

public interface Carriage
{
     public default String rock ()
    {
        return "...from side to side";
    }
}
