package exceptions;

public class InvalidDayException extends Exception{

    public InvalidDayException(){
        super("The client cant access to the market this day.");
    }
}
