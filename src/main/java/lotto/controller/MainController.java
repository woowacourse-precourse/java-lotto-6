package lotto.controller;

import lotto.dto.DTO;

import java.util.HashMap;
import java.util.Map;

public final class MainController {
    private final Map<String, Controller> controllers = Map.ofEntries(
            Map.entry("lottoBuy", ControllerConfig.createLottoBuyController())
    );

    public void run() {
        Map<String, DTO.Input> inputs = new HashMap<>();
        Map<String, DTO.Output> outputs = new HashMap<>();
        getLottoBuy(inputs, outputs);
    }

    private void getLottoBuy(Map<String, DTO.Input> inputs, Map<String, DTO.Output> outputs) {
        controllers.get("lottoBuy").process(inputs, outputs);
    }
}
