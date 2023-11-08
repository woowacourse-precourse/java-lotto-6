package lotto.dto;

public class Result {

  private final String result;

  public Result(String result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return result;
  }
}
