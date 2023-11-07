package lotto;

import lotto.constant.Rank;
import lotto.constant.ViewMessage;
import lotto.model.Lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class View {

    public void print(String message) {
        System.out.print(message);
    }

    public void printLine() {
        System.out.println();
    }

    public String getPrintPurchaseAmount(int purchaseAmount) {
        return String.format(ViewMessage.PRINT_PURCHASE_AMOUNT.getMessage(), purchaseAmount);
    }

    public String getPrintPurchaseNumber(Lotto lotto) {
        List<String> getLottoNumber = lotto.getLottoNumber().stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        String lottoNumber = String.join(ViewMessage.PRINT_SEPARATOR.getMessage(), getLottoNumber);
        return String.format(ViewMessage.PRINT_PURCHASE_NUMBER.getMessage(), lottoNumber);
    }

    public String getPrintMatches(Rank rank) {
        DecimalFormat df = new DecimalFormat("#,###");
        String printMatches;

        printMatches = ViewMessage.PRINT_MATCHES.getMessage();
        if (rank == Rank.SECOND) {
            printMatches = ViewMessage.PRINT_BONUS_MATCHES.getMessage();
        }
        return String.format(printMatches, rank.getHits(), df.format(rank.getPrize()), rank.getMatchCount());
    }

    public String getPrintYieldRate(double yieldRate) {
        return String.format(ViewMessage.PRINT_YIELD_RATE.getMessage(), yieldRate);
    }
}