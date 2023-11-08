package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {

  private static final String REGEX_ALPHABET_PATTERN = ".*[a-zA-Z].*";
  private static final String INVALID_PURCHASE_AMOUNT_MESSAGE = "[ERROR] 구입금액은 1000 단위로 입력해야 합니다.";
  private static final String AMOUNT_NUMBER_WITH_LETTER_MESSAGE = "[ERROR] 구입금액에 문자가 포함되어선 안됩니다.";

  private static final List<Lotto> myLotto = new ArrayList<>();
  private final int lottoTickets;

  private MyLotto(String amount) {
    int amountValue = parseAndValidateIntInThousands(amount);
    this.lottoTickets = amountValue / 1000;
  }

  public void addLotto(Lotto lotto) {
    myLotto.add(lotto);
  }

  public static MyLotto purchase(String amount) {
    return new MyLotto(amount);
  }

  public static String getAllMyLottoAsString() {
    StringBuilder result = new StringBuilder();
    for (Lotto lotto : myLotto) {
      result.append(lotto.toString()).append("\n");
    }
    return result.toString();
  }

  public List<Lotto> getMyLotto() {
    return myLotto;
  }

  public int getLottoTickets() {
    return lottoTickets;
  }

  private int parseAndValidateIntInThousands(String amount) {

    if (amount.matches(REGEX_ALPHABET_PATTERN))
      throw new IllegalArgumentException(AMOUNT_NUMBER_WITH_LETTER_MESSAGE);

    int checkAmount = Integer.parseInt(amount);

    if (checkAmount < 1000 || (checkAmount % 1000) != 0)
      throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE);

    return checkAmount;
  }
}
