package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import constant.ErrorMessage;
import constant.ServiceMessage;
import input.Purchase;
import java.util.List;
import output.LottoCounter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Purchase purchase = new Purchase();
        int money = purchase.getMoney();

        LottoCounter.printLottos(money);
    }
}
