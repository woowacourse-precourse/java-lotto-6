package lotto.model;

public class LotteryPolicy {

  protected static final int MIN_NUMBER = 1;
  protected static final int MAX_NUMBER = 45;
  protected static final int LOTTO_NUMBER_SIZE = 6;
  protected static final String SEPARATOR = ",";
  protected static final int LOTTO_PRICE = 1000;
  protected static final String INVALID_NUMBER_ERROR_MESSAGE = "[ERROR] 1 ~ 45 범위의 숫자를 입력하세요.";
  protected static final String INVALID_PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.";
  protected static final String INVALID_PURCHASE_AMOUNT_FORMAT_ERROR_MESSAGE = "[ERROR] 구입 금액에 문자가 포함되어 있습니다.";
  protected static final String INVALID_TOKEN_ERROR_MESSAGE = "[ERROR] 당첨 번호의 개수는 6개여야 합니다.";

}
