package lotto.util;


import camp.nextstep.edu.missionutils.Console;

public class User {
    private static int paymentAmount;

    public void inputPaymentAmount() {
        String input = Console.readLine();
        checkPaymentAmount(input);
    }

    public void checkPaymentAmount(String input){
        paymentAmount = Exception.checkInvalidNumber(input);
        Exception.checkUnitPaymentAmount(paymentAmount);
        Exception.checkRangePaymentAmount(paymentAmount);
    }

    public int getManyLottoTicket() {
        return paymentAmount / 1000;
    }
}