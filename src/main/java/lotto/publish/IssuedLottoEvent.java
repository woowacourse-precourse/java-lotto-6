package lotto.publish;

import java.util.List;
import lotto.Lotto;

public class IssuedLottoEvent {

  private final List<Lotto> lottos;

  private IssuedLottoEvent(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public static IssuedLottoEvent of(List<Lotto> lottos) {
    return new IssuedLottoEvent(lottos);
  }

  public IssuedLottoPrintCommand toOutputCommand() {
    return IssuedLottoPrintCommand.of(lottos);
  }

  public int getIssuedNumber() {
    return lottos.size();
  }

  public List<Lotto> getLottos() {
    return lottos;
  }
}
