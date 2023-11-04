package lotto.contoroller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.service.LottoNumberGenerator;
import lotto.utility.ChangeListType;
import lotto.utility.ChangeNumberType;
import lotto.view.InputValue;
import lotto.view.OutputMessage;

public class LottoController {

    public void startLotto() {
        int purchaseAmount = getInputPurchase();
        // 여기는 purchaseAmount를 인자로 하는 메소드 만들어버리기
        System.out.printf("%n%d%s%n", purchaseAmount / 1000, OutputMessage.PURCHASE.getMessage());
        generateAndPrintLottoNumbers(purchaseAmount); // 비교를 위해서 어딘가에 담아두는 식으로 리팩토링 필요할듯
        // 요기까지
        List<Integer> winningNumbers = getInputLotto();
        int bonusNumber = getInputBonus();
    }

    // 구입 금액 입력
    private int getInputPurchase() {
        while (true) {
            try {
                String input = InputValue.inputPurchase();
                int purchaseAmount = ChangeNumberType.changeNumberType(input);
                Purchase purchase = new Purchase(purchaseAmount);
                return purchase.getAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void generateAndPrintLottoNumbers(int purchaseAmount) {
        LottoNumberGenerator numberGenerator = new LottoNumberGenerator();
        int numberOfTickets = purchaseAmount / 1000;

        for (int i = 0; i < numberOfTickets; i++) {
            System.out.println(numberGenerator.generateNumbers());
        }
        System.out.println();
    }

    // 당첨 번호 입력
    private List<Integer> getInputLotto() {
        while(true) {
            try {
                String input = InputValue.inputWinningNumbers();
                List<Integer> winningNumbers = ChangeListType.changeListType(input);
                Lotto lotto = new Lotto(winningNumbers);
                System.out.println();
                return lotto.getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 보너스 번호 입력
    private int getInputBonus() {
        while(true) {
            try {
                String input = InputValue.inputBonusNumber();
                int bonusNumber = ChangeNumberType.changeNumberType(input);
                Bonus bonus = new Bonus(bonusNumber);
                System.out.println();
                return bonus.getNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
