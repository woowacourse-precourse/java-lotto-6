package lotto.ui;

import lotto.event.EventListener;
import lotto.repository.LottoRepository;

public class MainWindow {


    public void open() {
        new MainComponents(
                new InputView(),
                new OutputView(),
                new EventListener(new LottoRepository())
        ).renderAll();
    }
}
