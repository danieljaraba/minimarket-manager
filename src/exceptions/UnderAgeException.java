package exceptions;

public class UnderAgeException extends Exception{

    public UnderAgeException(){
        super("The age of the client is above 18 years old.");
    }
}
