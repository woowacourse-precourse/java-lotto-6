package lotto.views;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static final String PURCHASE_LOTTO_OUTPUT = "개를 구매했습니다.";

    public void lottoQuantityAndNumber(List<Lotto> publishedLotto) {
        System.out.println(publishedLotto.size()+PURCHASE_LOTTO_OUTPUT);
        for (Lotto lotto : publishedLotto) {
            List<Integer> sortedNumbers = lotto.getSortedNumbers();
            StringBuilder stringBuilder = new StringBuilder("[");
            for (Integer number : sortedNumbers) {
                stringBuilder.append(number);
                stringBuilder.append(", ");
            }
            int length = stringBuilder.length();
            stringBuilder.delete(length-2,length);
            stringBuilder.append("]");
            System.out.println(stringBuilder.toString());
        }
    }
}
