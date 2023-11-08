package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Teller {
  private InputValidation validate = new InputValidation();
  private final Integer INITIALSTATE = -1

  public void getMoneyAmount() {
    System.out.println(Speaker.PROMPTBUYAMOUNT.speak());
    Integer moneyAmount = getValidatedMoneyAmount();
  }

  public Integer getValidatedMoneyAmount() {
    Integer validInput = INITIALSTATE;
    do {
      String input = Console.readLine();
      try {
        validInput = validate.moneyInput(input);
      }
      catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
      }
    }
    while (validInput == INITIALSTATE);
    return validInput;
  }
}
