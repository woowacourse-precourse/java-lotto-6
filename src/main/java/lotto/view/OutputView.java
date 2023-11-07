package lotto.view;

import java.util.Arrays;
import java.util.StringJoiner;
import lotto.constant.Message;
import lotto.domain.LottoResult;
import lotto.domain.LottoResultStatus;
import lotto.domain.PurchaseLottos;

public class OutputView {
    private static final String DELIMITER = "\n";

    public void printPurchaseLottos(PurchaseLottos purchaseLottos) {
        printNewLine();
        System.out.println(purchaseLottos.getPurchaseCount() + Message.PURCHASE_COUNT.getMessage());
        System.out.println(purchaseLottos.getPurchaseLottos());
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println(Message.WINNING_STATISTICS.getMessage());
        System.out.println(Message.SEPARATE_LINE.getMessage());

        String result = createResult(lottoResult);
        System.out.println(result);
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
