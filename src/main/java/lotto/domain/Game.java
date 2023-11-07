package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private final GameView gameView;
    private final Player player;
    private final Map<Lotto, Float> lottos;
    private Float lottoReturns;

    public Game() {
        this.gameView = new GameView();
        this.player = new Player();
        this.lottos = new HashMap<>();
        this.lottoReturns = 0.0f;
    }

    public void play() {
        gameView.inputLottoPurchaseAmount(player);
        issueLottos();
        gameView.printLottos(lottos);
        gameView.inputLottoWinningNumbers(player);
        gameView.inputLottoBonusNumber(player);
        confirmLottoWin();
        calculateLottoReturns();
        gameView.printLottoWinAndLottoReturns(lottoReturns);
    }

    private void issueLottos() {
        int lottoCount = player.getPurchaseLottoCount();

        for (int i = 0; i < lottoCount; i++) {
            lottos.put(new Lotto(getRandomNumbers()), 0.0f);
        }
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.MINIMUM_NUMBER, Lotto.MAXIMUM_NUMBER, Lotto.NUMBERS_SIZE);
    }

    private void confirmLottoWin() {
        for (Lotto lotto : lottos.keySet()) {
            compareWinningNumbers(lotto);
            compareBonusNumber(lotto);
            calculateLottoRankingCount(lotto);
        }
    }

    private void calculateLottoRankingCount(Lotto lotto) {
        float lottoScore = lottos.get(lotto);
        if (lottoScore >= 3.0f) {
            LottoRanking.valueOfScore(lottos.get(lotto)).plusCount();
        }
    }

    private void compareWinningNumbers(Lotto lotto) {
        for (int winningNumber : player.getWinningNumbers()) {
            if (lotto.containNumber(winningNumber)) {
                lottos.replace(lotto, lottos.get(lotto) + 1.0f);
            }
        }
    }

    private void compareBonusNumber(Lotto lotto) {
        if (lotto.containNumber(player.getBonusNumber())) {
            lottos.replace(lotto, lottos.get(lotto) + 0.5f);
        }
    }

    private void calculateLottoReturns() {
        int totalPrizeMoney = calculateTotalPrizeMoney();
        lottoReturns = (float) totalPrizeMoney / player.getPurchaseAmount() * 100.0f;
    }

    private Integer calculateTotalPrizeMoney() {
        int totalPrizeMoney = 0;

        for (LottoRanking lottoRanking : LottoRanking.values()) {
            totalPrizeMoney += lottoRanking.getPrizeMoney() * lottoRanking.getCount();
        }

        return totalPrizeMoney;
    }
}
