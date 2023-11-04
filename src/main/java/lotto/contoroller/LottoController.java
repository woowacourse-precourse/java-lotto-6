package lotto.contoroller;

import lotto.domain.Purchase;
import lotto.service.LottoNumberGenerator;
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
    }

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
            System.out.println(numberGenerator.numbers);
        }
    }
}
