package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Money;

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
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하였습니다.");
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
            throw new IllegalArgumentException("[ERROR] 중복된 보너스 번호를 입력하였습니다.");
        }
    }


    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

}
