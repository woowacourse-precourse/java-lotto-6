package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private List<Lotto> lottos = new ArrayList<>();


    public void startGame() {
        Output output = new Output();
        Input input = new Input();

        output.requestMoneyOutput();
        int moneyInput =input.getMoneyInput();
        int count = moneyInput / Constants.LOTTO_PRICE;
        List<Lotto> lottos = buyLotto(count);
        output.responseBuyOutput(count, lottos);

        output.requestWinnerNumbers();
        List<Integer> numbers =input.getWinnerNumbers();

        output.requestBonusNumber();
        int bonusNumber = input.getBonusNumber();

        Map<Integer, Integer> winners = new HashMap<>();
        winners.put(3, 3);
        winners.put(4, 4);
        winners.put(5, 5);
        winners.put(6, 6);
        output.responseCalculateWinners(winners, 55.6);
    }

    public List<Lotto> buyLotto(int count) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = randomNumberGenerator.GenerateLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public Map<Integer, Integer> caculateWinners( List<Integer> winningNumbers) {
        WinnersCalculator winnersCalculator = new WinnersCalculator(winningNumbers);
        Map<Integer, Integer> winners = winnersCalculator.calculateWinners(lottos);
        return winners;
    }



}
