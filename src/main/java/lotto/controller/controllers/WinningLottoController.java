package lotto.controller.controllers;

import lotto.controller.ErrorHandler;
import lotto.domain.WinningLotto;
import lotto.dto.InputDto;
import lotto.dto.OutputDto;
import lotto.dto.WinningLottoInputDto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ParameterConfig;

import java.util.Map;

public final class WinningLottoController implements Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public WinningLottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process(Map<String, InputDto> inputs,
                        Map<String, OutputDto> outputs) {
        inputs.put(ParameterConfig.WINNING_LOTTO, new WinningLottoInputDto());
        inputLottoNumbers(inputs, outputs);
        inputBonusNumber(inputs, outputs);
    }

    private void inputLottoNumbers(Map<String, InputDto> inputs,
                                   Map<String, OutputDto> outputs) {
        ErrorHandler.tryUntilNoError(() -> viewText(inputs, outputs, ParameterConfig.WINNING_LOTTO_NUMBERS));
    }

    private void viewText(Map<String, InputDto> inputs,
                          Map<String, OutputDto> outputs,
                          String param) {
        outputs.put(param, null);
        outputView.view(outputs);
        inputView.read(inputs);

        outputs.remove(param);
    }

    private void inputBonusNumber(Map<String, InputDto> inputs,
                                  Map<String, OutputDto> outputs) {
        ErrorHandler.tryUntilNoError(() -> runViewByBonusNumber(inputs, outputs));
    }

    private void runViewByBonusNumber(Map<String, InputDto> inputs,
                                      Map<String, OutputDto> outputs) {
        viewText(inputs, outputs, ParameterConfig.BONUS_NUMBER);
        validateDuplication(inputs);
    }

    private void validateDuplication(Map<String, InputDto> inputs) {
        WinningLottoInputDto dto = (WinningLottoInputDto) inputs.get(ParameterConfig.WINNING_LOTTO);
        new WinningLotto(dto.getLotto(), dto.getBonus());
    }
}
