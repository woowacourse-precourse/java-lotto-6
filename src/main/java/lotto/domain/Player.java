package lotto.domain;

import java.util.ArrayList;
import lotto.validation.LottoValidation;

public class Player {
  private final ArrayList<Lotto> lotteries = new ArrayList<>();
  private final int money;

  public Player(int money) {
    validate(money);
    this.money = money;
  }

  public ArrayList<Lotto> generateLotteries() {
    int size = convertMoneyToUnit();
    for (int i = 0; i < size; i++) {
      lotteries.add(Lotto.makeLotto());
    }
    return lotteries;
  }

  public int convertMoneyToUnit() {
    return this.money / 1000;
  }

  public ArrayList<Lotto> getLotteries() {
    return this.lotteries;
  }

  public int getMoney() {
    return this.money;
  }

  private void validate(int money) {
    LottoValidation.validateOverStandardUnit(money);
    LottoValidation.validateIsStandardUnit(money);
  }
}
