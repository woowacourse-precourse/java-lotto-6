package lotto.domain.lotto.converter;

import static lotto.global.constant.LottoConstant.LOTTO_NUMBER_DELIMITER;
import static lotto.global.constant.LottoConstant.LOTTO_PREFIX;
import static lotto.global.constant.LottoConstant.LOTTO_SUFFIX;

import java.util.List;
import java.util.StringJoiner;
import lotto.domain.GameResult;
import lotto.domain.Rank;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.global.constant.message.LottoMessage;

public class LottoMessageConverter {
    private static StringJoiner joiner;


    public static String convertLottoNumberMessage(List<Lotto> lottos) {
        StringBuilder lottoNumberMessage = new StringBuilder();
        String lottoAmountCheckMessage = String.format(LottoMessage.RANDOM_PURCHASE_RESULT.getText(), lottos.size());
        lottoNumberMessage.append(lottoAmountCheckMessage);

        for (Lotto lotto : lottos) {
            joiner = new StringJoiner(LOTTO_NUMBER_DELIMITER, LOTTO_PREFIX, LOTTO_SUFFIX);
            for (LottoNumber number : lotto.getNumbers()) {
                joiner.add(number.getValue().toString());
            }
            lottoNumberMessage.append(joiner);
        }

        return lottoNumberMessage.toString();
    }

    public static String convertLottoResultMessage(GameResult result, double profitPercentage) {
        StringBuilder resultMessage = new StringBuilder();
        resultMessage.append(LottoMessage.RESULT_STATISTICS.getText());
        for (Rank rank : Rank.values()) {
            String rankResultMessage = String.format(rank.getWinningMessage(), result.getCountOfRank(rank));
            resultMessage.append(rankResultMessage);
        }
        resultMessage.append(String.format(LottoMessage.PROFIT_PERCENTAGE.getText(), profitPercentage));

        return resultMessage.toString();
    }
}
