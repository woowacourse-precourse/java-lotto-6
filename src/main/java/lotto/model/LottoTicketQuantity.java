package lotto.model;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoTicketQuantity {

  private static int lottoTicketQuantity;
  private static final int LOTTO_PRICE = 1000;
  private static final String PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액이 유효하지 않습니다.";
  private static final String THOUSANDS_ERROR_MESSAGE = "[ERROR] 천원 단위로 입력해주세요.";


  public LottoTicketQuantity(String purchaseAmount) {
    nonDivisibleAmount(Integer.parseInt(purchaseAmount));
    this.lottoTicketQuantity = calculateLottoTicketQuantity(Integer.parseInt(purchaseAmount));
  }

  private int calculateLottoTicketQuantity(int purchaseAmount) {
    return purchaseAmount / LOTTO_PRICE;
  }

  private void nonDivisibleAmount(int purchaseAmount) {

    if (purchaseAmount % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException(THOUSANDS_ERROR_MESSAGE);
    }
  }



  public int getLottoTicketQuantity() {
    return lottoTicketQuantity;
  }

}

