package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class View {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.\n";
    private static final String ASK_WINNING_NUMBER = "당첨 번호를 입력해 주세요.\n";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.\n";
    private static final String PRINT_PURCHASE_AMOUNT = "%d개를 구매했습니다.\n";
    private static final String PRINT_PURCHASE_NUMBER = "[%s]\n";
    private static final String PRINT_WINNING_STAT = "당첨 통계\n---\n";
    private static final String PRINT_MATCHES = "%d개 일치 (%s원) - %d개\n";
    private static final String PRINT_BONUS_MATCHES = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String PRINT_YIELD_RATE = "총 수익률은 %.1f입니다.\n";
    private static final String PRINT_SEPARATOR = ", ";

    public String getAskPurchaseAmount() {
        return ASK_PURCHASE_AMOUNT;
    }

    public String getAskWinningNumber() {
        return ASK_WINNING_NUMBER;
    }

    public String getAskBonusNumber() {
        return ASK_BONUS_NUMBER;
    }

    public String getPrintPurchaseAmount(int purchaseAmount) {
        return String.format(PRINT_PURCHASE_AMOUNT, purchaseAmount);
    }

    public String getPrintPurchaseNumber(Lotto lotto) {
        List<String> getLottoNumber = lotto.getLottoNumber().stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        String lottoNumber = String.join(PRINT_SEPARATOR, getLottoNumber);

        return String.format(PRINT_PURCHASE_NUMBER, lottoNumber);
    }

    public String getPrintWinningStat() {
        return PRINT_WINNING_STAT;
    }

    public String getPrintMatches(Rank rank) {
        DecimalFormat df = new DecimalFormat("#,###");
        String matchResult = String.format(PRINT_MATCHES, rank.getHits(), df.format(rank.getPrize()), rank.getMatchCount());
        if (rank == Rank.SECOND) {
            matchResult = String.format(PRINT_BONUS_MATCHES, rank.getHits(), df.format(rank.getPrize()), rank.getMatchCount());
        }
        return matchResult;
    }

    public String getPrintYieldRate(double yieldRate) {
        return String.format(PRINT_YIELD_RATE, yieldRate);
    }

}