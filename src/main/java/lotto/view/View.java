package lotto.view;

import static lotto.Constant.*;
import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.LottoResult;

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
        System.out.println(LottoResult.Rank5.getMessage()+result[4]+"개");
        System.out.println(LottoResult.Rank4.getMessage()+result[3]+"개");
        System.out.println(LottoResult.Rank3.getMessage()+result[2]+"개");
        System.out.println(LottoResult.Rank2.getMessage()+result[1]+"개");
        System.out.println(LottoResult.Rank1.getMessage() +result[0]+"개");
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
