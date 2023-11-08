package lotto.view;

import java.util.List;
import lotto.domain.Customer;
import lotto.domain.LottoResult;
import lotto.domain.PurchasedLotto;
import lotto.util.StringUtil;

public class OutputView {
    private final StringUtil stringUtil;
    private static final String WINNING_STATICS_TITLE = "\n당첨통계";
    private static final String DIVIDER = "---";

    public OutputView(StringUtil stringUtil) {
        this.stringUtil = stringUtil;
    }

    public void printPurchasedLotto(PurchasedLotto purchasedLotto) {
        String output = stringUtil.formatLottoList(purchasedLotto);
        System.out.print(output);
    }

    public void printResult(Customer customer, List<LottoResult> results) {
        System.out.println(WINNING_STATICS_TITLE);
        System.out.println(DIVIDER);
        System.out.println(stringUtil.formatResult(customer, results));
    }

}
