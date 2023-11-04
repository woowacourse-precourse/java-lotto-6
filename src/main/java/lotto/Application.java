package lotto;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    static int isMatchedThree = 0;
    static int isMatchedFour = 0;
    static int isMatchedFive = 0;
    static int isMatchedFiveAndBonus = 0;
    static int isMatchedSix = 0;

    public static void main(String[] args) {

        InputView inputView = new InputView();
        int answer = inputView.requestPrice();

        OutputView outputView = new OutputView();
        int boughtLotto = outputView.printPurchases(answer);

        LottoMachine lottoMachine = new LottoMachine(boughtLotto);
        lottoMachine.issueTickets();
        outputView.printIssuedLotto(lottoMachine.getIssuedLotto());

        String winningNumbers = inputView.requestWinningNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers);

        int bonusNumber = inputView.requestBonusNumber();
        Bonus bonus = new Bonus(bonusNumber);

        System.out.println();
        System.out.println("당첨 통계\n---");

        for(Lotto lotto : lottoMachine.getIssuedLotto()) {
            List<Integer> issuedNumbers = lotto.getNumbers();
            boolean isMatchedBonusNumber = false;
            if(issuedNumbers.contains(bonus.getNumber())) {
                isMatchedBonusNumber = true;
            }
            issuedNumbers.retainAll(winningLotto.getNumbers());
            calculateResult(issuedNumbers.size(), isMatchedBonusNumber);
        }

        System.out.printf("3개 일치 (5,000원) - %d개\n", isMatchedThree);
        System.out.printf("4개 일치 (50,000원) - %d개\n", isMatchedFour);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", isMatchedFive);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", isMatchedFiveAndBonus);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", isMatchedSix);

        float revenue = (5000 * isMatchedThree) + (50000 * isMatchedFour)
            + (1500000 * isMatchedFive) + (30000000 * isMatchedFiveAndBonus) + (2000000000 * isMatchedSix);
        float result = (revenue / answer) * 100 ;

        System.out.println();
        System.out.printf("총 수익률은 %.1f%%입니다.", result);
    }

    private static void calculateResult(int size, boolean isMatchedWithBonus) {
        if (size == 3) {
            isMatchedThree++;
        } else if (size == 4) {
            isMatchedFour++;
        } else if (size == 5 && !isMatchedWithBonus) {
            isMatchedFive++;
        } else if (size == 5) {
            isMatchedFiveAndBonus++;
        } else if (size == 6) {
            isMatchedSix++;
        }
    }
}
