package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;

import java.util.List;

public class StartView {

    public void inputMoney(){
        LottoController controller = new LottoController();

        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        validate(money);
        int number = money / 1000;

        controller.produce(number);
    }
    private void validate(int money) {
        if (money % 1000 !=0) {
            throw new IllegalArgumentException();
        }
    }
}
