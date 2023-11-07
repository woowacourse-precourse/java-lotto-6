package lotto.controller;

import lotto.dto.DTO;

import java.util.HashMap;
import java.util.Map;

public final class MainController {
    private final Map<String, Controller> controllers = Map.ofEntries(
            Map.entry("lottoBuy", ControllerConfig.createLottoBuyController()),
            Map.entry("winningLotto", ControllerConfig.createWinningLottoController()),
            Map.entry("lottoResult", ControllerConfig.createLottoResultController())
    );

    public void run() {
        Map<String, DTO.Input> inputs = new HashMap<>();
        Map<String, DTO.Output> outputs = new HashMap<>();

        processBuyLotto(inputs, outputs);
        processWinningLotto(inputs, outputs);
        processLottoResult(inputs, outputs);
    }

    private void processBuyLotto(Map<String, DTO.Input> inputs, Map<String, DTO.Output> outputs) {
        controllers.get("lottoBuy").process(inputs, outputs);
    }

    private void processWinningLotto(Map<String, DTO.Input> inputs, Map<String, DTO.Output> outputs) {
        controllers.get("winningLotto").process(inputs, outputs);
    }

    private void processLottoResult(Map<String, DTO.Input> inputs, Map<String, DTO.Output> outputs) {
        controllers.get("lottoResult").process(inputs, outputs);
    }
}
