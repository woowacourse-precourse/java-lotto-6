package lotto.exceptionhandler;

public class RetryExceptionHandler implements ExceptionHandler{

    @Override
    public void handlingException(Runnable runnable) {
        while(true){
            try{
                runnable.run();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }finally {
                System.out.println();
            }
        }
    }
}
