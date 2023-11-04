package lotto.io;


import lotto.domain.Award;
import lotto.system.Constant;
import lotto.system.IOMessage;

import java.util.Collections;
import java.util.List;

public final class OutputHandler {

    private OutputHandler(){

    }

    public static void printLotto(List<Integer> lotto){
        System.out.println(lotto.toString());
    }

    public static void printReceipts(int size){
        System.out.println();
        System.out.println(size+"개를 구매했습니다.");
    }

    public static void printReward(List<Award> awards){
        System.out.println();
        System.out.println(IOMessage.WRITE_RESULT);
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ Collections.frequency(awards,Award.THREE)+"개");
        System.out.println("4개 일치 (50,000원) - "+ Collections.frequency(awards,Award.FOUR)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+ Collections.frequency(awards,Award.FIVE)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ Collections.frequency(awards,Award.FIVE_BONUS)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ Collections.frequency(awards,Award.SIX)+"개");
    }

    public static void printYield(float yield){
        System.out.println("총 수익률은 "+yield+"%입니다.");
    }
}
