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
    public Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
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
        System.out.println("당첨 번호를 입력해 주세요");
        String numbers = Console.readLine();

        return Stream.of(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
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
        if (number < 1 || number > 45) {
            throw new LottoNumberRangeException();
        }
    }

}
