package lotto.util;

public class Converter {

  private static final String SEPARATOR = ",";

  public int toNumber(String input) {
    return Integer.parseInt(input);
  }

  public String[] toSplit(String input) {
    return input.split(SEPARATOR);
  }
}
