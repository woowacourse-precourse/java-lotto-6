package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import lotto.domain.dto.BonusNumberDto;
import lotto.domain.dto.PurchaseAmountDto;
import lotto.domain.dto.WinningLottoDto;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningLottoValidator;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public PurchaseAmountDto inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String input = readLine().trim();
        PurchaseAmountValidator.inputValidate(input);

        return new PurchaseAmountDto(Integer.parseInt(input));
    }

    public WinningLottoDto inputWinningLotto() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String input = readLine().trim();
        WinningLottoValidator.inputValidate(input);
        List<Integer> numbers = convertToList(input);

        return new WinningLottoDto(numbers);
    }

    private List<Integer> convertToList(final String input) {
        return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
    }

    public BonusNumberDto inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = readLine().trim();
        BonusNumberValidator.inputValidate(input);

        return new BonusNumberDto(Integer.parseInt(input));
    }
}
