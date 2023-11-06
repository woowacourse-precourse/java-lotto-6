package lotto;

import lotto.domain.Lotto;
import lotto.domain.MyLotto;
import lotto.domain.WinningLotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputService inputService = new InputService();

        int quantity = inputService.payMoney();

        MyLotto myLotto = new MyLotto(quantity);
        myLotto.printGenerateLottoResult();

        Lotto winningLottoWithoutBonus = inputService.winningNumbers();
    }
}
