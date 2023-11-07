package lotto.util;

public class InputConverter {

  private static final String SEPARATOR = ",";

  public int inputToNumber(String input) {
    return Integer.parseInt(input);
  }

  public String[] inputToSplit(String input) {
    return input.split(SEPARATOR);
  }
}
