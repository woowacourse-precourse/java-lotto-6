package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private Output output = new Output();
    private Input input = new Input();
    private List<Lotto> lottos = new ArrayList<>();


    public void startGame() {
        List<Lotto> lottos = buyLotto();
        List<Integer> numbers = requestWinningNumbers();
        int bonusNumber = requestBonusNumber();
        Map<Integer, Integer> winners = responseCaculateWinners(lottos, numbers, bonusNumber);
    }

    private List<Lotto> buyLotto() {
        output.requestMoneyOutput();
        int moneyInput =input.getMoneyInput();
        int count = moneyInput / Constants.LOTTO_PRICE;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = randomNumberGenerator.GenerateLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        output.responseBuyOutput(count, lottos);
        return lottos;
    }

    private List<Integer> requestWinningNumbers() {
        output.requestWinnerNumbers();
        List<Integer> numbers =input.getWinnerNumbers();
        return numbers;
    }

    private int requestBonusNumber() {
        output.requestBonusNumber();
        int bonusNumber = input.getBonusNumber();
        return bonusNumber;
    }

    private Map<Integer, Integer> responseCaculateWinners(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        WinnersCalculator winnersCalculator = new WinnersCalculator(winningNumbers, bonusNumber);
        Map<Integer, Integer> winners = winnersCalculator.calculateWinners(lottos);
        output.responseCalculateWinners(winners, 55.6);
        return winners;
    }



}
