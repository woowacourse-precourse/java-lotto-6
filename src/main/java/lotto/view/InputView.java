package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Money;
import lotto.execption.DuplicateBonusNumberException;
import lotto.execption.InputMoneyParseIntException;
import lotto.execption.LottoNumberRangeException;

public class InputView {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public Money inputMoney() {
        System.out.println(PURCHASE_AMOUNT);
        String input = Console.readLine();
        return parseMoney(input);
    }

    private Money parseMoney(String input) {
        try {
            int money = Integer.parseInt(input);
            return new Money(money);
        } catch (NumberFormatException e) {
            throw new InputMoneyParseIntException();
        }
    }

    public List<Integer> inputLottoWinningNumbers() {
        System.out.println(WINNING_NUMBERS);
        String numbers = Console.readLine();

        return Stream.of(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(BONUS_NUMBER);
        int number = Integer.parseInt(Console.readLine());
        validateRange(number);
        validateDuplicate(winningNumbers, number);
        return number;
    }

    private void validateDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new DuplicateBonusNumberException();
        }
    }

    private void validateRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new LottoNumberRangeException();
        }
    }
}
