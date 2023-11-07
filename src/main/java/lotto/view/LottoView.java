package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoView {
    private static final String PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT = "개를 구매했습니다.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

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
}
