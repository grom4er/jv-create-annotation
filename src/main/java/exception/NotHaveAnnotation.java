package exception;

public class NotHaveAnnotation extends RuntimeException{
    public NotHaveAnnotation(String message) {
        super(message);
    }
}
