package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class InputProcessor {
    private static final int LOTTO_PRICE = 1000;
  public String getInput;

  public int calculateLottoCount(int money) {
      return money / LOTTO_PRICE;
    }

    public static String[] lottoNumberSplit(String lottoWinningNumber) {
      return lottoWinningNumber.split(" ,");
    }

    public static List<String> winningNumberSplit(String[] lottoNumberSplit) {
      List<String> winningNumber = Arrays.asList(lottoNumberSplit);
      return winningNumber;
    }

}

