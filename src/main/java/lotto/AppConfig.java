package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.util.StringFormatter;
import lotto.util.converter.ConverterHolder;
import lotto.util.converter.StringToLottoMoneyConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class AppConfig {

    public LottoController setSystem() {
        ConverterHolder.setConverters(List.of(
                new StringToLottoMoneyConverter()
        ));
        return new LottoController(inputView(), outputView(), lottoService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView(new StringFormatter());
    }

    private LottoService lottoService() {
        return new LottoService();
    }
}
