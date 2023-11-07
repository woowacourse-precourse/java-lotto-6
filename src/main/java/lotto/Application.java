package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    static InputView inputView = InputView.getInstance();
    static OutputView outputView = OutputView.getInstance();
    static Validator validator = Validator.getInstance();
    static Committee committee = Committee.getInstance();

    public static void main(String[] args) {

        int price = setPrice();

        int count = price / 1000;

        List<Integer>[] issueNumbers = setIssueNumbers(count);
        outputView.printWinningNum(issueNumbers, count);


    }

    private static List<Integer>[] setIssueNumbers(int count) {
        List<Integer>[] issueNumbers = new ArrayList[count];
        for (int i = 0; i < count; i++) {
            List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
