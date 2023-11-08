package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

  private List<Lotto> lottos = new ArrayList<>();

  public Lottos(int lottoTicketQuantity) {
    for (int i = 0; i < lottoTicketQuantity; i++) {
      lottos.add(new Lotto(LottoNumberGenerator.lottoNumberGenerate()));
    }
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  public void addLottos(String winningNumbers) {
    String[] numberStrings = winningNumbers.split(",");
    List<Integer> numbers = new ArrayList<>();

    for (String numberString : numberStrings) {
      int number = Integer.parseInt(numberString.trim());
      numbers.add(number);
    }

    lottos.add(new Lotto(numbers));
  }


  private int countMatchedNumbers(Lotto purchasedLotto, Lotto winningLotto) {
    List<Integer> purchasedNumbers = purchasedLotto.getNumbers();
    List<Integer> winningNumbers = winningLotto.getNumbers();

    long matchedCount = purchasedNumbers.stream()
        .filter(winningNumbers::contains)
        .count();

    return (int) matchedCount;
  }
  public Map<WinningResult, Integer> checkWinningResult(int bonusNumber) {
    Map<WinningResult, Integer> result = new HashMap<>();
    Lotto winningLotto = lottos.get(lottos.size() - 1);

    for (int i = 0; i < lottos.size() - 1; i++) {
      int count = countMatchedNumbers(lottos.get(i), winningLotto);
      WinningResult winningResult = WinningResult.getWinningResult(count, bonusNumber);

      if (winningResult != null) {
        result.put(winningResult, result.getOrDefault(winningResult, 0) + 1);
      }
    }
    return result;
  }
  public double calculateTotalWinningAmount(Map<WinningResult, Integer> result, int lottoTicketQuantity) {
    int totalWinningAmount = 0;

    for (WinningResult winningResult : WinningResult.values()) {
      Integer count = result.get(winningResult);
      if (count != null) {
        int prize = winningResult.getPrice();
        totalWinningAmount += count * prize;
      }
    }
    double profitRate = (totalWinningAmount) / (double) lottoTicketQuantity/10;
    return Math.round(profitRate * 100.0) / 100.0;
  }

}
