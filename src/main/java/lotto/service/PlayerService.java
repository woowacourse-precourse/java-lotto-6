package lotto.service;

import lotto.domain.CorrectCount;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.WinningNumbers;

public class PlayerService {

    private Player player;
    private LottoGenerator lottoGenerator;
    private WinningLottoCalculator winningLottoCalculator;

    public PlayerService(Player player, LottoGenerator lottoGenerator, WinningLottoCalculator winningLottoCalculator) {
        this.player = player;
        this.lottoGenerator = lottoGenerator;
        this.winningLottoCalculator = winningLottoCalculator;
    }

    public void buy(int lottoCount) {
        for (int count = 0; count < lottoCount; count++) {
            player.addLotto(new Lotto(lottoGenerator.generate()));
        }
    }

    public void check(WinningNumbers winningNumbers) {

        for (Lotto lotto : player.getLottoPapers()) {
            CorrectCount correctCount = winningLottoCalculator.calculate(winningNumbers,lotto);
            player.setLottoCorrectCount(lotto,correctCount);
        }
    }
}
