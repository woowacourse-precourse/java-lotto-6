package lotto;

import java.util.List;

public class LottoResultManager {
    int[] numberCount = new int[5];
    public int[] calculateCount(List<Integer> winningNumbers, Lotto[] lotto, int i, int bonusNumber) {
        int count = lotto[i].compareNumbers(winningNumbers,bonusNumber); // 로또티켓 한장과 당첨번호를 비교한 후 같은 개수
        // 숫자가 3개 일치하는 로또 개수 -> numberCount[0]
        // 숫자가 4개 일치하는 로또 개수 -> numberCount[1]
        // 숫자가 5개 일치하는 로또 개수 -> numberCount[2]
        // 숫자가 6개 일치하는 로또 개수 -> numberCount[3]
        if (count == 3){
            numberCount[0]++;
        } if (count == 4){
            numberCount[1]++;
        } if (count == 5){
            numberCount[2]++;
            if(lotto[i].equalBonus(bonusNumber)){
                numberCount[4]++;
            }
            lotto[i].equalBonus(bonusNumber);
        } if (count == 6){
            numberCount[3]++;
        }
        return numberCount;
    }

    public static void showWinningResults(int[] matchCounts){ // 당첨내역 출력
        String[] money = {"5,000","50,000","1,500,000","2,000,000,000","30,000,000"};

        System.out.println("당첨 통계");
        System.out.println("---");
        for(int i=0; i<matchCounts.length-1; i++) {
            System.out.println(i+3+"개 일치 ("+money[i]+"원) - "+matchCounts[i]+"개");
            if(i==2){
                System.out.println("5개 일치, 보너스 볼 일치 ("+money[i+2]+"원) - "+matchCounts[4]+"개");
            }
        }
    }

}
