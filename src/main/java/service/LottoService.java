package service;

import domain.Lotto;
import domain.WinningLotto;
import support.LottoComparator;
import support.RandomLotto;
import support.Rate;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final RandomLotto randomLotto = new RandomLotto();

    private List<Rate> rate = new ArrayList<>();
    public void execute(WinningLotto winningLotto, int lottoTimes) {

        Lotto winning = new Lotto(winningLotto.getWinning());
        LottoComparator lottoComparator = new LottoComparator(winning, winningLotto.getBonus());

        for (int i = 0; i < lottoTimes; i++) {
            Lotto lotto = new Lotto(randomLotto.getRandomLotto());
            rate.add(lottoComparator.compareLotto(lotto));
        }


    }

}
