package lotto;

import static lotto.Util.generateNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserLotto {
    private static final int RANK_FIRST_PLACE = 0;
    private static final int RANK_LAST_PLACE = 5;

    private List<Lotto> userLottos;
    private Map<Rank, Integer> result = new LinkedHashMap<>();

    public UserLotto(int lottoCount) {
        createLotto(lottoCount);
    }

    private void createLotto(int lottoCount) {
        userLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = generateNumbers();
            Collections.sort(lottoNumbers);
            userLottos.add(new Lotto(lottoNumbers));
        }
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }

    public Map<Rank, Integer> checkWinning(WinningLotto winningLotto) {
        initResult();
        getWinningResult(winningLotto);

        return result;
    }

    private void initResult() {
        for (int i = RANK_LAST_PLACE; i >= RANK_FIRST_PLACE; i--) {
            result.put(Rank.values()[i], 0);
        }
    }

    private void getWinningResult(WinningLotto winningLotto) {
        for (Lotto lotto : userLottos) {
            Rank rank = lotto.getRankResult(winningLotto);
            Integer count = result.get(rank);
            result.put(rank, count + 1);
        }
    }
}
