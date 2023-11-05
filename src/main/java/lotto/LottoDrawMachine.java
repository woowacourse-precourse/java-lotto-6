package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class LottoDrawMachine {
    private final String inputWinningNumberMessage = "당첨 번호를 입력해 주세요.";
    private final String inputBonusNumberMessage = "보너스 번호를 입력해 주세요.";

    public WinningLotto drawWinningLotto() {
        System.out.println(inputWinningNumberMessage);
        List<Integer> winningNumbers = getWinningNumbers();

        System.out.println(inputBonusNumberMessage);
        Integer bonusNumber = getBonusNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Integer getBonusNumber() {
        try {
            String userInput = Console.readLine();
            Integer bonusNumber = Integer.parseInt(userInput);
            LottoValidator.rangeValidate(List.of(bonusNumber));
            return bonusNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private List<Integer> getWinningNumbers() {
        try {
            String userInput = Console.readLine();
            List<Integer> winningNumbers = Arrays.stream(userInput.split(","))
                    .map(Integer::parseInt)
                    .distinct()
                    .toList();
            LottoValidator.sizeValidate(winningNumbers);
            LottoValidator.rangeValidate(winningNumbers);
            return winningNumbers;
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
