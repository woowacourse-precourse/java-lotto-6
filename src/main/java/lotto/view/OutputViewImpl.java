package lotto.view;

import static lotto.util.Introduction.BONUS_PRIZE_LIST;
import static lotto.util.Introduction.NOT_BONUS_PRIZE_LIST;

import java.util.List;
import lotto.Lotto;
import lotto.util.PrizeDetails;
import lotto.util.PrizeMoney;

public class OutputViewImpl implements OutputView {

    @Override
    public void printIntroduction(String introduction) {
        System.out.println(introduction);
    }

    @Override
    public void printNotBonusPrize(Integer prize, Integer count) {
        Integer countOfMatchedLottoNumbers = PrizeDetails.getCountOfMatchedLottoNumbers(prize);

        System.out.println(String.format(NOT_BONUS_PRIZE_LIST.getIntroduction(), countOfMatchedLottoNumbers,
                PrizeMoney.getPrizeMoney(prize), count));
    }

    @Override
    public void printBonusPrize(Integer prize, Integer count) {
        Integer countOfMatchedLottoNumbers = PrizeDetails.getCountOfMatchedLottoNumbers(prize);

        System.out.println(String.format(BONUS_PRIZE_LIST.getIntroduction(), countOfMatchedLottoNumbers,
                PrizeMoney.getPrizeMoney(prize), count));
    }
}
