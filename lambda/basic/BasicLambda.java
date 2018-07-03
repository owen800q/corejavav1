package lambda.basic;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * Basic types of lambda expression
 */
public class BasicLambda
{

    /**
     * A lambda expression without parameter.
     */
    Runnable noArguments=()-> System.out.println("Hello world");

    /**
     * A lambda expression with only one argument.
     * THe parentheses around the argument can be ignored.
     */
    ActionListener oneArgument=event->System.out.println("Hello world");

    /**
     * A lambda expression with multiple statements.
     * Block style
     */
    Runnable multiStatements=()->{

        System.out.println("This is my first program");
        System.out.println("debugging");

        };

    /**
     * A lambda expression with multiple arguments of no specific type
     *
     */
    BinaryOperator<Long> add= (x, y)->x+y;

    /**
     * A lambda expression with explicit types arguments.
     */
    BinaryOperator<Long> addExplicit=(Long x, Long y) ->x+y;


    }

