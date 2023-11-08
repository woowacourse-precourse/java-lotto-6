package lotto.controller;

import lotto.controller.controllers.Controller;
import lotto.domain.ProgramFlow;
import lotto.dto.InputDto;
import lotto.dto.OutputDto;

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
        Map<String, InputDto> inputs = new HashMap<>();
        Map<String, OutputDto> outputs = new HashMap<>();

        processBuyLotto(inputs, outputs);
        processWinningLotto(inputs, outputs);
        processLottoResult(inputs, outputs);
    }

    private void processBuyLotto(Map<String, InputDto> inputs,
                                 Map<String, OutputDto> outputs) {
        controllers.get(BUY_LOTTO).process(inputs, outputs);
    }

    private void processWinningLotto(Map<String, InputDto> inputs,
                                     Map<String, OutputDto> outputs) {
        controllers.get(SET_WINNING).process(inputs, outputs);
    }

    private void processLottoResult(Map<String, InputDto> inputs,
                                    Map<String, OutputDto> outputs) {
        controllers.get(RANK_RESULT).process(inputs, outputs);
    }
}
