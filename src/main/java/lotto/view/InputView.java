package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.dto.input.BuyLottosDto;
import lotto.controller.dto.input.DrawLottosDto;

public final class InputView {
    private static final String INPUT_MONEY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public InputView() {
    }

    public BuyLottosDto inputBuyLottosDto() {
        System.out.println(INPUT_MONEY_AMOUNT_MESSAGE);
        final String input = readLine();

        return BuyLottosDto.from(input);
    }

    public DrawLottosDto inputDrawLottosDto() {
        System.out.println(INPUT_LOTTO_NUMBERS_MESSAGE);
        final String lottoNumbersInput = readLine();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        final String bonusNumberInput = readLine();

        return DrawLottosDto.from(lottoNumbersInput, bonusNumberInput);
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
