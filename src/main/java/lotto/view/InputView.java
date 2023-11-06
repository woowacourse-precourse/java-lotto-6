package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.WinningNumbersDto;
import lotto.util.validator.LottoNumberValidator;
import lotto.util.validator.Validator;
import lotto.util.validator.ValidatorFactory;

public class InputView {
    public static String inputPurchase() {
        String rawPurchase = input("구입금액을 입력해 주세요.");
        validateNumber(rawPurchase);
        return rawPurchase;
    }

    public static WinningNumbersDto inputWinningNumbers() {
        String rawWinningNumbers = input("당첨 번호를 입력해 주세요.");
        return WinningNumbersDto.from(rawWinningNumbers);
    }

    public static int inputBonusNumber() {
        String rawBonusNumber = input("보너스 번호를 입력해 주세요.");
        validateNumber(rawBonusNumber);
        int bonusNumber = Integer.parseInt(rawBonusNumber);
        LottoNumberValidator.validateRange(bonusNumber);
        return bonusNumber;
    }

    private static void validateNumber(String value) {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator validator = validatorFactory.getValidator(InputView.class);
        validator.validate(value);
    }

    private static String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private InputView() {
    }
}
