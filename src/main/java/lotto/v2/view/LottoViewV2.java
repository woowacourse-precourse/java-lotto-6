package lotto.v2.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.v1.util.LottoValidationUtilsV1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoViewV2 {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseMoney(Console.readLine());
    }

    private int parseMoney(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액으로 숫자를 입력해야 합니다.");
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분)");
        String input = Console.readLine();
        List<Integer> winningNumbers = Stream.of(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return winningNumbers;
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            LottoValidationUtilsV1.checkValidBonusNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호로 숫자를 입력해야 합니다.");
        }
    }

}
