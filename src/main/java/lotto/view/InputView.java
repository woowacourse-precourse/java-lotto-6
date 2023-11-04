package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import lotto.domain.dto.PurchaseAmountDto;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningLottoValidator;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public PurchaseAmountDto inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String input = readLine();
        PurchaseAmountValidator.inputValidate(input);

        return new PurchaseAmountDto(Integer.parseInt(input));
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String input = readLine();
        WinningLottoValidator.inputValidate(input);

        return Arrays.stream(input.split(", ")).map(Integer::parseInt).toList();
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = readLine();
        BonusNumberValidator.inputValidate(input);

        return Integer.parseInt(input);
    }
}
