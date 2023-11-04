package lotto.view;

import static lotto.constant.message.OutputMessage.*;

import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import lotto.constant.message.OutputMessage;

public class OutputView {
    public void printPurchaseAmount(int amount) {
        System.out.println(amount+PURCHASE_LOTTO.getMessage());
    }

    public void printPurchaseLotto(List<Integer> lotto) {
        String formattedLotto = listToString(lotto);
        System.out.println(formattedLotto);
    }

    public String listToString(List<Integer> list) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int number : list) {
            joiner.add(Integer.toString(number));
        }
        return joiner.toString();
    }

    public void outputWinningResult(){
        System.out.println(OutputMessage.RESULT_START);
    }

}
