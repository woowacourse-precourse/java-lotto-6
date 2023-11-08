package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.text.DecimalFormat;

import camp.nextstep.edu.missionutils.Console;

public class Teller {
  private InputValidation validate = new InputValidation();
  private final Integer INITIALSTATE = -1;
  private final Integer THREEMATCH = 3;
  private final Integer FOURMATCH = 4;
  private final Integer FIVEMATCH = 5;
  private final Integer FIVEMATCHANDBONUS = 7;
  private final Integer SIXMATCH = 6;

  public Integer getMoneyAmount() {
    System.out.println(Speaker.PROMPTBUYAMOUNT.speak());
    return getValidatedMoneyAmount();
  }

  public Integer getValidatedMoneyAmount() {
    Integer validInput = INITIALSTATE;
    do {
      String input = Console.readLine();
      try {
        validInput = validate.moneyInput(input);
        break;
      }
      catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
      }
    }
    while (true);
    return validInput;
  }

  public void showMoneyAmount(Integer lottoAmount) {
    System.out.println();
    System.out.print(lottoAmount);
    System.out.println(Speaker.BOUGHTAMOUNT.speak());
  }

  public void showLottoNumbers(ArrayList<Lotto> reciept) {
    for (Lotto lotto : reciept) {
      System.out.println(lotto.toString());
    }
  }

  public List<Integer> getLottoNumbers() {
    System.out.println();
    System.out.println(Speaker.PROMPTLOTTO.speak());
    return getValidatedLottoNumbers();
  }

  public List<Integer> getValidatedLottoNumbers() {
    ArrayList<Integer> lottoNumbers;
    while (true) {
      lottoNumbers = new ArrayList<>();
      try {
        String input = Console.readLine();
        validate.emptyInput(input);
        String[] numbers = validate.lottoInput(input);
        fillLottoNumbers(lottoNumbers, numbers);
        break;
      }
      catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
      }
    }
    return lottoNumbers;
  }

  public void fillLottoNumbers(List<Integer> lottoNumbers, String[] numbers) {
    for (String number : numbers) {
      Integer convertedNumber = Integer.parseInt(number);
      validate.lottoDuplicate(lottoNumbers, convertedNumber);
      validate.lottoRange(convertedNumber);
      lottoNumbers.add(convertedNumber);
    }
  }

  public Integer getBonusNumber(List<Integer> lottoNumbers) {
    System.out.println();
    System.out.println(Speaker.PROMPTBONUS.speak());
    Integer bonusNumber;
    while (true) {
      try {
        String input = Console.readLine();
        bonusNumber = validate.bonusNumber(input);
        validate.lottoDuplicate(lottoNumbers, bonusNumber);
        break;
      }
      catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
      }
    }
    return bonusNumber;
  }

  public void showResult(HashMap<Integer, Integer> wins) {
    System.out.println();
    System.out.println(Speaker.RESULT.speak());
    System.out.println(Speaker.DASHES.speak());
    showEachWin(Speaker.MATCHEDTHREE.speak(), formatWins(wins.get(THREEMATCH)));
    showEachWin(Speaker.MATCHEDFOUR.speak(), formatWins(wins.get(FOURMATCH)));
    showEachWin(Speaker.MATCHEDFIVE.speak(), formatWins(wins.get(FIVEMATCH)));
    showEachWin(Speaker.MATCHEDFIVEANDBONUS.speak(), formatWins(wins.get(FIVEMATCHANDBONUS)));
    showEachWin(Speaker.MATCHEDSIX.speak(), formatWins(wins.get(SIXMATCH)));
  }

  public void showEachWin(String match, Integer win) {
    System.out.print(match);
    System.out.print(win);
    System.out.println(Speaker.AMOUNT.speak());
  }

  public Integer formatWins(Integer win) {
    if(win == null) {
      return 0;
    }
    return win;
  }

  public void showTotalWin(Double awardPercent) {
    System.out.print(Speaker.PROFIT.speak());
    DecimalFormat df = new DecimalFormat("#.0");
    System.out.print(df.format(awardPercent));
    System.out.println(Speaker.PROFITEND.speak());
  }
}
