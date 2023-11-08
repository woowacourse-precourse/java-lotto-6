package lotto.domain;

public enum Speaker {
  PROMPTBUYAMOUNT("구입금액을 입력해 주세요."),
  AMOUNT("개"),
  BOUGHTAMOUNT("개를 구매했습니다."),
  PROMPTLOTTO("당첨 번호를 입력해 주세요."),
  PROMPTBONUS("보너스 번호를 입력해 주세요."),
  RESULT("당첨 통계"),
  DASHES("---"),
  MATCHEDTHREE("3개 일치 (5,000원) - "),
  MATCHEDFOUR("4개 일치 (50,000원) - "),
  MATCHEDFIVE("5개 일치 (1,500,000원) - "),
  MATCHEDFIVEANDBONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
  MATCHEDSIX("6개 일치 (2,000,000,000원) - "),
  PROFIT("총 수익률은 "),
  PROFITEND("%입니다."),
  ERRORLOTTONUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
  ERRORMONEYRANGE("[ERROR] 구입 금액은 1,000원 단위의 숫자여야 합니다."),
  ERRORLOTTOLEN("[ERROR] 로또 번호는 총 6개의 숫자여야 합니다."),
  ERRORLOTTODIFF("[ERROR] 로또 번호는 모두 다른 숫자여야 합니다.");

  private String text;

  Speaker(String text) {
    this.text = text;
  }

  public String speak() {
    return text;
  }
}
