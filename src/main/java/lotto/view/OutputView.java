package lotto.view;

import lotto.constant.OutputMessage;

import java.util.List;

public class OutputView {
    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printRandomSixNumbers(List<List<Integer>> randomSixNumbers) {
        System.out.println(OutputMessage.OUTPUT_PURCHASE_AMOUNT_MESSAGE.getMessage(randomSixNumbers.size()));
        for(List<Integer> randomSixNumber : randomSixNumbers){
            System.out.println(randomSixNumber);
        }
    }
}
