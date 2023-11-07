package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {

    public Lotto lottoCreate(List<Integer> randomNumbers) {
        List<Integer> lottoNumbers = randomNumbers.stream().sorted().collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    //List의 사이즈가 로또 발행 개수를 의미
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
}
