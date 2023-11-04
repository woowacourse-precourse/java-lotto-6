package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import component.Composer;
import component.input.InputLottoNumbersComponent;
import component.input.InputMoneyComponent;
import io.input.Writer;
import lotto.controller.dto.input.BuyLottosDto;
import lotto.controller.dto.input.DrawLottosDto;

public final class InputView {

    private static final String INPUT_MONEY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private final Writer writer;
    private final Composer composer;

    public InputView(
            final Writer writer,
            final Composer composer
    ) {
        this.writer = writer;
        this.composer = composer;
    }

    public BuyLottosDto inputBuyLottosDto() {
        writer.write(new InputMoneyComponent().render());
        return BuyLottosDto.from(readLine());
    }

    public DrawLottosDto inputDrawLottosDto() {
        writer.write(new InputLottoNumbersComponent().render());
        final String lottoNumbersInput = readLine();

        writer.write(new InputLottoNumbersComponent().render());
        final String bonusNumberInput = readLine();

        return DrawLottosDto.from(lottoNumbersInput, bonusNumberInput);
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
