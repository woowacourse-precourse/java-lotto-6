package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.domain.lottoGenerateMethod.LottoAutoGenerateMethod;
import lotto.domain.lottoGenerateMethod.LottoTicketsGenerator;
import lotto.domain.lottoResult.LottoResultBoard;
import lotto.domain.lottoResult.LottoResultGenerator;
import lotto.domain.lottoTicket.BonusNumber;
import lotto.domain.lottoTicket.Lotto;
import lotto.domain.lottoTicket.LottoTickets;
import lotto.domain.lottoTicket.WinningLotto;
import lotto.utils.LottoParser;
import lotto.utils.NumberParser;

public class LottoGameService {

    public PurchaseAmount generatePurchaseAmount(final String inputValue) {
        return NumberParser.parsePurchaseAmount(inputValue);
    }

    public LottoTickets generateLottoTickets(final int lottoTicketQuantity) {
        LottoTicketsGenerator instance = LottoTicketsGenerator.getInstance();
        return instance.generateLottoTickets(lottoTicketQuantity, new LottoAutoGenerateMethod());
    }

    public Lotto generateWinningNumbers(final String inputValue) {
        return LottoParser.parseLotto(inputValue);
    }

    public BonusNumber generateBonusNumber(final String inputValue) {
        return NumberParser.parseBonusNumber(inputValue);
    }

    public WinningLotto generateWinningLotto(final Lotto winningNumbers, final BonusNumber bonusNumber) {
        return WinningLotto.of(winningNumbers, bonusNumber);
    }

    public LottoResultBoard generateLottoResultStatistics(
            final LottoTickets lottoTickets,
            final WinningLotto winningLotto
    ) {
        LottoResultGenerator instance = LottoResultGenerator.getInstance();
        return instance.generateLottoResultBoard(lottoTickets, winningLotto);
    }
}
