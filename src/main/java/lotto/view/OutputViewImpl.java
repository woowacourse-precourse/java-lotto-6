package lotto.view;

import static lotto.util.Introduction.AMOUNT_OF_LOTTO_PURCHASE;
import static lotto.util.Introduction.BONUS_PRIZE_LIST;
import static lotto.util.Introduction.DELIMITER;
import static lotto.util.Introduction.LOTTO_PRINT_END;
import static lotto.util.Introduction.LOTTO_PRINT_START;
import static lotto.util.Introduction.NOT_BONUS_PRIZE_LIST;
import static lotto.util.Introduction.RATE_OF_RETURN;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.data.Lotto;
import lotto.util.PrizeDetails;
import lotto.util.PrizeMoney;

public class OutputViewImpl implements OutputView {

    @Override
    public void printIntroduction(String introduction) {
        System.out.println(introduction);
    }

    @Override
    public void printResultOfBuy(Integer amountOfLotto) {
        System.out.println(String.format(AMOUNT_OF_LOTTO_PURCHASE.getIntroduction(), amountOfLotto));
    }

    @Override
    public void printLottos(List<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            List<Integer> numbers = purchasedLotto.getNumbers(); // Assuming this method exists

            String formattedLottoNumbers = numbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(DELIMITER.getIntroduction() + " ",
                            LOTTO_PRINT_START.getIntroduction(),
                            LOTTO_PRINT_END.getIntroduction()));

            System.out.println(formattedLottoNumbers);
        }
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
        percentFormat.setMaximumFractionDigits(1);

        return percentFormat.format(rateOfReturn / 100.0);
    }
}
