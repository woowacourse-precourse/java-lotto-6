package lotto.view;

import lotto.model.domain.Lotto;

import java.util.List;

public class OutputView {

    public void printLottoAmount(int num) {
        System.out.printf("%d개를 구매했습니다.%n", num);
    }

    public void printLottoNumbers(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }
}
