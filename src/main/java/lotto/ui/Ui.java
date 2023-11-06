package lotto.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class Ui {

    public static final String PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String BUY_CONFIRM_MESSAGE = "%s개를 구매했습니다.";

    public void printPrice() {
        System.out.println(PRICE_INPUT_MESSAGE);
    }

    public void printLotto(List<Lotto> lottos) {
        System.out.println(String.format(BUY_CONFIRM_MESSAGE, lottos.size()));
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = deepCopy(lotto.getNumbers());
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }

    private <T> List<T> deepCopy(List<T> original) {
        List<T> copy = new ArrayList<>();
        for (T element : original) {
            copy.add(element);
        }
        return copy;
    }
}
