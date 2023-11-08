package lotto.controller;

import lotto.domain.WinningLottoTable;
import lotto.dto.BuyLottoDto;
import lotto.dto.LottoBundleDto;
import lotto.dto.LottoInfoDto;
import lotto.dto.LottoRanksDto;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, OutputView outputView) {
        this.lottoService = lottoService;
        this.outputView = outputView;
    }

    public BuyLottoDto buyLotteries(long fee) {
        BuyLottoDto buyLottoDto = lottoService.buy(fee);
        outputView.printLottoCnt(buyLottoDto.getLottoCnt());
        outputView.printLotteries(LottoBundleDto.valueOf(buyLottoDto.getLottoBundle()));
        return buyLottoDto;
    }

    public WinningLottoTable informLottoResult(LottoInfoDto lottoInfoDto) {
        WinningLottoTable winningLottoTable = lottoService.solveLottoResult(lottoInfoDto);
        outputView.printWinnerStatisticsMent();
        outputView.printLottoResult(winningLottoTable);
        return winningLottoTable;
    }

    public void informYield(LottoRanksDto lottoRanksDto) {
        outputView.printTotalYield(
                lottoService.calculate(lottoRanksDto.getWinningLottoTable(), lottoRanksDto.getLottoCnt()));
    }
}
