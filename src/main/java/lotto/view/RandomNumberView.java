package lotto.view;

import java.util.List;

public class RandomNumberView {

    public void printRandomNumber(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printAllRandomNumbers(List<List<Integer>> allRandomNumbers) {
        for (List<Integer> randomNumbers : allRandomNumbers) {
            printRandomNumber(randomNumbers);
        }
        OutputView.printSpace();
    }


}
