package lotto.controller;

import lotto.domain.WinningLotto;
import lotto.dto.DTO;
import lotto.dto.WinningLottoDTO;
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
    public void process(Map<String, ? super DTO.Input> inputs, Map<String, ? super DTO.Output> outputs) {
        inputs.put(ParameterConfig.WINNING_LOTTO, new WinningLottoDTO());
        inputLottoNumbers(inputs, outputs);
        inputBonusNumber(inputs, outputs);
    }

    private void inputLottoNumbers(Map<String, ? super DTO.Input> inputs, Map<String, ? super DTO.Output> outputs) {
        try {
            viewText(inputs, outputs, ParameterConfig.WINNING_LOTTO_NUMBERS);

        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            inputLottoNumbers(inputs, outputs);
        }
    }

    private void inputBonusNumber(Map<String, ? super DTO.Input> inputDto,
                                  Map<String, ? super DTO.Output> outputDto) {
        try {
            outputDto.put(ParameterConfig.BONUS_NUMBER, null);
            outputView.view(outputDto);
            inputView.read(inputDto);

            WinningLottoDTO dto = (WinningLottoDTO) inputDto.get(ParameterConfig.WINNING_LOTTO);
            outputDto.remove(ParameterConfig.BONUS_NUMBER);
            new WinningLotto(dto.getLotto(), dto.getBonus());
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            WinningLottoDTO dto = (WinningLottoDTO) inputDto.get(ParameterConfig.WINNING_LOTTO);
            dto.setBonus(null);
            inputBonusNumber(inputDto, outputDto);
        }
    }
}
