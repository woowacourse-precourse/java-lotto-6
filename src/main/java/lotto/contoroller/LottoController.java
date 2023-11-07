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

public class LottoController {
    private List<List<Integer>> purchaseList;
    private List<Integer> lotto;
    private int bonus;

    public void startLotto() {
        int purchaseAmount = getInputPurchase();

        OutputValue.guidePurchaseList(purchaseAmount);
        PurchaseListPrinter.generateAndPrintLottoNumbers(purchaseAmount);
        purchaseList = PurchaseListPrinter.getPurchaseList();

        lotto = getInputLotto();
        bonus = getInputBonus();
        LottoPurchaseListComparer comparer = new LottoPurchaseListComparer();
        comparer.compareBundle(purchaseList, lotto, bonus);

        OutputValue.guidePrize(comparer.getResultList());
        OutputValue.guideRate((RateCalculator.converseRate(purchaseAmount, comparer.getResultList())));
    }

    public int getInputPurchase() {
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

    public List<Integer> getInputLotto() {
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

    public int getInputBonus() {
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
}
