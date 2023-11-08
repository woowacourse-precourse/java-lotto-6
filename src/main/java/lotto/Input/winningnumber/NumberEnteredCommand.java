package lotto.Input.winningnumber;

import java.util.List;
import lotto.Lotto;

public class NumberEnteredCommand {

  private final List<Lotto> lottos;

  private NumberEnteredCommand(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public static NumberEnteredCommand of(List<Lotto> lottos) {
    return new NumberEnteredCommand(lottos);
  }

  public List<Lotto> getLottos() {
    return lottos;
  }
}
