package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoList;
import lotto.domain.Player;
import lotto.util.Util;
import lotto.validation.LottoValidation;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoController {
  private Player player;
  private LottoList lottoList;

  public void play() {
    prepareLotto();
    progressLotto();
    calculateLotto();
  }

  private void prepareLotto() {
    player = new Player(getAmount());
    Output.printAmount(player.convertMoneyToUnit());
    Output.printLotteries(player);
  }

  private void progressLotto() {
    List<Integer> winningNumber = getWinningNumber();
    int bonusNumber = getBonusNumber();
    while (true) {
      try {
        LottoValidation.validateIsDuplicatedWiningAndBonusNumber(winningNumber, bonusNumber);
        break;
      } catch (IllegalArgumentException e) {
        System.out.println(e);
        bonusNumber = getBonusNumber();
      }
    }
    lottoList = new LottoList(winningNumber, bonusNumber, player);
  }

  private void calculateLotto() {
    lottoList.classifyLottoGrade();
    double totalRate = lottoList.calculateTotalRate();
    Output.printResult();
    Output.printResultList(lottoList.getLottoResultWithCount());
    Output.printTotalRate(totalRate);
  }

  private int getAmount() {
    try {
      Input.inputAmount();
      int amount = Util.convertStringToInt(Util.getInputAndCheckIsNumber());
      Util.validateAmount(amount);
      return amount;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
      return getAmount();
    }
  }

  private List<Integer> getWinningNumber() {
    try {
      Input.inputWinningNumber();
      String input = Console.readLine();
      List<Integer> number = Util.convertStringToIntList(input);
      Util.validateWinningNumber(number);
      return number;
    }
    catch (IllegalArgumentException e) {
      System.out.println(e);
      return getWinningNumber();
    }
  }

  private int getBonusNumber() {
    try {
      Input.inputBonusNumber();
      int number = Util.convertStringToInt(Util.getInputAndCheckIsNumber());
      Util.validateBonusNumber(number);
      return number;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
      return getBonusNumber();
    }
  }
}
