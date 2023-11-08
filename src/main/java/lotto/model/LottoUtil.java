package lotto.model;

import lotto.constant.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoUtil {

    private Lotto lottoCreate(List<Integer> randomNumbers) {
        List<Integer> lottoNumbers = randomNumbers.stream().sorted().collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> lottoCreateCount(List<List<Integer>> randomNumbers) {
        List<Lotto> lottos = new ArrayList<>();

        for (List<Integer> randomNumber : randomNumbers) {
            lottos.add(lottoCreate(randomNumber));
        }

        return lottos;
    }

    public Map<Rank, Integer> compareLottoNumbers(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            int shot = lotto.compareNumbers(winningLotto.getLotto().getNumbers());
            boolean bonus = lotto.getNumbers().stream().anyMatch(n -> winningLotto.getBonusNumber() == n);
            result.put(Rank.getRank(shot, bonus),
                    result.getOrDefault(Rank.getRank(shot, bonus), 0) + 1);
        }
        return result;
    }

    public float rateOfReturn(int amount, Map<Rank, Integer> result) {
        int sum = 0;
        for (Rank rank : result.keySet()) {
            sum += rank.getMoney() * result.get(rank);
        }
        return (float) sum / amount * LottoConstants.PERCENTAGE;
    }
}
