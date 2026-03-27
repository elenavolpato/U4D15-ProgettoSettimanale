package elena.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String isbn){
        super("error");
    }
}
