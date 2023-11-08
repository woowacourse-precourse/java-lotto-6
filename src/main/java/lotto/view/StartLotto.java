package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.Lotto;
import lotto.control.ControlLotto;
import lotto.string.LottoString;

import java.util.ArrayList;

public class StartLotto {
    private long money;
    private long countOfLotto;
    private ControlLotto controlLotto;

    public void run() {
        initLotto();

        purchaseLotto();

        inputWinningNumber();

        printResult();
    }

    private void initLotto() {
        System.out.println(LottoString.beforePurchaseLotto());
        inputMoney();
    }

    private void inputMoney() {
        this.money = Long.parseLong(readLine());
        System.out.println();
        this.countOfLotto = this.money/1000;
    }

    private void purchaseLotto() {
        System.out.println(LottoString.purchaseLotto(this.countOfLotto));
        this.controlLotto = new ControlLotto();
        this.controlLotto.createLottos(this.countOfLotto);
        printlottos(this.controlLotto.getlottos());
        System.out.println();
    }

    private void printlottos(ArrayList<Lotto> lottos) {
        for(Lotto x: lottos) {
            StringBuilder result = new StringBuilder("[");
            for (int y: x.getnumbers()) {
                result.append(y).append(", ");
            }
            result.replace(result.length()-1, result.length(), "]");
            System.out.println(result);
        }
    }

    private void inputWinningNumber() {
    }

    private void printResult() {
    }
}
