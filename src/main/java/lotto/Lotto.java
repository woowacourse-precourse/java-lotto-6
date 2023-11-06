package lotto;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.OrderEnum.CorrespondType;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현


    public void calLottoResult(List<List<Integer>> lottoNumbers, int bonus) {
        System.out.println("당첨 통계");
        System.out.println("---");
        ArrayList<Integer> lottoResult = matchNumbers(lottoNumbers, bonus);
        printResult(lottoResult);
    }

    private ArrayList<Integer> matchNumbers(List<List<Integer>> lottoNumbers, int bonus) {
        ArrayList<Integer> lottoResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
        for (List<Integer> lottoNumber : lottoNumbers) {
            int matchNum = matchNumber(lottoNumber);
            CorrespondType result = matchResult(matchNum, bonus);
            lottoResult.set(result.ordinal(), lottoResult.get(result.ordinal()) + 1);
        }
        return lottoResult;
    }

    private int matchNumber(List<Integer> lottoNumber) {
        int matchNum = 0;
        for (Integer num : lottoNumber) {
            if (numbers.contains(num)) {
                matchNum += 1;
            }
        }
        return matchNum;
    }

    private CorrespondType matchResult(int matchNum, int bonus) {
        if (matchNum == 6) {
            return CorrespondType.FIRST;
        }

        if (matchNum == 5 && numbers.contains(bonus)) {
            return CorrespondType.SECOND;
        }

        if (matchNum == 5) {
            return CorrespondType.THIRD;
        }

        if (matchNum == 4) {
            return CorrespondType.FOURTH;
        }

        if (matchNum == 3) {
            return CorrespondType.FIFTH;
        }

        return CorrespondType.ZERO;
    }


    private void printResult (ArrayList<Integer> lottoResult){

    }
}
