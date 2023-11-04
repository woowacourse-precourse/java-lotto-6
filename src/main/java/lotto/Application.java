package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        int lottoPrice = UserController.inputLottoPrice();
        System.out.println("입력한 로또 금액 = " + lottoPrice);
    }
}
