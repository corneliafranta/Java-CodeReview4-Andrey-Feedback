public class StockLimitReachedException extends RuntimeException  {
    public StockLimitReachedException(String message){
        super(message);
    }
}
