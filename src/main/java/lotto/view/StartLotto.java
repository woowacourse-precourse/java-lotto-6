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
        try {
            System.out.println(LottoString.beforePurchaseLotto());
            inputMoney();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            initLotto();
        }
    }

    private void inputMoney() {
        this.money = Long.parseLong(readLine());
        System.out.println();
        this.countOfLotto = this.money / 1000;


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
            result.replace(result.length()-2, result.length()-1, "]");
            System.out.println(result);
        }
    }

    private void inputWinningNumber() {
        try {
            System.out.println(LottoString.winningNumbers());
            convertNumbers(readLine());
            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
            inputWinningNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputWinningNumber();
        }

    }

    private void convertNumbers(String s) {
        String[] temp = s.split(",");
        if (temp.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개 숫자를 ','로 구분하여 입력해 주세요.");
        }
        for (String tmp : temp) {
            this.winningNumbers.add(Integer.parseInt(tmp));
        }
    }

    private void inputBonusNumber() {
        try {
            System.out.println(LottoString.bonusNumber());
            this.bonusNumber = Integer.parseInt(readLine());
            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 한 개를 입력해 주세요.");
            inputBonusNumber();
        }

    }

    private void printResult() {
        System.out.println(LottoString.announceresult());
        controlLotto.checkResult(winningNumbers, bonusNumber);
        controlLotto.printResult(this.money);
    }
}
