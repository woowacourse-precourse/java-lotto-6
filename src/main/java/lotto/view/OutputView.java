package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import lotto.constant.LottoResultStatus;
import lotto.constant.Message;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseLottos;
import lotto.domain.PurchasePrice;

public class OutputView {
    private static final String DELIMITER = "\n";

    public void printPurchaseLottos(PurchaseLottos purchaseLottos) {
        printNewLine();
        System.out.printf(Message.PURCHASE_COUNT.getMessage(), purchaseLottos.getPurchaseCount());
        System.out.println(createSortedPurchaseLottos(purchaseLottos));
    }

    public void printLottoResult(LottoResult lottoResult) {
        printNewLine();
        System.out.println(Message.WINNING_STATISTICS.getMessage());
        System.out.println(Message.SEPARATE_LINE.getMessage());

        String result = createResult(lottoResult);
        System.out.println(result);
    }

    public void printRateOfReturn(LottoResult lottoResult, PurchasePrice purchasePrice) {
        String roundRateOfReturn = lottoResult.roundRateOfReturn(purchasePrice);
        System.out.printf(Message.TOTAL_RATE_OF_RETURN.getMessage(), roundRateOfReturn);
    }

    private String createSortedPurchaseLottos(PurchaseLottos purchaseLottos) {
        List<Lotto> lottos = purchaseLottos.getPurchaseLottos();
        StringJoiner result = new StringJoiner(DELIMITER);
        lottos.forEach(lotto -> result.add(lotto.getSortedNumbers()));

        return result.toString();
    }

    private void printNewLine() {
        System.out.println();
    }

    private int getMatchLottoCount(LottoResult lottoResult, LottoResultStatus resultStatus) {
        return lottoResult.get(resultStatus);
    }

    private String createResult(LottoResult lottoResult) {
        StringJoiner result = new StringJoiner(DELIMITER);

        Arrays.stream(LottoResultStatus.values())
                .filter(resultStatus -> !resultStatus.equals(LottoResultStatus.NOTHING))
                .forEach(resultStatus -> {
                    int matchLottoCount = getMatchLottoCount(lottoResult, resultStatus);
                    String description = resultStatus.getDescription();
                    result.add(description + matchLottoCount + Message.COUNT.getMessage());
                });

        return result.toString();
    }
}
