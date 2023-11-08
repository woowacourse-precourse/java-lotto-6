package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class LottoGame {

    private static final int PRICE = 1000;
    private final int inputNumber;

    public LottoGame(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public int getNumberOfGames() {
        return inputNumber / PRICE;
    }

    private Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<Lotto> createLottoList(int count) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoList.add(createLotto());
        }

        return lottoList;
    }

    public WinningLotto createdWinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {
        return new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);
    }

    public Map<Result, Integer> getResultCount(List<Lotto> lottoList, WinningLotto winningLotto) {
        Map<Result, Integer> resultCount = new HashMap<>();
        for (Lotto lotto : lottoList) {
            int matchCount = winningLotto.matchCount(lotto);
            boolean isBonus = winningLotto.isBonus(lotto);
            Result result = Result.valueOf(matchCount, isBonus);
            resultCount.put(result, resultCount.getOrDefault(result, 0) + 1);
        }
        return resultCount;
    }
}
