package lotto.service;

import lotto.constant.Ranking;
import lotto.dto.LottoResultDto;
import lotto.model.CompareResult;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTickets;
import lotto.model.WinningLotto;

public class ComparingLottoService {
    public LottoResultDto getLottoResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lottoTicket : lottoTickets.getLottoTickets()) {
            CompareResult compareResult = compare(lottoTicket, winningLotto);

            lottoResult.updateResult(getRanking(compareResult));
        }

        return new LottoResultDto(lottoResult, lottoTickets.getQuantity());
    }

    private CompareResult compare(Lotto lottoTicket, WinningLotto winningLotto) {
        CompareResult compareResult = new CompareResult();

        for (int number : winningLotto.getWinningNumbers()) {
            if (lottoTicket.contains(number)) {
                compareResult.updateWinningNumberMatchCount();
            }

            compareResult.updateBonusMatch(lottoTicket.contains(winningLotto.getBonusNumber()));
        }

        return compareResult;
    }

    private Ranking getRanking(CompareResult compareResult) {
        return Ranking.findByCompareResult(compareResult);
    }
}
