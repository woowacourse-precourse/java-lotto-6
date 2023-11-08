package lotto.view.output;

import lotto.domain.lotto.LottoGroup;
import lotto.view.output.writer.Writer;

public class LottoIssueOutputView extends OutputView {
    private static final String STRING_PURCHASED_COUNT_FORMAT = "%d개를 구매했습니다.";

    public LottoIssueOutputView(Writer writer) {
        super(writer);
    }

    public void printPurchasedLottos(final LottoGroup lottoGroup) {
        final int purchasedCount = lottoGroup.size();
        printPurchasedLottoCountMessage(purchasedCount);
        writer.println(lottoGroup.toString());
    }

    private void printPurchasedLottoCountMessage(final int purchasedCount) {
        writer.println(STRING_PURCHASED_COUNT_FORMAT.formatted(purchasedCount));
    }
}
