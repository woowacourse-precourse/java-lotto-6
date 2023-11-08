package lotto.view.output;

import lotto.view.output.writer.Writer;

public class LottoPrizeOutputView extends OutputView {
    private static final String STRING_INPUT_PRIZE_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String STRING_INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public LottoPrizeOutputView(final Writer writer) {
        super(writer);
    }

    public void printInputPrizeNumberMessage() {
        writer.println(STRING_INPUT_PRIZE_NUMBER_MESSAGE);
    }

    public void printInputBonusNumberMessage() {
        writer.println(STRING_INPUT_BONUS_NUMBER_MESSAGE);
    }
}
