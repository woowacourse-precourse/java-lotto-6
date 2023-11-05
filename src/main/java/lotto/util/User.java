package lotto.util;


import camp.nextstep.edu.missionutils.Console;

public class User {
    private static int paymentAmount;
    private static int manyLottoTicket;

    public void inputPaymentAmount() {
        String input = Console.readLine();
        checkPaymentAmount(input);
        howManyLottoTicket();
    }

    public void checkPaymentAmount(String input) {
        paymentAmount = Exception.checkInvalidNumber(input);
        Exception.checkUnitPaymentAmount(paymentAmount);
        Exception.checkRangePaymentAmount(paymentAmount);
    }

    public void howManyLottoTicket() {
        manyLottoTicket = paymentAmount / 1000;
    }

    public int getPaymentAmount(){
        return paymentAmount;
    }
    public int getManyLottoTicket(){
        return manyLottoTicket;
    }
}