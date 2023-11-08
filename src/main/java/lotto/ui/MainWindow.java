package lotto.ui;

import lotto.event.EventListener;
import lotto.repository.LottoRepository;

public class MainWindow {

    public void open() {
        final var mainComponents = new MainComponents(
                new InputView(),
                new OutputView(),
                new EventListener(new LottoRepository())
        );
        mainComponents.renderAll();
    }

}
