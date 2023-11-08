package lotto.view.output;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class OutputView {
    private static final String PURCHASED_LOTTO_SIZE_MESSAGE_FORMAT = "\n%d개를 구매했습니다.\n";
    private static final String PURCHASED_LOTTO_NUMBERS_MESSAGE_FORMAT = "[%s]\n";
    private static final String LOTTO_NUMBERS_JOINING_DELIMETER = ", ";
    private static final String LOTTO_RESULT_TITLE_MESSAGE = "\n당첨 통계\n---";
    private static final String LOTTO_RANK_MATCH_COUNT_MESSAGE_FORMAT = "%d개 일치";
    private static final String BONUS_NUMBER_MATCHED_MESSAGE = ", 보너스 볼 일치";
    private static final String LOTTO_RANK_PRIZE_MESSAGE_FORMAT = " (%,d원)";
    private static final String LOTTO_RESULT_MATCH_COUNT_MESSAGE_FORMAT = " - %d개\n";
    private static final String PRIZE_RATE_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.\n";
    private static final String EXCEPTION_MESSAGE_FORMAT = "[ERROR] %s\n";

    private OutputView() {
    }

    public static void printPurchasedLottos(Customer customer) {
        List<Lotto> purchasedLottos = customer.purchasedLottos();
        System.out.printf(PURCHASED_LOTTO_SIZE_MESSAGE_FORMAT, purchasedLottos.size());

        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto purchasedLotto : purchasedLottos) {
            buildPurchasedLottoNumbersMessage(purchasedLotto.numbers(), stringBuilder);
        }
        System.out.print(stringBuilder);
        printNewLine();
    }

    private static void buildPurchasedLottoNumbersMessage(List<LottoNumber> lottoNumbers, StringBuilder stringBuilder) {
        String joinedLottoNumbers = lottoNumbers.stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.value()))
                .collect(joining(LOTTO_NUMBERS_JOINING_DELIMETER));

        stringBuilder.append(String.format(PURCHASED_LOTTO_NUMBERS_MESSAGE_FORMAT, joinedLottoNumbers));
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(LOTTO_RESULT_TITLE_MESSAGE);

        StringBuilder stringBuilder = new StringBuilder();
        for (LottoRank lottoRank : printableLottoRanks()) {
            buildLottoResultMessage(lottoRank, lottoResult.count(lottoRank), stringBuilder);
        }
        System.out.print(stringBuilder);
    }

    private static List<LottoRank> printableLottoRanks() {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.NONE)
                .sorted(Comparator.comparingInt(LottoRank::prize))
                .toList();
    }

    private static void buildLottoResultMessage(LottoRank rank, int count, StringBuilder stringBuilder) {
        stringBuilder.append(String.format(LOTTO_RANK_MATCH_COUNT_MESSAGE_FORMAT, rank.matchCount()));
        if (rank.hasBonusNumber()) {
            stringBuilder.append(BONUS_NUMBER_MATCHED_MESSAGE);
        }
        stringBuilder.append(String.format(LOTTO_RANK_PRIZE_MESSAGE_FORMAT, rank.prize()));
        stringBuilder.append(String.format(LOTTO_RESULT_MATCH_COUNT_MESSAGE_FORMAT, count));
    }

    public static void printPrizeRate(LottoResult lottoResult) {
        System.out.printf(PRIZE_RATE_MESSAGE_FORMAT, lottoResult.calculatePrizeRate());
    }

    public static void printException(Exception exception) {
        System.out.printf(EXCEPTION_MESSAGE_FORMAT, exception.getMessage());
    }

    public static void printNewLine() {
        System.out.println();
    }
}
