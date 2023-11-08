package lotto.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.WinningNumberDTO;

public class LottoRefree {

    private HashMap<String,Integer> prizeNum = new HashMap<>();

    private BigDecimal winningPrize;
    private int threeNum=0;
    private int fourNum=0;
    private int fiveNum=0;
    private int five_WITH_BONUS_Num=0;
    private int sixNum=0;



    public HashMap<String,Integer> makePrizeNum(WinningNumberDTO WNDTO , List<Lotto> lottos){
        for(Lotto lotto : lottos){
            judgeEqual(WNDTO,lotto);
        }

        prizeNum.put("Three",threeNum);
        prizeNum.put("Four",fourNum);
        prizeNum.put("Five",fiveNum);
        prizeNum.put("Five_WITH_BONUS",five_WITH_BONUS_Num);
        prizeNum.put("Six",sixNum);

        return prizeNum;
    }

    public void judgeEqual(WinningNumberDTO WNDTO,Lotto lotto){
        int count=0;
        for (Integer num : lotto.getNumbers()) {
            if (WNDTO.getWinningNumbers().contains(num)) {
                count++;
            }
        }
        plusEqualNum(count,lotto,WNDTO.getBonusNumber());
    }

    public void plusEqualNum(int count,Lotto lotto,int bonusNum){
        if(count==3){
            threeNum++;
        }
        if(count==4){
            fourNum++;
        }
        if(count==5){
            judgeBonusEqual(lotto.getNumbers(),bonusNum);
        }
        if(count==6){
            sixNum++;
        }
    }

    public void judgeBonusEqual(List<Integer> lottonum,int BonusNum){
        if(lottonum.contains(BonusNum)){
            five_WITH_BONUS_Num++;
            return;
        }
        fiveNum++;
        return;
    }

    public void calcWinningPrize(){
        winningPrize = new BigDecimal(threeNum*5000+fourNum*50000+fiveNum*1500000+five_WITH_BONUS_Num*30000000+sixNum*2000000000);
    }

    public BigDecimal calcWinningRate(int totalPrice){
        calcWinningPrize();
        BigDecimal BDtotalPrice = new BigDecimal(totalPrice);
        BigDecimal result = winningPrize.divide(BDtotalPrice);
        BigDecimal percent = new BigDecimal(100);
        return result.multiply(percent);
    }


}
