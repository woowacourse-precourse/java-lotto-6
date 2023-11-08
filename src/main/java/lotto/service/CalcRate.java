package lotto.service;

import lotto.model.Prize;

public class CalcRate {
  public double calcRate(int[] results, int payment){
    double rate = 0;
    int prizeSum = getPrizeSum(results);
    rate = (prizeSum - payment) / prizeSum * 100;
    return rate;
  }

  public static int getPrizeSum(int[] results){
    int totalPrize = 0;
    for(int i = 0; i < 5;i++){
      Prize prize = Prize.values()[i];
      totalPrize += results[i] * prize.getPrizeMoney();
    }
    System.out.println(totalPrize);
    return totalPrize;
  }
}
