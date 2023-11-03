package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Prize;

import java.util.ArrayList;
import java.util.List;

public class Utility {
    public int parseInt(String input) {
        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다");
        }
    }

    public List<Integer> getRandomNumbers(int length) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, length);
        return numbers;
    }

    public String[] splitInput (String input) {
        String[] splitResult = input.split(",");
        return splitResult;
    }

    public List<Integer> getIntList (String[] inputs) {
        List<Integer> numbers = new ArrayList<>();

        for(String input : inputs) {
            int number = parseInt(input);
            numbers.add(number);
        }

        return numbers;
    }

    public int getProfit(int[][] totalResult) {
        int sum = 0;
        Prize prize = new Prize();
        int[][] prizes = prize.getPrize();

        for(int i = 3; i <= 6 ; i++) {
            sum += totalResult[i][0]*prizes[i][0];
        }
        sum += totalResult[5][1]*prizes[5][1];

        return sum;
    }

//    public double getRate(int payment, int result) {
//
//    }
}
