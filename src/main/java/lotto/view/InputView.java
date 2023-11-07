package lotto.view;

import lotto.util.validate.InputValidate;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.validate.InputValidate.*;

public class InputView {

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();

        int parseIntInputValue = validateInputFormat(input);
        validateThousandUnitInputFormat(parseIntInputValue);

        return Integer.parseInt(input) / 1000;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();

        List<Integer> winningNumbers = Arrays.stream(input.split(",")).
                mapToInt(Integer::parseInt).boxed().toList();

        validateRangeInputLottoNumbers(winningNumbers);
        validateUniqueInputLottoNumbers(winningNumbers);

        return winningNumbers;
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = readLine();

        int bonusNumber = validateInputFormat(input);
        validateRangeInputLottoBonusNumber(bonusNumber);
        validateUniqueInputLottoBonusNumber(winningNumbers, bonusNumber);

        return Integer.parseInt(input);
    }


}
