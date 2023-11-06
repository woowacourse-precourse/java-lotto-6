package lotto;

import View.InputView;
import View.OuputView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OuputView outputView = new OuputView();
        inputView.printInputMoneyMessage();
        int money;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        if(money < 0) {
            throw new IllegalArgumentException("[ERROR] 0 이상의 숫자를 입력해 주세요.");
        }
        if(money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위로 입력해 주세요.");
        }

        Lottos lottos = new Lottos();
        lottos.buy(money);
        outputView.printUserLottoNumbers(lottos.getLottos());

    }
}
