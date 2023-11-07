package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;

public class LottoCompareController {


    private  static  int treeNumMath = 0;
    private  static  int fourNumMath = 0;
    private  static  int fiveNumMath = 0;
    private  static  int fiveAndBonusNumMath = 0;
    private  static  int sixNumNumMath = 0;

    public static void lottoTicketsCompareNum(){
        for(Lotto lotto : LottoTickets.getBuyLottoTickets()){
            lottoCompareNum(lotto);
        }

    }

    private static void lottoCompareNum(Lotto lotto){
        int mathNum = 0;
        boolean bonusNum = false;
        for(Integer lottoNum : lotto.getNumbers()){
            if(WinningNumber.getWinningNums().contains(lottoNum)){
                mathNum++;
            }
            if(WinningNumber.getBonusNum() == lottoNum){
                bonusNum = true;
            }
        }
        increaseWinningDetails(mathNum,bonusNum);
    }
    private static void increaseWinningDetails(int mathNum, boolean bonusNum){
        if(mathNum == 3){
            treeNumMath ++;
        }
        if(mathNum == 4){
            fourNumMath++;
        }
        if(mathNum == 5){
            if(bonusNum == false){
                fiveNumMath++;
            }
            if(bonusNum == true){
                fiveAndBonusNumMath++;
            }
        }
        if(mathNum == 6){
            sixNumNumMath++;
        }
    }

}
