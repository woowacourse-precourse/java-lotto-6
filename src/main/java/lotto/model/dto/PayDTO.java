package lotto.model.dto;
import static lotto.constants.ExceptionMessages.CATCH_ERROR;
import static lotto.constants.ExceptionMessages.INPUT_EMPTY;
import static lotto.constants.ExceptionMessages.INVALID_NUMBER;
import static lotto.constants.ExceptionMessages.INVALID_PAYMENT;

import lotto.constants.ExceptionMessages;
public class PayDTO {
    private static final int PRICE_OF_LOTTO = 1000;
    private int payment;
    private PayDTO(int payment){
        this.payment = payment;
    }

    public static PayDTO from(String text){
        int payment = validatePayment(text);
        return new PayDTO(payment);
    }

    public int getNumberOfLotto(){
        return payment / PRICE_OF_LOTTO;
    }

    private static int validatePayment(String text) {
        checkNull(text);
        int payment = toInt(text);
        checkFollowRule(payment);
        return payment;
    }

    private static int toInt(String text) {
        try{
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(CATCH_ERROR + INVALID_NUMBER);
        }
    }

    private static void checkFollowRule(int payment) {
       if(isDividedByLottoPrice(payment)){
           throw new IllegalArgumentException(CATCH_ERROR + INVALID_PAYMENT);
       }
    }

    private static boolean isDividedByLottoPrice(int payment){
        return payment % PRICE_OF_LOTTO != 0;
    }

    private static void checkNull(String text) {
        if(text == null || text.isEmpty()) throw new IllegalArgumentException(CATCH_ERROR + INPUT_EMPTY);
    }

    public int getPayment() {
        return payment;
    }
}
