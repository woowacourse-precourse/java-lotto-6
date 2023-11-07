package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
  private static final int LOTTO_PRICE = 1000;
  private static final int MIN_LOTTO_NUMBER = 1;
  private static final int MAX_LOTTO_NUMBER = 45;
  private static final int LOTTO_NUMBERS_COUNT = 6;
  
  private final int lottoCount;
  
//  사용자로부터 입력받은 구매 금액을 검증, 구매 가능한 로또의 갯수 계산.
  public LottoMachine(int purchaseAmount) {
    validatePurchaseAmount(purchaseAmount);
    this.lottoCount = purchaseAmount / LOTTO_PRICE;
  }
  
//  구매 금액이 1,000원 단위가 아닐 경우 예외 발생.
  private void validatePurchaseAmount(int purchaseAmount) {
    if (purchaseAmount % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위여야 합니다.");
    }
  }
  
//  구매 가능한 로또의 갯수만큼 로또를 생성.
  public List<Lotto> purchaseLottos() {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < lottoCount; i++) {
      lottos.add(generateLotto());
    }
    return lottos;
  }
  
//  1~45 사이의 숫자 6개를 랜덤하게 선택해서 로또 생성.
  private Lotto generateLotto() {
    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBERS_COUNT);
    return new Lotto(numbers);
  }
}