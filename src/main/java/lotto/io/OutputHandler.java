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
        printMessage(lotto.toString());
    }

    public static void printReceipts(int size){
        printEmptyLine();
        printMessage(size+"개를 구매했습니다.");
    }

    public static void printReward(List<Award> awards){
        printEmptyLine();
        printMessage(IOMessage.WRITE_RESULT);
        printMessage("---");
        printMessage("3개 일치 (5,000원) - "+ Collections.frequency(awards,Award.THREE)+"개");
        printMessage("4개 일치 (50,000원) - "+ Collections.frequency(awards,Award.FOUR)+"개");
        printMessage("5개 일치 (1,500,000원) - "+ Collections.frequency(awards,Award.FIVE)+"개");
        printMessage("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ Collections.frequency(awards,Award.FIVE_BONUS)+"개");
        printMessage("6개 일치 (2,000,000,000원) - "+ Collections.frequency(awards,Award.SIX)+"개");
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printEmptyLine(){
        System.out.println();
    }
    public static void printYield(float yield){
        printMessage("총 수익률은 "+yield+"%입니다.");
    }
}
