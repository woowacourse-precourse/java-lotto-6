package lotto.util;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;

public class StringUtil {
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
        return String.format("\n%d를 구매했습니다.\n", purchasedLotto.getLottos().size());
    }

    private String formatLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        StringBuilder sb = new StringBuilder("[");
        for (Integer number : numbers) {
            sb.append(number).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2); // 마지막 쉼표 삭제
        sb.append("]").append(" \n");
        return sb.toString();
    }
}






