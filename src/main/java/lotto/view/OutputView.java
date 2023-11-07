package lotto.view;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputView {

    private static final String REQUEST_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_QUANTITY_MESSAGE = "개를 구매했습니다.";
    private static final String REQUEST_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DELIMITER = "---";
    private static final String PRIZE_RATIO_MESSAGE = "총 수익률은 %s%%입니다.";

    private final StringBuilder stringBuilder;

    public OutputView(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public void printRequestPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE_MESSAGE);
    }
    
    public void printLottoQuantity(int lottoQuantity) {
        String message = stringBuilder.append(lottoQuantity).append(PURCHASE_LOTTO_QUANTITY_MESSAGE).toString();

        System.out.println(message);
    }

    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printRequestLottoNumbers() {
        System.out.println(REQUEST_LOTTO_NUMBER_MESSAGE);
    }

    public void printRequestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public void printLotteryResult(EnumMap<LottoRank, Integer> lottoResult) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DELIMITER);

        for (Map.Entry<LottoRank, Integer> rank : lottoResult.entrySet()) {
            LottoRank lottoRank = rank.getKey();
            String message = String.format(lottoRank.getMessage(), lottoRank.getMatchCount(), lottoRank.getWinningAmount(), rank.getValue());

            System.out.println(message);
        }
    }

    public void printPrizeRatio(double ratio) {
        String message = String.format(PRIZE_RATIO_MESSAGE, ratio);
        System.out.println(message);
    }
}
