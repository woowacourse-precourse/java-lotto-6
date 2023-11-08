package lotto.view;

import lotto.constants.Prize;
import lotto.constants.SystemMessage;
import lotto.domain.Lottos;

public class Output {
    public static void ShowLottos(Lottos lottos){
        System.out.printf(SystemMessage.LOTTO_AMOUNT.getMessage(), lottos.getAmount());
        System.out.printf(lottos.getLottoStrings());
        System.out.printf(SystemMessage.EMPTY_STRING.getMessage());
    }

    public static void ShowResult(int[] result){
        System.out.printf(SystemMessage.RESULT_HEADER.getMessage());

        Prize[] prizes = Prize.values();
        for(int i=1; i<prizes.length; i++){
            String PrizeMsg = prizes[i].getMessage();
            int PrizeNum = result[prizes[i].getIdx()];

            System.out.printf(SystemMessage.LOTTO_RESULT.getMessage(), PrizeMsg, PrizeNum);
        }
    }

    public static void ShowProfit(int[] result, int prevMoney){
        int lottoMoneySum=getSum(result);

        double profit=lottoMoneySum/prevMoney*100;
        double roundedValue = Math.round(profit * 10.0) / 10.0;

        System.out.printf(SystemMessage.LOTTO_PROFIT.getMessage(), roundedValue);
    }

    private static int getSum(int[] result){
        int moneySum=0;
        Prize[] prizes = Prize.values();

        for(int i=0; i<prizes.length; i++){
            int PrizePrice = prizes[i].getPrice();
            int Prizenum = result[prizes[i].getIdx()];

            moneySum+=PrizePrice*Prizenum;
        }
        return moneySum;
    }
    }
