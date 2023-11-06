package lotto.module.console;

import lotto.module.domain.lotto.Lotto;
import lotto.module.result.LottoResult;

import java.util.List;

import static lotto.module.store.LottoPrizeTable.*;

public class ConsoleMessageComposer {
    private final static String PURCHASED_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private final static String FIFTH_PLACE_MESSAGE = FIFTH_PLACE.getMatchCount() + "개 일치 (" + FIFTH_PLACE.getPrize() + "원) - ";
    private final static String FOURTH_PLACE_MESSAGE = FOURTH_PLACE.getMatchCount() + "개 일치 (" + FOURTH_PLACE.getPrize() + "원) - ";
    private final static String THIRD_PLACE_MESSAGE = THIRD_PLACE.getMatchCount() + "개 일치 (" + THIRD_PLACE.getPrize() + "원) - ";
    private final static String SECOND_PLACE_MESSAGE = SECOND_PLACE.getMatchCount() + "개 일치, 보너스 볼 일치 (" + SECOND_PLACE.getPrize() + ") - ";
    private final static String FIRST_PLACE_MESSAGE = FIRST_PLACE.getMatchCount() + "개 일치 (" + FIRST_PLACE.getPrize() + "원) - ";

    private ConsoleMessageComposer() {
    }

    public static ConsoleMessageComposer newInstance() {
        return new ConsoleMessageComposer();
    }

    public String makePurchasedLottoTicketMessage(List<Lotto> list) {
        StringBuilder message = new StringBuilder(System.lineSeparator())
                .append(list.size())
                .append(PURCHASED_LOTTO_COUNT_MESSAGE)
                .append(System.lineSeparator());

        for (Lotto lotto : list) {
            message.append(lotto.getNumbers())
                    .append(System.lineSeparator());
        }

        return message.toString();
    }

    public String makeLottoResult(LottoResult lottoResult) {
        int firstPlaceCount = lottoResult.getRankCount(1);
        int secondPlaceCount = lottoResult.getRankCount(2);
        int thirdPlaceCount = lottoResult.getRankCount(3);
        int fourthPlaceCount = lottoResult.getRankCount(4);
        int fifthPlaceCount = lottoResult.getRankCount(5);

        StringBuilder message = new StringBuilder();
        message.append(fifthPlaceCount)
                .append(FIFTH_PLACE_MESSAGE)
                .append(fourthPlaceCount)
                .append(FOURTH_PLACE_MESSAGE)
                .append(thirdPlaceCount)
                .append(THIRD_PLACE_MESSAGE)
                .append(secondPlaceCount)
                .append(SECOND_PLACE_MESSAGE)
                .append(firstPlaceCount)
                .append(FIRST_PLACE_MESSAGE);

        return message.toString();
    }

}
