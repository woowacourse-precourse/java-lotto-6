package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.dto.LottoResultDto;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private final LottoView lottoView = new LottoView();

    public void start() {
        LottoResultDto result = processLottoGame();
        printLottoResult(result);
    }

    private LottoResultDto processLottoGame() {
        LottoList publishedLottoList = buyLottos();
        Lotto winningLotto = lottoView.getWinningLotto();
        LottoNumber bonusNumber = lottoView.getBonusNumberWithDuplicationCheck(winningLotto);
        return LottoResultDto.Of(publishedLottoList, winningLotto, bonusNumber);
    }

    private LottoList buyLottos() {
        Money lottoPurchasingCost = lottoView.getLottoPurchasingCost();
        int buyingLottoCount = lottoPurchasingCost.getLottoCount();
        LottoList publishedLottoList = LottoList.generateRandomLottoListSizeWith(buyingLottoCount);
        printPublishedLottos(buyingLottoCount, publishedLottoList.getLottos());
        return publishedLottoList;
    }

    private void printLottoResult(LottoResultDto lottoResultDto) {
        printStatistics(lottoResultDto);
        printRateOfReturn(lottoResultDto);
    }

    private void printStatistics(LottoResultDto lottoResultDto) {
        lottoView.printWinningStatistics(lottoService.totalWinnings(lottoResultDto));
    }

    private void printPublishedLottos(int lottoCount, List<Lotto> lottos) {
        lottoView.printPublishedLottos(lottoCount, lottos);
    }

    private void printRateOfReturn(LottoResultDto lottoResultDto) {
        lottoView.printRateOfReturn(calculateRateOfReturn(lottoResultDto));
    }

    private double calculateRateOfReturn(LottoResultDto lottoResultDto) {
        return lottoService.calculateRateOfReturn(lottoResultDto);
    }

}
