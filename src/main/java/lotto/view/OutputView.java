package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class OutputView {
    private final OutputMessageResolver outputMessageResolver;

    public OutputView(OutputMessageResolver outputMessageResolver) {
        this.outputMessageResolver = outputMessageResolver;
    }

    public void showPurchasedLottosInformation(List<Lotto> lottos) {
        System.out.println(outputMessageResolver.resolvePurchasedInformationMessage(lottos));
    }

    public void showResults(LottoResult result) {
        System.out.println(outputMessageResolver.resolveResultMessage(result));
    }

    public void showProfitRate(double profitRate) {
        System.out.println(outputMessageResolver.resolveProfitRateMessage(profitRate));
    }
}
