package lotto.util;

import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchasedLotto;

public class StringUtil {
    private static final String RANK_COUNT_FORMAT = "%s%d개%n";
    private static final String TOTAL_PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.%n";
    public String formatLottoList(PurchasedLotto purchasedLotto) {
        StringBuilder sb = new StringBuilder();
        sb.append(getPurchasedLottoCountString(purchasedLotto));
        List<Lotto> lottos = purchasedLotto.getLottos();
        for (Lotto lotto : lottos) {
            sb.append(formatLotto(lotto));
        }
        return sb.toString();
    }

    private String getPurchasedLottoCountString(PurchasedLotto purchasedLotto) {
        return String.format("%n%d개를 구매했습니다.%n", purchasedLotto.getLottos().size());
    }

    private String formatLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        StringBuilder sb = new StringBuilder("[");
        for (Integer number : numbers) {
            sb.append(number).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]").append("\n");
        return sb.toString();
    }

    public String formatResult(Customer customer, List<LottoResult> results) {
        StringBuilder sb = new StringBuilder();
        for (LottoResult option : LottoResult.getValidLottoResults()) {
            int count = (int) option.calculateTotalCount(results);
            sb.append(String.format(RANK_COUNT_FORMAT, option.getMessage(), count));
        }
        sb.append(String.format(TOTAL_PROFIT_RATE_FORMAT, getProfitRate(customer, results)));
        return sb.toString();
    }

    public double getProfitRate(Customer customer, List<LottoResult> results) {
        long profit = LottoResult.calculateTotalPrize(results);
        int paymentAmount = customer.getPaymentAmount();
        return (double) (profit * 100) / paymentAmount;
    }
}






