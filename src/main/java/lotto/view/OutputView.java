package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public void displayLotto(List<Lotto> userLottoList) {
        System.out.println(userLottoList.size() + "개를 구매했습니다.");
        for (Lotto userLotto : userLottoList) {
            System.out.println(userLotto.getNumbers());
        }
        System.out.println();
    }
}