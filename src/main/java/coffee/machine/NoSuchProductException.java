package coffee.machine;

public class NoSuchProductException extends RuntimeException{
	private String message;
	   
    public NoSuchProductException(String string) {
        this.message = string;
    }
   
    @Override
    public String getMessage(){
        return message;
    }
}
