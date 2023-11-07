package lotto.view;

import static lotto.util.Introduction.BONUS_PRIZE_LIST;
import static lotto.util.Introduction.NOT_BONUS_PRIZE_LIST;
import static lotto.util.Introduction.RATE_OF_RETURN;

import java.text.NumberFormat;
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
                PrizeMoney.getFormattedPrizeMoney(prize), count));
    }

    @Override
    public void printBonusPrize(Integer prize, Integer count) {
        Integer countOfMatchedLottoNumbers = PrizeDetails.getCountOfMatchedLottoNumbers(prize);

        System.out.println(String.format(BONUS_PRIZE_LIST.getIntroduction(), countOfMatchedLottoNumbers,
                PrizeMoney.getFormattedPrizeMoney(prize), count));
    }

    @Override
    public void printRateOfReturn(Double rateOfReturn) {
        String formattedRateOfReturn = formatRateOfReturn(rateOfReturn);

        System.out.println(String.format(RATE_OF_RETURN.getIntroduction(), formattedRateOfReturn));
    }

    private String formatRateOfReturn(Double rateOfReturn) {
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setGroupingUsed(true);

        return percentFormat.format(rateOfReturn / 100.0);
    }
}
