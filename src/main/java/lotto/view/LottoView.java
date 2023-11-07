package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.message.LottoMessage;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.message.LottoMessage.*;

public class LottoView {


    public void printPurchasePrompt() {
        System.out.println(PURCHASE_PRICE.getMessage());
    }

    public void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_COUNT.getMessage());
    }

    public void printLottoNumbers(List<Lotto> lottoBundle) {
        lottoBundle.stream()
                .map(Lotto::getNumbers)
                .map(numbers -> "[" + numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")) + "]")
                .forEach(System.out::println);
    }

    public void printWinningPrompt() {
        System.out.println(WINNING_NUMBER.getMessage());
    }

    public void printBonusPrompt() {
        System.out.println(BONUS_NUMBER.getMessage()));
    }

    public void printWinningResult(LottoResult lottoResult) {
        System.out.println(WINNING_RESULT.getMessage());
        System.out.println("---");
        System.out.println(THREE_MATCH.getMessage() + lottoResult.getThreeMatchCount() + QUANTITY.getMessage());
        System.out.println(FOUR_MATCH.getMessage() + lottoResult.getFourMatchCount() + QUANTITY.getMessage());
        System.out.println(FIVE_MATCH.getMessage()+ lottoResult.getFiveMatchCount() + QUANTITY.getMessage());
        System.out.println(FIVE_MATCH_WITH_BONUS.getMessage() + lottoResult.getFiveMatchWithBonusCount() + QUANTITY.getMessage());
        System.out.println(SIX_MATCH.getMessage() + lottoResult.getSixMatchCount() + QUANTITY.getMessage());
    }

    public void printProfitRate(double profitRate) {
        System.out.println(PROFIT_RATE.getMessage() + profitRate + PERCENT.getMessage());
    }
}
