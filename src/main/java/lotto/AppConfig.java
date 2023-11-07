package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import lotto.controller.LottoController;
import lotto.domain.Lottos;
import lotto.domain.WinningList;
import lotto.service.CalculationService;
import lotto.service.WinningService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final Lottos lottos = new Lottos(new ArrayList<>());

    private final WinningList winningList = new WinningList(new HashMap<>());
    private final WinningService winningService = new WinningService(winningList);

    private final CalculationService calculationService = new CalculationService();

    public LottoController setLottoController() {
        return new LottoController(inputView, outputView, lottos, winningList, winningService, calculationService);
    }
}
