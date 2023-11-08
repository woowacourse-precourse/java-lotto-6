package lotto.view.output;

import java.util.Collections;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoRank;
import lotto.model.dto.LottoResult;
import lotto.model.dto.LottoWallet;
import lotto.model.dto.PurchaseMoney;

public class OutputView {

    private static final String OUTPUT_SEPARATOR = ", ";
    private static final String LOTTO_BRACKET_OPEN = "[";
    private static final String LOTTO_BRACKET_CLOSE = "]";
    private static final String PRINT_LOTTO_NUMBER = "%n%d개를 구매했습니다.%n";
    private static final String PRINT_TOTAL_RESULT = "%n당첨 통계%n---%n";
    private static final String LOTTO_RESULT_FORMAT_NO_BONUS = "%d개 일치 (%s원) - %d개%n";
    private static final String LOTTO_RESULT_FORMAT_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";
    private static final String LOTTO_EARNING_RATE_FORMAT = "총 수익률은 %s%%입니다.";
    private static final String DECIMAL_COMMA_FORMAT = "%,d";
    private static final String DOUBLE_COMMA_ROUND_FORMAT = "%,.1f";


    public void printLottos(LottoWallet lottoWallet) {
        List<Lotto> lottos = lottoWallet.getLottos();
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

    public void printLottoRanks(LottoResult lottoResult) {
        System.out.printf(PRINT_TOTAL_RESULT);
        List<LottoRank> lottoRanks = lottoResult.getLottoRanks();

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NO_LUCK) {
                printRank(lottoRanks, rank);
            }
        }
    }

    private void printRank(List<LottoRank> lottoRanks, LottoRank rank) {

        if (rank == LottoRank.SECOND_PLACE) {
            System.out.printf(LOTTO_RESULT_FORMAT_WITH_BONUS,
                    rank.getCorrectCount(),
                    String.format(DECIMAL_COMMA_FORMAT, rank.getReward()),
                    Collections.frequency(lottoRanks, rank));
            return;
        }

        System.out.printf(LOTTO_RESULT_FORMAT_NO_BONUS,
                rank.getCorrectCount(),
                String.format(DECIMAL_COMMA_FORMAT, rank.getReward()),
                Collections.frequency(lottoRanks, rank));
    }

    public void printEarningRate(LottoResult lottoResult, PurchaseMoney purchaseMoney) {
        System.out.printf(LOTTO_EARNING_RATE_FORMAT,
                formatEarningRate(lottoResult.getTotalReward(), purchaseMoney.getValue()));
    }

    private String formatEarningRate(int totalReward, int purchaseMoney) {
        double earningRate = (double) totalReward / purchaseMoney * 100;

        return String.format(DOUBLE_COMMA_ROUND_FORMAT, earningRate);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
