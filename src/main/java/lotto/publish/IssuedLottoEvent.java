package lotto.publish;

import java.util.List;
import lotto.Lotto;

public class IssuedLottoEvent {

  private final IssuedNumber issuedNumber;
  private final List<Lotto> lottos;

  private IssuedLottoEvent(IssuedNumber issuedNumber, List<Lotto> lottos) {
    this.issuedNumber = issuedNumber;
    this.lottos = lottos;
  }

  public static IssuedLottoEvent of(IssuedNumber issuedNumber, List<Lotto> lottos) {
    return new IssuedLottoEvent(issuedNumber, lottos);
  }

  public IssuedNumber getIssuedNumber() {
    return issuedNumber;
  }

  public List<Lotto> getLottos() {
    return lottos;
  }
}
