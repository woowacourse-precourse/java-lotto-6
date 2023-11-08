package lotto.view;

import static lotto.util.constants.Strings.NEXT_LINE;
import static lotto.view.ViewMessage.BOUGHT_LOTTO;
import static lotto.view.ViewMessage.PROFIT_RATE;
import static lotto.view.ViewMessage.WINNER_RESULT;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.util.constants.Reward;

public class LottoOutputView implements View {
    LottoOutputView() {
    }

    /**
     * 발행된 로또를 출력하는 메서드.
     *
     * @param count 발행된 로또의 개수(Integer)
     * @param lottoList 발행된 로또(PublishedLotto) 객체의 문자열 표현
     */
    public void printPublishedLotto(final Integer count, final String lottoList) {
        System.out.println(BOUGHT_LOTTO.getMessage(count, lottoList));
    }

    public void printWinningResult(final Map<Integer, Integer> rankCount) {
        StringBuilder print = new StringBuilder();
        print.append(WINNER_RESULT.getMessage());
        String result = Arrays.stream(Reward.values())
                .map(reward -> reward.getMessage(rankCount.getOrDefault(reward.getRank(), 0)))
                .collect(Collectors.joining(NEXT_LINE.getString()));
        print.append(result);
        System.out.println(print);
    }

    public void printProfitRate(final Double profitRate) {
        System.out.print(PROFIT_RATE.getMessage(profitRate));
    }
}
