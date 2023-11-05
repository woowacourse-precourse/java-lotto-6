package lotto.contoroller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.service.LottoBonusComparer;
import lotto.service.LottoPurchaseListComparer;
import lotto.service.RateCalculator;
import lotto.view.OutputValue;
import lotto.view.PurchaseListPrinter;
import lotto.utility.ListTypeChanger;
import lotto.utility.NumberTypeChanger;
import lotto.view.InputValue;
import lotto.view.OutputMessage;

public class LottoController {
    private List<List<Integer>> purchaseList;
    private List<Integer> lotto;
    private int bonus;

    public void startLotto() {
        int purchaseAmount = getInputPurchase();
        // 여기는 purchaseAmount를 인자로 하는 메소드 만들어버리기
        System.out.printf("%n%s%n", OutputMessage.PURCHASE.getMessage(purchaseAmount / 1000));
        PurchaseListPrinter.generateAndPrintLottoNumbers(purchaseAmount); // 비교를 위해서 어딘가에 담아두는 식으로 리팩토링 필요할듯
        // 요기까지
        purchaseList = PurchaseListPrinter.getPurchaseList();
        lotto = getInputLotto();
        bonus = getInputBonus();
        // 임시(나중에 메소드화시킬것)
        LottoPurchaseListComparer test = new LottoPurchaseListComparer();
        test.compareBundle(purchaseList, lotto, bonus);
        OutputValue.guidePrize(test.getResultList());
        // 여기까지? 혹은 마지막 통계까지?
        OutputValue.guideRate((RateCalculator.converseRate(purchaseAmount, test.getResultList())));
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
//        int inputNumber;
        while (true) {
            try {
                String input = InputValue.inputBonusNumber();
                int inputNumber = NumberTypeChanger.changeNumberType(input);
                LottoBonusComparer.isValidBonusNumber(lotto, inputNumber);
                Bonus bonus = new Bonus(inputNumber);
                System.out.println();
                return bonus.getNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

//    private void isValidBonusNumber(int inputNumber) {
//        if (LottoBonusComparer.compare(lotto, inputNumber)) {
//            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_LIST_ERROR.getMessage());
//        }
//    }


    // 당첨 번호 입력값들이랑 중복되지 않았는지
//    private int validateDuplicate(List<Integer> numbers, int number) {
//        while (LottoBonusComparer.compare(numbers, number)) {
//            System.out.println(LottoErrorMessage.DUPLICATE_LIST_ERROR.getMessage());
//            int input = getInputBonus(); // 재입력 받음
//            number = input;
//        }
//        return number;
//    }

}
