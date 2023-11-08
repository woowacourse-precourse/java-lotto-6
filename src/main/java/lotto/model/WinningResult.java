package lotto.model;

public enum WinningResult {

  FIFTH(3, "3개 일치 (5,000원) - ", 5000),
  FOURTH(4, "4개 일치 (50,000원) - ", 50000),
  THIRD(5, "5개 일치 (1,500,000원) - ", 1500000),
  SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
  FIRST(6, "6개 일치 (2,000,000,000원) - ", 2000000000);


  private final int matchCount;
  private final String message;

  private final int price;

  WinningResult(int matchCount, String message, int price) {
    this.matchCount = matchCount;
    this.message = message;
    this.price = price;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public String getMessage() {
    return message;
  }

  public int getPrice() {
    return price;
  }
  public static WinningResult getWinningResult(int count, int bonusNumber) {
    if (count == FIRST.matchCount) {
      return FIRST;
    } else if (count == SECOND.matchCount) {
      return SECOND;
    } else if (count == THIRD.matchCount && bonusNumber != 0) {
      return THIRD;
    } else if (count == FOURTH.matchCount) {
      return FOURTH;
    } else if (count == FIFTH.matchCount) {
      return FIFTH;
    } else {
      return null; // 매칭되는 결과가 없을 경우
    }
  }
}
