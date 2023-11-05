package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    public void printLottoCount(int lottoAmount) {
        System.out.printf("%n%d개를 구매했습니다.%n", lottoAmount);
    }

    public void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

}
