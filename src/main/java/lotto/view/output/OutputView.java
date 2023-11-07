package lotto.view.output;

import lotto.model.domain.Lotto;
import lotto.model.domain.LottoRank;
import lotto.model.dto.LottoResult;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final String OUTPUT_SEPARATOR = ", ";
    private static final String LOTTO_BRACKET_OPEN = "[";
    private static final String LOTTO_BRACKET_CLOSE = "]";
    private static final String PRINT_LOTTO_NUMBER = "%n%d개를 구매했습니다.%n";
    private static final String PRINT_TOTAL_RESULT = "%n당첨 통계%n---%n";
    private static final String LOTTO_RESULT_FORMAT_NO_BONUS = "%d개 일치 (%s원) - %d개%n";
    private static final String LOTTO_RESULT_FORMAT_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";
    private static final String LOTTO_EARNING_RATE_FORMAT = "총 수익률은 %s%%입니다.";

    public void printLottos(List<Lotto> lottos) {
        System.out.printf(PRINT_LOTTO_NUMBER, lottos.size());
        lottos.forEach(this::printLottoNumber);
    }

    private void printLottoNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<String> numberString = numbers.stream()
                .map(String::valueOf)
                .toList();

        String output = LOTTO_BRACKET_OPEN
                + String.join(OUTPUT_SEPARATOR, numberString)
                + LOTTO_BRACKET_CLOSE;

        System.out.println(output);
    }

    public void printLottoResult(LottoResult lottoResult, int money) {
        System.out.printf(PRINT_TOTAL_RESULT);
        List<LottoRank> lottoRanks = lottoResult.getLottoRanks();

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NO_LUCK) {
                printRank(lottoRanks, rank);
            }
        }

        printEarningRate(lottoRanks, money);
    }

    private void printRank(List<LottoRank> lottoRanks, LottoRank rank) {
        NumberFormat numberFormatter = NumberFormat.getInstance();

        if (rank == LottoRank.SECOND_PLACE) {
            System.out.printf(LOTTO_RESULT_FORMAT_WITH_BONUS,
                    rank.getCorrectCount(),
                    numberFormatter.format(rank.getReward()),
                    Collections.frequency(lottoRanks, rank));
            return;
        }

        System.out.printf(LOTTO_RESULT_FORMAT_NO_BONUS,
                rank.getCorrectCount(),
                numberFormatter.format(rank.getReward()),
                Collections.frequency(lottoRanks, rank));
    }

    private void printEarningRate(List<LottoRank> lottoRanks, Integer purchaseMoney) {
        double totalReward = 0;
        for (LottoRank rank : lottoRanks) {
            totalReward += rank.getReward();
        }

        System.out.printf(LOTTO_EARNING_RATE_FORMAT,
                calculateEarningRateAndFormat(purchaseMoney, totalReward));
    }

    public String calculateEarningRateAndFormat(Integer purchaseMoney, double totalReward) {
        DecimalFormat decimalFormatter = new DecimalFormat("#,###.0");
        decimalFormatter.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormatter.setMaximumFractionDigits(1);

        return decimalFormatter.format(totalReward / purchaseMoney * 100);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
