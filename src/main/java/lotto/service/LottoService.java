package lotto.service;

import lotto.model.WinningStatistics;
import lotto.util.LottoGenerator;

import java.util.List;

public class LottoService {

    private final List<List<Integer>> lottoTickets;
    private final WinningStatistics winningStatistics;

    public LottoService(List<List<Integer>> lottoTickets, WinningStatistics winningStatistics) {
        this.lottoTickets = lottoTickets;
        this.winningStatistics = winningStatistics;
    }

    public void getLottoList(int lottoCount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lotto = lottoGenerator.generateLotto();
            lottoTickets.add(lotto);
        }
    }
}
