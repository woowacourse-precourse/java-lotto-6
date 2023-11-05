package lotto.contoroller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.service.LottoBonusComparer;
import lotto.service.LottoNumberPrinter;
import lotto.utility.ListTypeChanger;
import lotto.utility.LottoErrorMessage;
import lotto.utility.NumberTypeChanger;
import lotto.view.InputValue;
import lotto.view.OutputMessage;

public class LottoController {
    private List<Integer> winningNumbers;

    public void startLotto() {
        int purchaseAmount = getInputPurchase();
        // 여기는 purchaseAmount를 인자로 하는 메소드 만들어버리기
        System.out.printf("%n%d%s%n", purchaseAmount / 1000, OutputMessage.PURCHASE.getMessage());
        LottoNumberPrinter.generateAndPrintLottoNumbers(purchaseAmount); // 비교를 위해서 어딘가에 담아두는 식으로 리팩토링 필요할듯
        // 요기까지
        List<Integer> winningNumbers = getInputLotto();
        int bonusNumber = getInputBonus();
        validateDuplicate(winningNumbers, bonusNumber);
        // 여기까지가 유효성 검증, 이제 통계내야 함
    }

    // 구입 금액 입력
    private int getInputPurchase() {
        while (true) {
            try {
                String input = InputValue.inputPurchase();
                int purchaseAmount = NumberTypeChanger.changeNumberType(input);
                Purchase purchase = new Purchase(purchaseAmount);
                return purchase.getAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

//    private void generateAndPrintLottoNumbers(int purchaseAmount) {
//        LottoNumberGenerator numberGenerator = new LottoNumberGenerator();
//        int numberOfTickets = purchaseAmount / 1000;
//
//        for (int i = 0; i < numberOfTickets; i++) {
//            System.out.println(numberGenerator.generateNumbers());
//        }
//        System.out.println();
//    }

    // 당첨 번호 입력
    private List<Integer> getInputLotto() {
        while(true) {
            try {
                String input = InputValue.inputWinningNumbers();
                List<Integer> winningNumbers = ListTypeChanger.changeListType(input);
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
                int bonusNumber = NumberTypeChanger.changeNumberType(input);
                Bonus bonus = new Bonus(bonusNumber);
                return bonus.getNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 당첨 번호 입력값들이랑 중복되지 않았는지
    private int validateDuplicate(List<Integer> numbers, int number) {
        while (LottoBonusComparer.compare(numbers, number)) {
            System.out.println(LottoErrorMessage.DUPLICATE_LIST_ERROR.getMessage());
            int input = getInputBonus(); // 재입력 받음
            number = input;
        }
        return number;
    }

}
