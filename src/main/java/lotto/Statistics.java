package lotto;

import java.util.List;

public class Statistics {

    private final List<List<Integer>> lottoNumbers;
    private final List<Integer> winningNumbers;
    private final Integer bonus;

    int matching_3 = 0;
    int matching_4 = 0;
    int matching_5 = 0;
    int matching_6 = 0;
    int matching_bonus = 0;
    int matchingBonus = 0;

    public Statistics(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers, Integer bonus) {
        this.lottoNumbers = lottoNumbers;
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public void compareNumber(){
        for (List<Integer> lottoNumber : lottoNumbers) {
            int matchingCount = 0;
            for (Integer number : lottoNumber) {
                if(number == bonus){
                    matchingBonus++;
                }else{// else 사용하지 않기.
                    for (Integer winningNumber : winningNumbers) {
                        if(number == winningNumber){
                            matchingCount++;
                            break;
                        }
                    }
                }
            }
            countMatch(matchingCount, matchingBonus);
        }
        printResult();
    }

    private void countMatch(int matchingCount, int matchingBonus) {
        if(matchingCount == 3){
            matching_3++;
        }

        if(matchingCount == 4){
            matching_4++;
        }

        if(matchingCount == 5 && matchingBonus == 0){
            matching_5++;
        }

        if(matchingCount == 5 && matchingBonus == 1){
            matching_bonus++;
        }

        if(matchingCount == 6){
            matching_6++;
        }
    }

    public void printResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matching_3 +"개");
        System.out.println("4개 일치 (50,000원) - " + matching_4 +"개");
        System.out.println("5개 일치 (1,500,000원) - " + matching_5 +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matching_bonus +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matching_6 +"개");

        double revenue = (matching_3*5000)+(matching_4*50000)+(matching_5*1500000)+(matching_bonus*30000000)+(matching_6*2000000000);
        double revenuePercent = revenue/(lottoNumbers.size()*1000)*100;
        System.out.println("총 수익률은 "+revenuePercent+"%입니다.");
    }
}
