package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    List<Lotto> lottoes;

    public User () {
        lottoes = new ArrayList<>();
    }

    public void pickLottoNumber() {
        List<Integer> sortedNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(sortedNumbers);
        addLotto(sortedNumbers);
    }

    private void addLotto(List<Integer> numbers) {
        lottoes.add(new Lotto(numbers));
    }

    public Map<Integer, Integer> checkLottoesRanking (WinningLotto winningLotto) {
        Map<Integer, Integer> lottoesResult = new HashMap<>();

        for (Lotto currentLotto : lottoes) {
            addLottoResult(lottoesResult, winningLotto.checkLottoRanking(currentLotto));
        }
        return lottoesResult;
    }

    private void addLottoResult (Map<Integer, Integer> lottoesResult, Integer ranking) {
        if (ranking == 0)
            return ;
        if (lottoesResult.containsKey(ranking)) {
            int value = lottoesResult.get(ranking);
            lottoesResult.put(ranking, value + 1);
            return ;
        }
        lottoesResult.put(ranking, 1);
    }
}
