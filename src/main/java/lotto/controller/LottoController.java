package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.handler.UserHandler;
import lotto.model.Rank;
import lotto.view.ResultView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoController {
    public List<Lotto> lottos;

    public void buyLottos(int lottoCount) {
        ResultView.printLottoCount(lottoCount);
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = lottoGenerate();
            lottos.add(lotto);
            ResultView.printLottoNumber(lotto.getNumbers());
        }
    }

    private Lotto lottoGenerate() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public Lotto createWinningLotto(List<String> winningNumbers) {
        List<Integer> numbers = winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public Map<Rank, Integer> calculateResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        Map<Rank, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            Rank rank = getRank(lotto, winningLotto, bonusNumber);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }

    private Rank getRank(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int countOfMatch = getCountOfMatch(lotto, winningLotto);
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(countOfMatch, matchBonus);
    }

    private int getCountOfMatch(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }
}
