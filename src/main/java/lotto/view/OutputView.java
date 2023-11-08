package lotto.view;

import lotto.constant.OutputText;
import lotto.constant.Rank;
import lotto.domain.Lotto;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    public void showLottoCount(int count) {
        System.out.println(count + OutputText.LOTTO_COUNT.getValue());
    }

    public void showLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    private String addComma(int number) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(number);
    }

    private String formatStatistics(Rank rank, int count){
        return String.format(
                OutputText.WINNING_STATISTICS_FORMAT.getValue(),
                rank.getStandard(),
                addComma(rank.getMoney()),
                count);
    }

    public void showWinningStatistics(HashMap<Rank, Integer> winningStatistics) {
        System.out.println(OutputText.WINNING_STATISTICS.getValue());
        System.out.println(OutputText.DIVISION_LINE.getValue());

        for (Rank rank: Rank.values()) {
            if (!rank.equals(Rank.NO_PLACE)){
                int lottoCount = winningStatistics.get(rank);
                System.out.println(formatStatistics(rank, lottoCount));
            }
        }
    }

    public void showRateOfReturn(String rate) {
        String result = String.format(OutputText.RATE_OF_RETURN_FORMAT.getValue(), rate);
        System.out.println(result);
    }
}
