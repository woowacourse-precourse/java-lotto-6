package lotto.domain;

public class InputValidation {
  private final Integer LOTTOMIN = 1;
  private final Integer LOTTOMAX = 45;
  private final Integer MONEYUNIT = 1000;

  public Integer moneyInput(String input) {
    try {
      Integer validInput = Integer.parseInt(input);
      if (validInput / MONEYUNIT != 0) {
        throw new IllegalArgumentException(Speaker.ERRORMONEYRANGE.speak());
      }
      return validInput;
    }
    catch (NumberFormatException e){
      throw new IllegalArgumentException(Speaker.ERRORMONEYRANGE.speak());
    }
  }

}
