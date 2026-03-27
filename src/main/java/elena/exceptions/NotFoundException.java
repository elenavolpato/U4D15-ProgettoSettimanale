package elena.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id){
        super("error");
    }
}
