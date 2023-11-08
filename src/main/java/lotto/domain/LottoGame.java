package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
  private final List<Lotto> reciept = new ArrayList<>();
  private final LottoMachine machine = new LottoMachine();
  private final Teller teller = new Teller();
  private final Printer printer = new Printer();

  public void start() {
    
  }
}
