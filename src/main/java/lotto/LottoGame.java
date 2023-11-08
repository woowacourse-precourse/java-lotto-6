package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {


    private RandomNumberGenerator randomNumberGenerator;

    private List<Lotto> lottos = new ArrayList<>();


    public LottoGame() {
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public List<Lotto> buyLotto(int count) {
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
