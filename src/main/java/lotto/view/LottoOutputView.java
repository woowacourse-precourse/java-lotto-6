package lotto.view;

import java.util.List;
import lotto.constant.PrizeMessage;
import lotto.domain.Lotto;
import lotto.domain.dto.LottoPrizeDto;

public class LottoOutputView {
    private static final String LOTTO_COUNT_PHRASE = "개를 구매했습니다.";
    private static final String COUNT = "개";
    private static final String TOTAL_RATE_OF_RETURN = "총 수익률은 ";
    private static final String SOME_PERCENT = "%입니다.";

    public void printPublishedLottos(int lottoCount, List<Lotto> lottos) {
        System.out.println(lottoCount + LOTTO_COUNT_PHRASE);
        for (Lotto lotto : lottos) {
            lotto.printItself();
        }
    }

    public void printWinningStatistics(LottoPrizeDto lottoPrizeDto) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(PrizeMessage.FIFTH.getMessage()
                + countText(lottoPrizeDto.getFifth()));
        System.out.println(PrizeMessage.FOURTH.getMessage()
                + countText(lottoPrizeDto.getFourth()));
        System.out.println(PrizeMessage.THIRD.getMessage()
                + countText(lottoPrizeDto.getThird()));
        System.out.println(PrizeMessage.SECOND.getMessage()
                + countText(lottoPrizeDto.getSecond()));
        System.out.println(PrizeMessage.FIRST.getMessage()
                + countText(lottoPrizeDto.getFirst()));
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(TOTAL_RATE_OF_RETURN + rateOfReturn + SOME_PERCENT);
    }

    private String countText(int count) {
        return count + COUNT;
    }

}
