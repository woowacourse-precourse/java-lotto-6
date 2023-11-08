package lotto.domain;

import java.util.List;

public class InputValidation {
  private final Integer LOTTOMIN = 1;
  private final Integer LOTTOMAX = 45;
  private final Integer LOTTOLEN = 6;
  private final Integer MONEYUNIT = 1000;
  private final String COMMA = ",";

  public Integer moneyInput(String input) {
    try {
      Integer validInput = Integer.parseInt(input);
      if (validInput < MONEYUNIT || (validInput % MONEYUNIT) != 0) {
        throw new IllegalArgumentException(Speaker.ERRORMONEYRANGE.speak());
      }
      return validInput;
    }
    catch (NumberFormatException e){
      throw new IllegalArgumentException(Speaker.ERRORMONEYRANGE.speak());
    }
  }

  public void emptyInput(String input) {
    if(input.isEmpty() || input.startsWith(COMMA) || input.endsWith(COMMA)) {
      throw new IllegalArgumentException(Speaker.ERRORLOTTOLEN.speak());
    }
  }

  public String[] lottoInput(String input) {
    String[] numbers = input.split(COMMA);
    try {
      if(numbers.length != LOTTOLEN) {
        throw new IllegalArgumentException(Speaker.ERRORLOTTOLEN.speak());
      }
      for (String number : numbers) {
        Integer.parseInt(number);
      }
    }
    catch (NumberFormatException e){
      throw new IllegalArgumentException(Speaker.ERRORLOTTONUMBER.speak());
    }
    return numbers;
  }

  public void lottoDuplicate(List<Integer> lottoNumbers, Integer convertedNumber) {
    if(lottoNumbers.contains(convertedNumber)) {
      throw new IllegalArgumentException(Speaker.ERRORLOTTODIFF.speak());
    }
  }

  public void lottoRange(Integer convertedNumber) {
    if(convertedNumber < LOTTOMIN || convertedNumber > LOTTOMAX) {
      throw new IllegalArgumentException(Speaker.ERRORLOTTONUMBER.speak());
    }
  }

  public Integer bonusNumber(String input) {
    Integer convertedNumber;
    try {
      convertedNumber = Integer.parseInt(input);
      lottoRange(convertedNumber);
    }
    catch (NumberFormatException e){
      throw new IllegalArgumentException(Speaker.ERRORLOTTONUMBER.speak());
    }
    return convertedNumber;
  }
}
