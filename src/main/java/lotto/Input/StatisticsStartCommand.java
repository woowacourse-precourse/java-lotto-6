package lotto.Input;

import java.util.List;
import lotto.Input.winningnumber.NumberEnteredEvent;
import lotto.Lotto;

public class StatisticsStartCommand {

  private final Lotto winningNumber;
  private final int bonusNumber;

  private final List<Lotto> lottos;

  private final int standardPrice;

  private StatisticsStartCommand(Lotto winningNumber, int bonusNumber, List<Lotto> lottos,
      int standardPrice) {
    this.winningNumber = winningNumber;
    this.bonusNumber = bonusNumber;
    this.lottos = lottos;
    this.standardPrice = standardPrice;
  }


  public static StatisticsStartCommand of(NumberEnteredEvent event, List<Lotto> lottos, int standardPrice) {
    return new StatisticsStartCommand(event.getWinningLotto(), event.getBonusNumber().getBonusNumber(), lottos, standardPrice);
  }

  @Override
  public String toString() {
    return "StatisticsStartCommand{" +
        "winningNumber=" + winningNumber +
        ", bonusNumber=" + bonusNumber +
        ", lottos=" + lottos +
        ", standardPrice=" + standardPrice +
        '}';
  }
}
