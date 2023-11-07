package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.stream.Collectors;

public class LottoView {
    private static final String PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT = "개를 구매했습니다.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_RESULT = "당첨 통계";
    private static final String THREE_MATCH = "3개 일치 (5000원) - ";
    private static final String FOUR_MATCH = "4개 일치 (50000원) - ";
    private static final String FIVE_MATCH = "5개 일치 (1500000원) - ";
    private static final String FIVE_MATCH_WITH_BONUS = "5개 일치, 보너스 볼 일치 (30000000원) - ";
    private static final String SIX_MATCH = "6개 일치 (2000000000원) - ";
    private static final String QUANTITY = "개";
    private static final String PROFIT_RATE = "총 수익률은 ";
    private static final String PERCENT = "%입니다.";

    public static void printPurchasePrompt() {
        System.out.println(PURCHASE_PRICE);
    }

    public static void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_COUNT);
    }

    public static void printLottoNumbers(List<Lotto> lottoBundle) {
        lottoBundle.stream()
                .map(Lotto::getNumbers)
                .map(numbers -> "[" + numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")) + "]")
                .forEach(System.out::println);
    }

    public static void printWinningPrompt() {
        System.out.println(WINNING_NUMBER);
    }

    public static void printBonusPrompt() {
        System.out.println(BONUS_NUMBER);
    }

    public static void printWinningResult(LottoResult lottoResult) {
        System.out.println(WINNING_RESULT);
        System.out.println("---");
        System.out.println(THREE_MATCH + lottoResult.getThreeMatchCount() + QUANTITY);
        System.out.println(FOUR_MATCH + lottoResult.getFourMatchCount() + QUANTITY);
        System.out.println(FIVE_MATCH + lottoResult.getFiveMatchCount() + QUANTITY);
        System.out.println(FIVE_MATCH_WITH_BONUS + lottoResult.getFiveMatchWithBonusCount() + QUANTITY);
        System.out.println(SIX_MATCH + lottoResult.getSixMatchCount() + QUANTITY);
    }

    public static void printProfitRate(double profitRate) {
        System.out.println(PROFIT_RATE + profitRate + PERCENT);
    }
}
