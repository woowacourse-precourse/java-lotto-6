package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoCollector;
import lotto.domain.WinningNumber;
import lotto.enums.Rank;

public class WinningServiceImpl implements WinningService {

    private final WinningNumber winningNumber;

    public WinningServiceImpl() {
        this.winningNumber = new WinningNumber();
    }

    @Override
    public void createWinningLotto(List<Integer> winningNumbers) {
        winningNumber.createWinningNumber(winningNumbers);
    }

    @Override
    public void createBonusNumber(int bonusNumber) {
        winningNumber.creatBonusNumber(bonusNumber);
    }

    @Override
    public String calculateWinningDetail(LottoCollector lottoCollector) {
        List<Lotto> publishedLotto = lottoCollector.getPublishedLotto();

        winningNumber.checkMatchWinning(publishedLotto);
        return getWinningDetail();
    }

    private String getWinningDetail() {
        StringBuilder sb = new StringBuilder();
        Rank[] ranks = Rank.values();

        Arrays.stream(ranks).forEach(rank -> sb.append(rank.getWinningDetail()).append("\n"));

        return sb.toString();
    }
}
