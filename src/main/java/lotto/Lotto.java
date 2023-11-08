package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public  List<List<Integer>> generateRandomLottoNumbers(int lotteryCount) {
        List<List<Integer>> lottoNumbersList = new ArrayList<>();

        for (int i = 0; i < lotteryCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottoNumbersList.add(numbers);
        }
        return lottoNumbersList;
    }

    public void printLottoNumbers(List<List<Integer>> lottoNumbersList) {
        for (List<Integer> numbers : lottoNumbersList) {
            System.out.println(numbers);
        }
    }

    public void calculateProfitRate(int buy, int[] ranks) {
        double totalCost = buy;
        double totalPrize = ranks[4] * 5000 + ranks[3] * 50000 + ranks[2] * 1500000 + ranks[1] * 30000000 + ranks[0] * 2000000000;

        double profit = totalPrize - totalCost;
        double profitRate = (profit / totalCost) * 100; // 수익률을 백분율로 계산

        System.out.println("총 수익률 "+profitRate+" 입니다.");
    }

    public void printLottoPrize(int[] ranks){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ranks[4]+" 개");
        System.out.println("4개 일치 (50,000원) - "+ranks[3]+" 개");
        System.out.println("5개 일치 (1,500,000원) - "+ranks[2]+" 개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ranks[1]+" 개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ranks[0]+" 개");
    }

    public int[] calculateLottoPrize(int[] counts, int[] bonusCounts){
        int[] ranks = {0, 0, 0, 0, 0};
        for(int i=0; i<counts.length; i++){
            for(int j=0; j<bonusCounts.length; j++){
                if(counts[i] ==3){
                    ranks[4]++;
                }
                if(counts[i] ==4){
                    ranks[3]++;
                }
                if(counts[i] ==5){
                    ranks[2]++;
                }
                if(counts[i] ==5&&bonusCounts[j]==1){
                    ranks[1]++;
                }
                if(counts[i] ==6){
                    ranks[0]++;
                }
            }
        }
        return ranks;
    }
    public int[][] countMatchingNumbers(List<List<Integer>> lottoNumbersList, List<Integer> lottoResults, int bonusNumber) {
        int[] counts = new int[lottoNumbersList.size()];
        int[] bonusCounts = new int[lottoNumbersList.size()];

        for (int i = 0; i < lottoNumbersList.size(); i++) {
            List<Integer> ticket = lottoNumbersList.get(i);
            int count = 0;
            int bonusCount = 0;

            for (int number : ticket) {
                if (lottoResults.contains(number)) {
                    count++;
                }
            }

            if (lottoResults.contains(bonusNumber)) {
                bonusCount = 1; // 보너스 번호가 있으면 1로 설정
            }

            counts[i] = count;
            bonusCounts[i] = bonusCount;
        }

        // 두 배열을 반환
        return new int[][]{counts, bonusCounts};
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
