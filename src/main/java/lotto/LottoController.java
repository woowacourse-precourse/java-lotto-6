package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
  private final List<Lotto> lottoList;
  private final LottoResults lottoResults;
  private final InputView inputView;
  private final OutputView outputView;



  public LottoController() {
    lottoList = new ArrayList<>();
    lottoResults = new LottoResults();
    inputView = new InputView();
    outputView = new OutputView();
  }


  public void playLotto() {
    this.generateTickets(inputView.purchaseAmount());
    outputView.printTickets(lottoList);
    Lotto winningNumbers = inputView.winningNum();
    int bonusNumber = inputView.bonusNum(winningNumbers);
    outputView.printWinnings();
  }

  private void generateTickets(int purchaseAmount) {
    int numberOfTickets = purchaseAmount / 1000;
    System.out.println(numberOfTickets + "개를 구매했습니다.");
    while (numberOfTickets > 0) {
      List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
      Collections.sort(numbers);
      this.lottoList.add(new Lotto(numbers));
      numberOfTickets--;
    }
  }
}
