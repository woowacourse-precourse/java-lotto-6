package lotto.contoroller;

import java.util.List;
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
        generateAndPrintLottoNumbers(purchaseAmount);
        // 요기까지
        getInputLotto();
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
                return lotto.getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
