package lotto;

import lotto.controller.LottoController;
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
        return new LottoController(inputView(), outputView());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
