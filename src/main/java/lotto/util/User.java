package lotto.util;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class User {
    private static int paymentAmount;
    private static Lotto winningNumber;

    public void inputPaymentAmount() {
        String input = Console.readLine();
        checkPaymentAmount(input);
    }

    public void checkPaymentAmount(String input) {
        paymentAmount = Exception.checkInvalidNumber(input);
        Exception.checkUnitPaymentAmount(paymentAmount);
        Exception.checkRangePaymentAmount(paymentAmount);
    }

    public void inputWinningNumber() {
        String input = Console.readLine();
        List<String> numbers = Arrays.asList(input.split(","));
        checkWinningNumber(input, numbers);
        winningNumber = new Lotto(parsNumber(numbers));
    }

    public void checkWinningNumber(String input, List<String> numbers) {
        Exception.checkLastComma(input);
        for (String number : numbers) {
            Exception.checkInvalidNumber(number);
        }
    }

    public List<Integer> parsNumber(List<String> numbers) {
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : numbers) {
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public int getManyLottoTicket() {
        return paymentAmount / 1000;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }
}