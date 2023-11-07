package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.common.config.LottoConfig;
import lotto.common.log.Logger;
import lotto.common.converter.StringConverter;
import lotto.controller.dto.PurchaseResultDto;
import lotto.controller.dto.StatisticDto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottogenerator.LottoGenerator;
import lotto.domain.money.Money;
import lotto.domain.statistic.Statistic;
import lotto.domain.winninglotto.WinningLotto;
import lotto.service.LottoService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {

    private static final String DELIMITER = ",";

    private final LottoGenerator lottoGenerator;
    private final LottoService lottoService;

    public LottoController(LottoConfig config) {
        this.lottoGenerator = config.lottoGenerator();
        this.lottoService = LottoService.init(lottoGenerator);
    }

    public void play() {
        List<Lotto> purchaseLottos = executeWithExceptionHandle(this::purchaseLottos);

        List<Integer> lottoNumbers = executeWithExceptionHandle(this::inputLottoNumbers);
        int bonusNumber = executeWithExceptionHandle(this::inputBonusNumber);
        WinningLotto winningLotto = lottoService.createWinningLotto(lottoNumbers, bonusNumber);

        compileStatistics(winningLotto, purchaseLottos);
    }

    private List<Lotto> purchaseLottos() {
        Money money = inputMoney();
        List<Lotto> lottos = lottoService.purchaseLotto(money);
        OutputView.printPurchaseResult(PurchaseResultDto.from(lottos));

        return lottos;
    }

    private Money inputMoney() {
        String input = InputView.inputPurchaseAmount();
        return lottoService.createMoney(StringConverter.toInt(input));
    }

    private List<Integer> inputLottoNumbers() {
        String input = InputView.inputLottoNumbers();
        return StringConverter.toIntListWithSplit(input, DELIMITER);
    }

    private int inputBonusNumber() {
        String input = InputView.inputBonusNumbers();
        return StringConverter.toInt(input);
    }

    private void compileStatistics(WinningLotto winningLotto, List<Lotto> purchaseLottos) {
        Statistic statistic = lottoService.judgeAll(winningLotto, purchaseLottos);
        double earningRate = lottoService.calculateEarningRate(statistic);

        OutputView.printStatistic(StatisticDto.of(statistic, earningRate));
    }

    private static <T> T executeWithExceptionHandle(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                Logger.log(e.getMessage());
            }
        }
    }
}
