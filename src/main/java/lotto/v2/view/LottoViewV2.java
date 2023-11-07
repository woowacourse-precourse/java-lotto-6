package lotto.v2.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.v2.util.LottoValidationUtilsV2;

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
        return parseWinningNumbers(Console.readLine());
    }

    private List<Integer> parseWinningNumbers(String input) {
        try {
            List<Integer> winningNumbers = Stream.of(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            LottoValidationUtilsV2.checkValidLottoNumbers(winningNumbers);
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        return parseBonusNumber(Console.readLine(), winningNumbers);
    }

    private int parseBonusNumber(String input, List<Integer> winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(input);
            LottoValidationUtilsV2.checkValidBonusNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호로 숫자를 입력해야 합니다.");
        }
    }

}
