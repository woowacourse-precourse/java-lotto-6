package Controller;

public class ExceptionHandler {
    public void checkPriceUnit(int price) {
        if(price % 1000 != 0) {
            throw new IllegalArgumentException(
                    ExceptionSentence.PRICE_BOUNDARY_ERROR.getMessage()
            );
        }
    }

    public void checkNumberBoundary(int number) {
        if(number < 1 || number > 46) {
            throw new IllegalArgumentException(
                    ExceptionSentence.BOUNDARY_ERROR.getMessage()
            );
        }
    }
}
