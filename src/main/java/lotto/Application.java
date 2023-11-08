package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class Application {
    static InputView inputView = InputView.getInstance();
    static OutputView outputView = OutputView.getInstance();
    static Validator validator = Validator.getInstance();
    static Committee committee = Committee.getInstance();

    public static void main(String[] args) {
        int price = setPrice();
        int count = price / 1000;
        List<Integer>[] issueNumbers = setIssueNumbers(count);
        outputView.printIssueNumbers(issueNumbers, count);
        Lotto lotto = setWinningNumbers();
        int bonusNumber = setBonusNumber(lotto);
        int[] sameNumberCount = committee.calculateResult(issueNumbers, lotto, bonusNumber);
        outputView.printResult(sameNumberCount);
        float rate = committee.calculateRate(sameNumberCount, price);
        outputView.printRate(rate);
    }

    private static int setBonusNumber(Lotto lotto) {
        boolean askAgain = true;
        int bonusNumber = 0;
        while (askAgain) {
            askAgain = false;
            String bonusNumberInput = inputView.inputBonusNumber();
            try {
                bonusNumber = validator.validateBonusNumber(bonusNumberInput, lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                askAgain = true;
            }
        }
        return bonusNumber;
    }

    private static Lotto setWinningNumbers() {
        boolean askAgain = true;
        List<Integer> winningNumbers = new ArrayList<>();
        Lotto lotto = null;
        while (askAgain) {
            askAgain = false;
            String winningNumbersInput = inputView.inputWinningNumbers();
            try {
                winningNumbers = validator.validateWinningNumbers(winningNumbersInput);
                lotto = new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                askAgain = true;
            }
        }
        return lotto;
    }

    private static List<Integer>[] setIssueNumbers(int count) {
        List<Integer> issueNumbers[] = new ArrayList[count];
        for (int i = 0; i < count; i++) {
            List<Integer> list = new ArrayList(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(list);
            issueNumbers[i] = list;
        }
        return issueNumbers;
    }

    static int setPrice() {
        boolean askAgain = true;
        int price = 0;
        while (askAgain) {
            askAgain = false;
            String priceInput = inputView.inputPrice();
            try {
                price = validator.validatePrice(priceInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                askAgain = true;
            }
        }
        return price;
    }
}
