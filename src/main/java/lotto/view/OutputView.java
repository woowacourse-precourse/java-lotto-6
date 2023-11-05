package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Prize;
import lotto.domain.Prizes;

public class OutputView {
    private static final String LOTTO_AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNIG_DETAILS_MESSAGE = "%d개 일치 (%d원) - %d개";

    public void showLottoAmount(int lottoAmount) {
        System.out.println(String.format(LOTTO_AMOUNT_MESSAGE, lottoAmount));
    }

    public void showLottoNumbers(List<String> lottoNumbers) {
        lottoNumbers.stream().forEach(System.out::println);
    }

    public void showLottoResult(Prizes prizes) {
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.NO_PRIZE)
                .map(prize -> formatString(prize, prizes))
                .forEach(System.out::println);
    }


    public void showProfitRate() {

    }

    public String formatString(Prize prize, Prizes prizes) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        String formattedPrizeMoney = formatter.format(prize.getPrizeMoney());

        return String.format(WINNIG_DETAILS_MESSAGE, prize.getMatchingNumberCount(), formattedPrizeMoney,
                prizes.getPrizeAmount(prize));
    }
}
