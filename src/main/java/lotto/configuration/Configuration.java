package lotto.configuration;

import io.output.ConsoleWriter;
import lotto.controller.LottoController;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoStore;
import lotto.domain.lotto.RandomLottoGenerator;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

/**
 * 한 번에 LottoController가 의존하는 모든 객체를 생성 및 주입하여 반환합니다..
 */
public final class Configuration {

    /**
     * 외부 생성자 접근을 제한합니다.
     */
    private Configuration() {
    }

    /**
     * 기본 생성자 제한이 되었기 때문에 반드시 해당 메소드로 호출해야 하며,
     * <p>
     * 모든 의존성이 자동으로 주입됩니다.
     */
    public static LottoController createLottoController() {

        final InputView inputView = new InputView(new ConsoleWriter());
        final OutputView outputView = new OutputView(new ConsoleWriter());
        final LottoGenerator lottoGenerator = new RandomLottoGenerator();
        final LottoStore lottoStore = new LottoStore(lottoGenerator);
        final LottoRepository lottoRepository = new LottoRepository();

        final LottoService lottoService = new LottoService(
                lottoStore,
                lottoRepository
        );

        return new LottoController(inputView, outputView, lottoService);
    }

}
