package service;

import lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static constants.Constant.*;

public class OutputService {

    public static void printGeneratedLotto(Integer lottoCount,
                                    List<Lotto> lottoList) {
        System.out.println(lottoCount+PURCAHSED_STRING);

        for(Lotto lotto : lottoList){
            System.out.println(
                    LEFT_BRACKET+lotto.convertToString()+RIGHT_BRACKET);
        }
    }

    public static void printLottoStat(HashMap<String, Integer> stat){
        System.out.println(RESULT_STAT_STRING);
        stat.forEach((key,value)->{
          if(Objects.equals(key, "3")){
              System.out.println(HIT_THREE_STRING+value+COUNT_STRING);
          }
          else if(Objects.equals(key, "4")){
              System.out.println(HIT_FOUR__STRING+value+COUNT_STRING);
          }
          else if(Objects.equals(key, "5")){
              System.out.println(HIT_FIVE_STRING+value+COUNT_STRING);
          }
          else if(Objects.equals(key, "5+")){
              System.out.println(HIT_FIVE_BOUNUS_STRING+value+COUNT_STRING);
          }
          else if(Objects.equals(key, "6")){
              System.out.println(HIT_SIX_STRING+value+COUNT_STRING);
          }
        });
    }

    public static void printProfit(Float profitPercent){

        System.out.println(TOTAL_PROFIT_BEGIN+
                String.format("%.1f", profitPercent)+TOTAL_PROFIT_END);
    }
}
