package lotto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.OrderPrize.CorrespondType;

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


    public void calLottoResult(List<List<Integer>> lottoNumbers, int bonus, int money) {
        System.out.println("당첨 통계");
        System.out.println("---");
        ArrayList<Integer> lottoResult = matchNumbers(lottoNumbers, bonus);
        printResult(lottoResult);
        System.out.println("총 수익률은 " + calTotalProfit(lottoResult) / money + "입니다.");
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
        System.out.println("3개 일치 (5,000원) - " + lottoResult.get(1) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.get(2) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.get(4) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.get(5) + "개");
    }

    private Long calTotalProfit(ArrayList<Integer> lottoResult){
        List<Integer> prizeMoney = new ArrayList<>(Arrays.asList(0,5000,50000,1500000,30000000,2000000000));
        Long total = 0L;
        for(int i=1; i<lottoResult.size(); i++){
            total += (long) prizeMoney.get(i) * lottoResult.get(i);
        }
        return total;
    }


}
