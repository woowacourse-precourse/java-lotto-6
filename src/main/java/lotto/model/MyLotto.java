package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {

  private static final String INVALID_PURCHASE_AMOUNT_MESSAGE = "[ERROR] 구입금액은 문자 없이 1000 단위로 입력해야 합니다.";

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

  public int getLottoTickets() {
    return lottoTickets;
  }

  private int parseAndValidateIntInThousands(String amount) {

    try {
      int checkAmount = Integer.parseInt(amount);

      if (checkAmount < 1000 || (checkAmount % 1000) != 0)
        throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE);

      return checkAmount;

    } catch (Exception e) {
      throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE);
    }
  }
}
