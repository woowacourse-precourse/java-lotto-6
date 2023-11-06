package lotto.view;

import lotto.model.Prize;

import java.util.Map;

public class OutputMessage {
    public static void printLottoCount(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printPrizeStat(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printResult(Map<Prize,Integer> result){
        for(int i = Prize.values().length - 2 ; i >= 0 ; i--){
            System.out.println(Prize.printMessage(Prize.values()[i]) + " " +  result.get(Prize.values()[i]));
        }
    }
}
