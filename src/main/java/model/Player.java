package model;

import config.GameConfig;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private final Money money;
    private final List<Lotto> lottoBundle = new ArrayList<>();
    private Winning winning;
    private Bonus bonus;
    private int winningMoney;

    public Player(Money money) {
        this.money = money;
    }

    public void buyLotto() {
        int lottoNumber = money.getLottoNumber();
        for (int trial = 0; trial < lottoNumber; trial++) {
            lottoBundle.add(new Lotto(
                    Randoms.pickUniqueNumbersInRange(GameConfig.MIN_LOTTO, GameConfig.MAX_LOTTO, GameConfig.LOTTO_NUMBER)));
        }
    }

    public List<String> checkLotto() {
        List<String> LottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottoBundle) {
            LottoNumbers.add(lotto.getLotto());
        }
        return LottoNumbers;
    }

    public void announceWinning(Winning winning, Bonus bonus) {
        this.winning = winning;
        this.bonus = bonus;
        this.winningMoney = 0;
    }

    public List<Integer> checkWinning() {
        List<Integer> winningRank = new ArrayList<>(Collections.nCopies(GameConfig.WINNING.values().length, 0));
        for (Lotto lotto : lottoBundle) {
            int rank = lotto.getResult(winning, bonus);
            if (rank >= GameConfig.WINNING.valueOfMaxMatch().getRank() && rank <= GameConfig.WINNING.valueOfMinMatch().getRank()) {
                winningMoney += GameConfig.WINNING.valueOfRank(rank).getPrice();
                winningRank.set(rank - 1, winningRank.get(rank - 1) + 1);
            }
        }
        return winningRank;
    }

    public String calculateYield() {
        return money.getYield(winningMoney);
    }
}
