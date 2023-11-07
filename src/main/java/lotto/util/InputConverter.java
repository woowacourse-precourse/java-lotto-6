package lotto.util;

public class InputConverter {

  public int inputToNumber(String input) {
    return Integer.parseInt(input);
  }

  public String[] inputToSplit(String input) {
    return input.split(SpecialSign.SEPARATOR.getSign());
  }
}
