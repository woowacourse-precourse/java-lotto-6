package lotto.controller;

import lotto.domain.ProgramFlow;
import lotto.dto.DTO;

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
        Map<String, DTO.Input> inputs = new HashMap<>();
        Map<String, DTO.Output> outputs = new HashMap<>();

        processBuyLotto(inputs, outputs);
        processWinningLotto(inputs, outputs);
        processLottoResult(inputs, outputs);
    }

    private void processBuyLotto(Map<String, DTO.Input> inputs, Map<String, DTO.Output> outputs) {
        controllers.get(BUY_LOTTO).process(inputs, outputs);
    }

    private void processWinningLotto(Map<String, DTO.Input> inputs, Map<String, DTO.Output> outputs) {
        controllers.get(SET_WINNING).process(inputs, outputs);
    }

    private void processLottoResult(Map<String, DTO.Input> inputs, Map<String, DTO.Output> outputs) {
        controllers.get(RANK_RESULT).process(inputs, outputs);
    }
}
