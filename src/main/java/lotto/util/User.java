package lotto.util;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.enums.LottoNumberRange;

public class User {
    private static int paymentAmount;
    private static Lotto winningNumber;
    private static int manyLottoTicket;
    private static int bonusNumber;

    public void inputPaymentAmount() {
        String input = Console.readLine();
        checkPaymentAmount(input);
        manyLottoTicket = howManyLottoTicket();
    }

    public void checkPaymentAmount(String input) {
        paymentAmount = Exception.checkInvalidNumber(input);
        Exception.checkUnitPaymentAmount(paymentAmount);
        Exception.checkRangePaymentAmount(paymentAmount);
    }

    public int howManyLottoTicket() {
        return paymentAmount / LottoNumberRange.MIN_PAYMENT_AMOUNT.getValue();
    }

    public void inputWinningNumber() {
        String input = Console.readLine();
        List<String> numbers = Arrays.asList(input.split(","));
        checkWinningNumber(input, numbers);
        winningNumber = new Lotto(parseNumber(numbers));
    }

    public void checkWinningNumber(String input, List<String> numbers) {
        Exception.checkLastComma(input);
        for (String number : numbers) {
            Exception.checkInvalidNumber(number);
        }
    }

    public List<Integer> parseNumber(List<String> numbers) {
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : numbers) {
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }

    public void inputBonusNumber() {
        String input = Console.readLine();
        checkBonusNumber(input);
    }

    public void checkBonusNumber(String input) {
        bonusNumber = Exception.checkInvalidNumber(input);
        Exception.checkRangeLottoNumber(bonusNumber);
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public int getManyLottoTicket() {
        return manyLottoTicket;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }
}