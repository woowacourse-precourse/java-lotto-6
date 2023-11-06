package lotto;

import java.util.List;

public class Statistics {

    private final List<List<Integer>> lottoNumbers;
    private final List<Integer> winningNumbers;
    private final Integer bonus;

    public Statistics(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers, Integer bonus) {
        this.lottoNumbers = lottoNumbers;
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public void compareNumber(){
        int matching_3 = 0;
        int matching_4 = 0;
        int matching_5 = 0;
        int matching_6 = 0;
        int matchingBonus = 0;

        for (List<Integer> lottoNumber : lottoNumbers) {
            int matchingCount = 0;
            for (Integer number : lottoNumber) {
                if(number == bonus){
                    matchingBonus++;
                }else{ // else 사용하지 않기.
                    for (Integer winningNumber : winningNumbers) {
                        if(number == winningNumber){
                            matchingCount++;
                            // 이게 맞으면 for문을 빠져 나가도 된다.
                        }
                    }
                }

                if(matchingCount == 3){
                    matching_3++;
                }

                if(matchingCount == 4){
                    matching_4++;
                }

                if(matchingCount == 5){
                    matching_5++;
                }

                if(matchingCount == 6){
                    matching_6++;
                }
            }
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matching_3 +"개");
        System.out.println("4개 일치 (50,000원) - " + matching_4 +"개");
        System.out.println("5개 일치 (1,500,000원) - " + matching_5 +"개");
        // 조건 체크 : 5개 일치 && 보너스 볼 일치
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchingBonus +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matching_6 +"개");

        System.out.println("총 수익률은 몇입니다.");
    }

}
