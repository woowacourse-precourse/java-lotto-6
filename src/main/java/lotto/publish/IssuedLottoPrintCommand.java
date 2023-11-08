package lotto.publish;

import java.util.List;
import lotto.Lotto;

public class IssuedLottoPrintCommand {

  private final List<Lotto> lottos;

  private IssuedLottoPrintCommand(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public static IssuedLottoPrintCommand of(List<Lotto> lottos) {
    return new IssuedLottoPrintCommand(lottos);
  }

  public List<Lotto> getLottos() {
    return lottos;
  }
}
