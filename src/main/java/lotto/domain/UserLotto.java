package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserLotto {
    private static final int RANK_FIRST_PLACE = 0;
    private static final int RANK_LAST_PLACE = 5;
    private List<Lotto> userLottos;
    private int lottoCount;
    private Map<Rank, Integer> result = new LinkedHashMap<>();
    private int revenue = 0;

    public UserLotto(int lottoAmount) {
        this.lottoCount = Lotto.getLottoCount(lottoAmount);
        createLotto(lottoCount);
    }

    private void createLotto(int lottoCount) {
        userLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = LottoGenerator.generateNumbers();
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
            revenue += rank.getWinnings();
        }
        result.remove(Rank.NOTHING);
    }

    public float getRateOfReturn(int purchaseAmount) {
        return (float) revenue / purchaseAmount * 100;
    }
}
