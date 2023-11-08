package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Match;

public class OutputView {

    private static final String PURCHASED_LOTTO_MESSAGE = "%d개를 구매했습니다.";

    private static final String THREE_MATCHED_MESSAGE = "3개 일치 (5,000원) - %d개";
    private static final String FOUR_MATCHED_MESSAGE = "4개 일치 (50,000원) - %d개";
    private static final String FIVE_MATCHED_AND_NOT_BONUS_MESSAGE = "5개 일치 (1,500,000원) - %d개";
    private static final String FIVE_MATCHED_AND_BONUS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String SIX_MATCHED_MESSAGE = "6개 일치 (2,000,000,000원) - %d개";

    private static final int THREE_NUMBERS_MATCHED = 3;

    private static final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";


    public void printPurchasedLotto(List<Lotto> userPurchasedLotto) {

        System.out.println(PURCHASED_LOTTO_MESSAGE.formatted(userPurchasedLotto.size()));

        userPurchasedLotto
                .forEach(Lotto::printLottoDetail);

    }

    public void printMatchResult(Match matchResult) {

        List<String> messages = List.of(
                THREE_MATCHED_MESSAGE,
                FOUR_MATCHED_MESSAGE,
                FIVE_MATCHED_AND_NOT_BONUS_MESSAGE,
                FIVE_MATCHED_AND_BONUS_MESSAGE,
                SIX_MATCHED_MESSAGE
        );

        for (int index = 0; index < messages.size(); index++) {

            System.out.println(
                    messages.get(index).formatted(matchResult.getSingleMatchCount(index + THREE_NUMBERS_MATCHED)));

        }

    }

    public void printProfit(double profit) {

        System.out.println(PROFIT_MESSAGE.formatted(profit));


    }
}
