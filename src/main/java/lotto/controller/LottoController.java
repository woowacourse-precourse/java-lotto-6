package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Deposit;
import lotto.model.LottoTicket;
import lotto.model.WinningNumbers;
import lotto.service.LottoReader;
import lotto.utils.PrizeType;

import java.util.List;

import static lotto.controller.LottoDrawingMachine.drawBonusNumber;
import static lotto.controller.LottoDrawingMachine.drawWinningNumbers;
import static lotto.controller.LottoSeller.makeDeposit;
import static lotto.controller.LottoSeller.purchaseLottoTicket;
import static lotto.controller.LottoStatisticMachine.drawStatistic;

public class LottoController {
    public void run() {
        Deposit deposit = makeDeposit();
        LottoTicket lottoTicket = purchaseLottoTicket(deposit);

        WinningNumbers winningNumbers = drawWinningNumbers();
        BonusNumber bonusNumber = drawBonusNumber(winningNumbers.getWinningNumbers());

        List<PrizeType> lottoResult = LottoReader.read(
                winningNumbers.getWinningNumbers(),
                bonusNumber.getBonusNumber(),
                lottoTicket.getLottos()
        );
        drawStatistic(lottoResult, deposit);
    }
}
