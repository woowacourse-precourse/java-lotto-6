package lotto.game;

import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.util.InputManager;
import lotto.util.PrintManager;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final List<Lotto> lottos = new ArrayList<>();

    public static void play() {
        int money = getMoneyInput();
        List<Integer> winNumbers = getWinNumbersInput();
        int bonusNumber = getBonusNumberInput();

        WinLotto winLotto = new WinLotto(winNumbers, bonusNumber);
        pickLottoNumbers(money);
        calculateResult();
    }

    private static void calculateResult() {
        //TODO 결과 계산
        //TODO 결과 출력
    }

    private static void pickLottoNumbers(int money) {
        //TODO 금액 만큼의 번호 뽑고 로또 생성
    }

    private static int getMoneyInput() {
        PrintManager.printInputMoney();
        return InputManager.getInputMoney();
    }


    private static List<Integer> getWinNumbersInput() {
        PrintManager.printInputWinNumbers();
        return InputManager.getInputWinNumbers();
    }

    private static int getBonusNumberInput() {
        PrintManager.printBonusNumberInput();
        return InputManager.getInputBonusNumber();
    }

}
