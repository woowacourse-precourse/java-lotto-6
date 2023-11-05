package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Objects;

public class OutputView {
    public void printPurchasedLottos(List<Lotto> lottos) {
        printPurchasedLottosQuantity(lottos);
        for (Lotto lotto : lottos) {
            printLottoNumber(lotto);
        }
    }

    private void printPurchasedLottosQuantity(List<Lotto> lottos) {
        if (Objects.isNull(lottos)) {
            return;
        }
        int quantity = lottos.size();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    private void printLottoNumber(Lotto lotto) {
        if (Objects.isNull(lotto)) {
            return;
        }
        List<Integer> numbers = lotto.getNumbers();
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            sb.append(", ");
            sb.append(numbers.get(i));
        }
        sb.append("]");
        System.out.println(sb);
    }
}
