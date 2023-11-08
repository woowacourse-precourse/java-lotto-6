package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public class OutputView {

    private static final String LOTTO_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String STATISTICS_MESSAGE = "당첨 통계";
    private static final String MATCH_MESSAGE = "%d개 일치 (%,d원) - %d개";
    private static final String MATCH_MESSAGE_FOR_SECOND = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String PROFIT_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final String DIVIDER = "---";

    public static void printLottoPurchaseMoneyMessage() {
        System.out.println(LOTTO_PURCHASE_MONEY_MESSAGE);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos()
            .stream()
            .map(lotto -> lotto.getLottoNumbers())
            .map(lottoNumbers -> lottoNumbers.stream().sorted().toList())
            .forEach(lottoNumbers -> System.out.println(lottoNumbers));

        printEmptyLine();
    }

    public static void printLottoCountMessage(int lottoCount) {
        System.out.println(LOTTO_COUNT_MESSAGE.formatted(lottoCount));
    }

    public static void printWinningLottoMessage() {
        System.out.println(WINNING_LOTTO_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public static void printStatisticsMessage(LottoResult lottoResult) {

        List<Rank> ranks = Arrays.stream(Rank.values())
            .filter(rank -> rank != Rank.MISS)
            .sorted(Collections.reverseOrder())
            .toList();

        System.out.println(STATISTICS_MESSAGE);
        printDivider();
        ranks.forEach(rank -> printRankMessage(rank, lottoResult.getNumberOfRankByMap().get(rank)));
    }

    public static void printDivider() {
        System.out.println(DIVIDER);
    }

    private static void printRankMessage(Rank rank, int count) {
        String message = MATCH_MESSAGE;
        if (rank == Rank.SECOND) {
            message = MATCH_MESSAGE_FOR_SECOND;
        }
        System.out.println(message.formatted(rank.getMatchCount(), rank.getWinningMoney(), count));
    }

    public static void printProfitMessage(String profit) {
        System.out.println(PROFIT_MESSAGE.formatted(profit));
    }
}
