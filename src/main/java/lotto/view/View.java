package lotto.view;

import static lotto.Constant.*;
import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.List;

public class View {

    public String inputBuyingMoney(){
        System.out.println(INPUT_BUYING_NUM_MESSEAGE);
        return Console.readLine();
    }
    public void inputExceptionMessage(){
        System.out.println(INPUT_BUYING_NUM_EXCEPTION_MESSAGE);
    }

    public void outputExceptionMessage(){
        System.out.println(OUTPUT_CORRECT_NUM_EXCEPTION_MESSAGE);
    }
    public void BuyingLottoOutput(List<Lotto> lottoList,int buyingnum){
        System.out.println(buyingnum+"개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }
    public void outputResultMessage(int[] result){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+result[4]+"개");
        System.out.println("4개 일치 (50,000원) - "+result[3]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+result[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+result[1]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+result[0]+"개");
    }

    public void outputEarningResultMessage(double num){
        System.out.println("총 수익률은 "+ num +"%입니다.");
    }
    public String inputBonusNum(){
        System.out.println((INPUT_BONUS_NUM_MESSAGE));
        return Console.readLine();
    }

    public String inputCorrectNUM(){
        System.out.println(INPUT_CORRECT_NUM_MESSAGE);
        return Console.readLine();
    }

}
