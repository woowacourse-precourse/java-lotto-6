package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.LotteryCalculator;
import lotto.model.LotteryManager;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.utils.GuideMessage;
import lotto.utils.Prize;
import lotto.validation.LotteryNumberValidator;
import lotto.view.Input;
import lotto.view.Output;

public class LotteryHost {

  private int[] result;

  private Lotto generateLotto() {
    List<Integer> numbers = LotteryManager.generateLottoNumbers();
    List<Integer> newNumbers = new ArrayList<>(numbers);
    return new Lotto(newNumbers);
  }

  public LotteryHost() {
    this.result = new int[5];
  }

  public List<Lotto> generateAndSaveLottoTickets(int numberOfLottery) {
    return IntStream.range(0, numberOfLottery).mapToObj(lottoTicket -> generateLotto())
        .collect(Collectors.toList());
  }

  public String inputLottoCount() {
    return Input.readLine();
  }

  public String inputWinningNumbers() {
    Output.print(GuideMessage.INPUT_WINNING_NUMBERS.getMessage());
    return Input.readLine();
  }

  public WinningLotto generateWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
    return new WinningLotto(winningNumbers, bonusNumber);
  }

  public String inputBonusNumber() {
    Output.print(GuideMessage.INPUT_BONUS_NUMBER.getMessage());
    String bonusNumber = Input.readLine();
    LotteryNumberValidator.validateNumberFormat(bonusNumber);
    return bonusNumber;
  }

  public void compareLottoNumbersAndWinningNumbers(List<Lotto> lottoTickets,
      WinningLotto winningLotto) {
    this.result = LotteryCalculator.calculateResult(lottoTickets,
        winningLotto.getWinningLotto().getNumbers(), winningLotto.getBonusNumber());
  }

  public double calculateRate(int numberOfLottery) {
    double profit = 0;
    profit += result[0] * Prize.FIFTH_PRIZE.getValue();
    profit += result[1] * Prize.FOURTH_PRIZE.getValue();
    profit += result[2] * Prize.THIRD_PRIZE.getValue();
    profit += result[3] * Prize.SECOND_PRIZE.getValue();
    profit += result[4] * Prize.FIRST_PRIZE.getValue();
    return (Math.round(profit / numberOfLottery * 1000)) / 10000.0;
  }

  public int[] getResult() {
    return this.result;
  }
}
