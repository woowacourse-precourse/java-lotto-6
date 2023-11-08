package lotto.UI;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoEnum;
import lotto.utils.CommonHelper;
import lotto.utils.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {
    public String inputCost() {
        String input;
        while (true) {
            try {
                System.out.println("구입금액을 입력해주세요.");
                input = readLine();
                if (costValidate(input)) break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    public List<Integer> inputWinningNumbers() {
        String winningNumbers;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                winningNumbers = readLine();
                winningNumberValidate(winningNumbers);
                if (splitedLottoNumbersValidate(winningNumbers)) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return CommonHelper.splitComma(winningNumbers);
    }

    public String inputBonusNumber(List<Integer> lottoNumbers) {
        String bonusNumber;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = readLine();
                if (numberValidate(bonusNumber) && bonusNumberAndLottoNumbersValidate(bonusNumber, lottoNumbers)) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private boolean costValidate(String input) {
        Validator.isNull(input);
        Validator.isBlank(input);
        Validator.isContainBlank(input);
        Validator.notNumber(input);
        Validator.underByLottoPrice(input);
        Validator.isDivisibleByLottoSize(input);
        return true;
    }

    private boolean winningNumberValidate(String input) {
        Validator.isNull(input);
        Validator.isBlank(input);
        Validator.isContainBlank(input);
        return true;
    }

    private boolean numberValidate(String input) {
        Validator.isNull(input);
        Validator.isBlank(input);
        Validator.isContainBlank(input);
        Validator.notNumber(input);
        Validator.isOneToFortyFive(Integer.parseInt(input));
        return true;
    }

    private boolean splitedLottoNumbersValidate(String input) {
        List<String> splitedLottoNumbers = List.of(input.split(","));

        if (splitedLottoNumbers.size() != LottoEnum.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBER_ERROR.getError());
        }

        for (int i = 0; i < LottoEnum.LOTTO_SIZE.getValue(); i++) {
            numberValidate(splitedLottoNumbers.get(i));
            Validator.isDuplicate(splitedLottoNumbers, splitedLottoNumbers.get(i), i);
        }
        return true;
    }

    private boolean bonusNumberAndLottoNumbersValidate(String bonusNumber, List<Integer> lottoNumbers) {
        Validator.isDuplicate(lottoNumbers, CommonHelper.strToInt(bonusNumber));
        return true;
    }
}
