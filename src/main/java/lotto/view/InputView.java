package lotto.view;

import static java.lang.Integer.parseInt;
import static lotto.utils.ErrorMessage.IS_LOTTO_NUMBER_DIGIT;
import static lotto.utils.ErrorMessage.IS_PAYMENT_DIGIT;
import static lotto.utils.Message.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Payment;


public class InputView {
    public Payment inputPayment() {
        System.out.println(PAYMENT_INPUT_MESSAGE.getMessage());
        while (true) {
            try {
                Payment payment = new Payment(parseInt(Console.readLine()));
                return payment;
            } catch (NumberFormatException e) {
                System.out.println(IS_PAYMENT_DIGIT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto inputWinningNumbers() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE.getMessage());
        while (true) {
            try {
                List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                return new Lotto(winningNumbers);
            } catch (NumberFormatException e) {
                System.out.println(IS_LOTTO_NUMBER_DIGIT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BonusNumber inputBonusNumber(Lotto winningNumbers) {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE.getMessage());
        while (true) {
            try {
                return new BonusNumber(parseInt(Console.readLine()), winningNumbers);
            } catch (NumberFormatException e) {
                System.out.println(IS_LOTTO_NUMBER_DIGIT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
