package lotto.controller;

import lotto.controller.controllers.Controller;
import lotto.domain.ProgramFlow;
import lotto.dto.Dto;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.ProgramFlow.*;

public final class MainController {
    private final Map<ProgramFlow, Controller> controllers = Map.ofEntries(
            Map.entry(BUY_LOTTO, ControllerConfig.createLottoBuyController()),
            Map.entry(SET_WINNING, ControllerConfig.createWinningLottoController()),
            Map.entry(RANK_RESULT, ControllerConfig.createLottoResultController())
    );

    public void run() {
        Map<String, Dto.Input> inputs = new HashMap<>();
        Map<String, Dto.Output> outputs = new HashMap<>();

        processBuyLotto(inputs, outputs);
        processWinningLotto(inputs, outputs);
        processLottoResult(inputs, outputs);
    }

    private void processBuyLotto(Map<String, Dto.Input> inputs, Map<String, Dto.Output> outputs) {
        controllers.get(BUY_LOTTO).process(inputs, outputs);
    }

    private void processWinningLotto(Map<String, Dto.Input> inputs, Map<String, Dto.Output> outputs) {
        controllers.get(SET_WINNING).process(inputs, outputs);
    }

    private void processLottoResult(Map<String, Dto.Input> inputs, Map<String, Dto.Output> outputs) {
        controllers.get(RANK_RESULT).process(inputs, outputs);
    }
}
