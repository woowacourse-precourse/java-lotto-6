package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class OutputView {
    private final MessageResolver messageResolver;

    public OutputView(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public void showPurchasedLottosInformation(List<Lotto> lottos) {
        System.out.println(messageResolver.resolvePurchasedInformationMessage(lottos));
    }

    public void showResults(LottoResult result) {
        System.out.println(messageResolver.resolveResultMessage(result));
    }

    public void showProfitRate(double profitRate) {
        System.out.println(messageResolver.resolveProfitRateMessage(profitRate));
    }
}
