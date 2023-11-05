package lotto.view;

import java.util.List;
import lotto.constant.LottoMessage;
import lotto.model.LottoRank;

public class OutputView {

    public static void printLottoNumbers(List<Integer> numbers) {
        LottoMessage message = LottoMessage.LOTTO_NUMBERS_OUTPUT_MESSAGE;
        System.out.println(message.getMessage(numbers.toArray()));
    }

    public static void printLottoRank(LottoRank lottoRank, int count) {
        LottoMessage message = getLottoRankMessage(lottoRank.isMatchBonus());

        System.out.println(message.getMessage(
                lottoRank.getMatchCount(),
                lottoRank.getWinningMoney(),
                count)
        );
    }

    private static LottoMessage getLottoRankMessage(boolean matchBonus) {
        if (matchBonus) {
            return LottoMessage.WINNING_STATISTICS_BONUS_MESSAGE;
        }

        return LottoMessage.WINNING_STATISTICS_MESSAGE;
    }
}
