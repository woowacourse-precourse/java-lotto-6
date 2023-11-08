package lotto.view;

import lotto.util.validate.InputValidate;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.constant.Constant.PER_THOUSAND;
import static lotto.util.constant.ViewConstant.*;
import static lotto.util.validate.InputValidate.*;

public class InputView {

    public int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println(INPUT_PURCHASE_AMOUNT);
                String input = readLine();

                int parseIntInputValue = validateInputFormat(input);
                validateThousandUnitInputFormat(parseIntInputValue);
                validateNumberRangeInputFormat(parseIntInputValue);

                return Integer.parseInt(input) / PER_THOUSAND;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_WINNING_NUMBERS);
                String input = readLine();

                List<Integer> winningNumbers = Arrays.stream(input.split(","))
                        .map(InputValidate::validateInputFormat)
                        .toList();

                validateRangeInputLottoNumbers(winningNumbers);
                validateAmountInputLottoNumbers(winningNumbers);
                validateUniqueInputLottoNumbers(winningNumbers);

                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER);
                String input = readLine();

                int bonusNumber = validateInputFormat(input);
                validateRangeInputLottoBonusNumber(bonusNumber);
                validateUniqueInputLottoBonusNumber(winningNumbers, bonusNumber);

                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
