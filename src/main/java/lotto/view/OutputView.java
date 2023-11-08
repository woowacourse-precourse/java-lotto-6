package lotto.view;

import java.text.MessageFormat;
import lotto.constant.ErrorMessage;
import lotto.constant.IOMessage;
import lotto.constant.LottoRanking;
import lotto.model.Lotto;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(ErrorMessage.format(message));
    }

    public void printLottoCountMessage(int count) {
        System.out.println(MessageFormat.format(IOMessage.OUTPUT_LOTTO_COUNT_MESSAGE, count));
    }

    public void printLottoNumber(Lotto lotto) {
        System.out.println(MessageFormat.format(IOMessage.OUTPUT_LOTTO_NUMBER_MESSAGE, lotto.getNumbersAsString()));
    }

    public void printRankingMessage() {
        System.out.println(IOMessage.OUTPUT_LOTTO_STATISTIC_MESSAGE);
    }

    public void printRankingInfo(LottoRanking ranking, long count) {
        String bonusMessage = "";
        if (ranking.isBonus()) {
            bonusMessage = IOMessage.OUTPUT_LOTTO_RANKING_BONUS_MESSAGE;
        }
        System.out.println(MessageFormat.format(IOMessage.OUTPUT_LOTTO_RANKING_MESSAGE, ranking.getHit(), bonusMessage, ranking.getPrice(), count));
    }

    public void printRateOfReturn(double rate) {
        System.out.println(MessageFormat.format(IOMessage.OUTPUT_RATE_OF_RETURN_MESSAGE, String.format("%.1f", rate)));
    }

    public void printLine() {
        System.out.println();
    }
}
