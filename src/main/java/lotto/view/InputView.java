package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public int getUserInputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();

        InputValidator.validateNonSpaced(userInput);
        InputValidator.validateNonZeroLeadingParsableNumber(userInput);
        int purchaseAmount = Integer.parseInt(userInput);
        InputValidator.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public List<Integer> getUserInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();

        InputValidator.validateNonSpaced(userInput);
        InputValidator.validateLottoNumbersPattern(userInput);
        return Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .peek(InputValidator::validateLottoNumber)
                .collect(Collectors.toList());
    }

    public int getUserInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();

        InputValidator.validateNonSpaced(userInput);
        InputValidator.validateNonZeroLeadingParsableNumber(userInput);
        int bonusNumber = Integer.parseInt(userInput);
        InputValidator.validateLottoNumber(bonusNumber);
        return bonusNumber;
    }
}