package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.IO.Input;
import lotto.IO.Output;
import lotto.common.config.LottoWinningRule;

public class View {
    private final Input input;

    public View(Input input) {
        this.input = input;
    }

    public String inputLottoCost() {
        Output.writeLine(OutputMessage.REQUEST_LOTTO_COST.message());
        return input.readLine();
    }

    public String inputWinningNumbers() {
        Output.writeLine(OutputMessage.REQUEST_WINNING_NUMBERS.message());
        return input.readLine();
    }

    public String inputBonusNumber() {
        Output.writeLine(OutputMessage.REQUEST_BONUS_NUMBER.message());
        return input.readLine();
    }

    public void outputPublishedLotto(List<String> publishedLotto) {
        Output.writeLine(publishedLotto.size()+OutputMessage.RESPONSE_PURCHASED_LOTTO_AMOUNT.message());
        StringBuilder shownPublishedLotto = new StringBuilder(publishedLotto.size());
        for (String lottoNumbers:publishedLotto) {
            shownPublishedLotto.append(lottoNumbers).append("\n");
        }
        Output.writeLine(shownPublishedLotto.toString());
    }

    public void outputWinningDetails(Map<LottoWinningRule, Integer> winningDetails) {

    }

    public void outputErrorMessage(IllegalArgumentException e) {
        Output.writeLine(e.getMessage());
    }
}
