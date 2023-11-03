package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int paperCount;
        LottoMachine lottoMachine = new LottoMachine();
        int amount = lottoMachine.purchaseLotto();
        WinningNumbers winningNumbers = new WinningNumbers();

        while (true) {
            if (lottoMachine.calculateAmount(amount) != -1) {
                paperCount = lottoMachine.calculateAmount(amount);
                break;
            }
            amount = lottoMachine.purchaseLotto();
        }

        OutputView.purchaseCount(paperCount);

        List<Lotto> lottoList = lottoMachine.buyLotto(paperCount);
        for (Lotto lotto : lottoList) {
            lotto.printLottoNumbers();
        }
        System.out.println();

        List<Integer> winningNumber = winningNumbers.createWinningNumber();
        System.out.println("winningNumber.toString() = " + winningNumber.toString());

        System.out.println();

        List<Integer> bonusNumber = winningNumbers.createBonusNumber();
        System.out.println("bonusNumber.toString() = " + bonusNumber.toString());



    }
}
