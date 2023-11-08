package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class OutputView {
    public static void printCount(int count){
        System.out.println(count+ "개를 구매했습니다.");
        System.out.println("");
    }

    public static void printLotto(List<List<Integer>> myLotto){
        for(List<Integer> a : myLotto) {
            System.out.println(a);
        }
        System.out.println("");
    }

    public static void printWinningStatistics(int[] result){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+result[0]+"개");
        System.out.println("4개 일치 (50,000원) - "+result[0]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+result[0]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) "+result[0]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+result[0]+"개");
    }

    public static void printTotalWinningStatistics(int ratio){
        System.out.println("총 수익률은 "+ratio+"%입니다.");
    }
}
