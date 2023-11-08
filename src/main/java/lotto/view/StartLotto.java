package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.Lotto;
import lotto.control.ControlLotto;
import lotto.string.LottoString;

import java.util.ArrayList;

public class StartLotto {
    private long money;
    private long countOfLotto;
    private ControlLotto controlLotto;
    private ArrayList<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public void run() {
        initLotto();

        purchaseLotto();

        inputWinningNumber();

        inputBonusNumber();

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
        System.out.println(LottoString.winningNumbers());
        convertNumbers(readLine());
        System.out.println();
    }

    private void convertNumbers(String s) {
        String[] temp = s.split(",");
        for (String tmp: temp) {
            this.winningNumbers.add(Integer.parseInt(tmp));
        }
    }

    private void inputBonusNumber() {
        System.out.println(LottoString.bonusNumber());
        this.bonusNumber = Integer.parseInt(readLine());
        System.out.println();
    }

    private void printResult() {
        System.out.println(LottoString.announceresult());
        controlLotto.checkResult(winningNumbers, bonusNumber);
        controlLotto.printResult(this.money);
    }
}
