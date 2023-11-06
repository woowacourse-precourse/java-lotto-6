package lotto.publish;

public enum LottoIssueRule {
  COUNT(6),
  START_INCLUSIVE(1),
  END_INCLUSIVE(45);

  private final int value;

  LottoIssueRule(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
