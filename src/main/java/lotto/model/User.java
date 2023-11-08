package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final List<Lotto> lottoes;

    public User () {
        lottoes = new ArrayList<>();
    }

    public void pickLottoNumber() {
        List<Integer> sortedNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LottoGameSettingConstValue.MIN_LOTTO_NUMBER.getValue()
                        , LottoGameSettingConstValue.MAX_LOTTO_NUMBER.getValue()
                        , LottoGameSettingConstValue.LOTTO_NUMBER_SIZE.getValue()));
        Collections.sort(sortedNumbers);
        addLotto(sortedNumbers);
    }

    private void addLotto(List<Integer> numbers) {
        lottoes.add(new Lotto(numbers));
    }

    public Map<Integer, Integer> checkLottoesRanking (WinningLotto winningLotto) {
        Map<Integer, Integer> lottoesResult = lottoesResultInitialize();

        for (Lotto currentLotto : lottoes) {
            addLottoResult(lottoesResult, winningLotto.checkLottoRanking(currentLotto));
        }
        return lottoesResult;
    }

    private Map<Integer, Integer> lottoesResultInitialize() {
        Map<Integer, Integer> lottoesResult = new HashMap<>();

        for (int lottoRank = LottoGameSettingConstValue.FIRST_RANK.getValue();
             lottoRank <= LottoGameSettingConstValue.LAST_RANK.getValue(); lottoRank++) {
            lottoesResult.put(lottoRank, 0);
        }
        return lottoesResult;
    }

    private void addLottoResult (Map<Integer, Integer> lottoesResult, Integer ranking) {
        if (ranking == 0)
            return ;
        int value = lottoesResult.get(ranking);
        lottoesResult.put(ranking, value + 1);
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }
}
