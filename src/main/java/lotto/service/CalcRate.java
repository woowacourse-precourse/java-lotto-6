package lotto.service;

import lotto.model.Prize;

public class CalcRate {
  public double calcRate(int[] results, int payment) {
    int prizeSum = 0;
    for (int i = 0; i < 5; i++) {
      Prize prize = Prize.values()[i];
      prizeSum += results[i] * prize.getPrizeMoney();
    }
    double rate = (double) prizeSum / payment * 100;
    return rate;
  }

}
