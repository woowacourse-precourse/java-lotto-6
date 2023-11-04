package lotto.configuration;

import component.Composer;
import io.input.ConsoleWriter;
import lotto.controller.LottoController;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoStore;
import lotto.domain.lotto.RandomLottoGenerator;
import lotto.mapper.LottoMapper;
import lotto.mapper.WalletMapper;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class Configuration {

    private Configuration() {
    }

    public static LottoController createLottoController() {

        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView(
                new ConsoleWriter(),
                new Composer()
        );
        final LottoGenerator lottoGenerator = new RandomLottoGenerator();
        final LottoStore lottoStore = new LottoStore(lottoGenerator);
        final LottoRepository lottoRepository = new LottoRepository();
        final WalletMapper walletMapper = new WalletMapper();
        final LottoMapper lottoMapper = new LottoMapper();

        final LottoService lottoService = new LottoService(
                lottoStore,
                lottoRepository,
                walletMapper,
                lottoMapper
        );

        return new LottoController(inputView, outputView, lottoService);
    }

}
