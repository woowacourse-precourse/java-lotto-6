package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Prize {
    private String groupNumbers;
    private List<Integer> preLuckyNumber;
    public Lotto luckyNumber;

    void inputNumbers() {
        groupNumbers = Console.readLine();
    }

    void cutNumbers() {
        String[] separatedNumbers = groupNumbers.split(",");

        for (int i = 0; i < separatedNumbers.length; i++) {
            preLuckyNumber.add(Integer.parseInt(separatedNumbers[i]));
        }

        luckyNumber = new Lotto(preLuckyNumber);
    }
}
