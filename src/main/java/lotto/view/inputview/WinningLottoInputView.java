package lotto.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.dto.InputDto;
import lotto.dto.WinningLottoInputDto;
import lotto.view.InputView;
import lotto.view.ParameterConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class WinningLottoInputView implements InputView {

    private static final String DELIMITER = ",";

    @Override
    public void read(Map<String, InputDto> inputs) {
        WinningLottoInputDto input = (WinningLottoInputDto) inputs.get(ParameterConfig.WINNING_LOTTO);
        if (input.getLotto() == null) {
            inputLottoNumbers(input);
            return;
        }
        inputBonusNumber(input);
    }

    private void inputLottoNumbers(WinningLottoInputDto dto) {
        if (dto.getLotto() != null) {
            return;
        }
        String input = Console.readLine();

        for (String split : input.split(DELIMITER)) {
            InputValidator.validateIsNumber(split.trim());
            InputValidator.validateIsEmptyValue(split.trim());
        }
        dto.setLotto(convertToLotto(input));
    }

    private Lotto convertToLotto(String input) {
        List<Integer> numbers = Arrays.stream(input.split(DELIMITER))
                .map(e -> Integer.parseInt(e.trim()))
                .toList();

        return new Lotto(numbers);
    }

    private void inputBonusNumber(WinningLottoInputDto dto) {
        String input = Console.readLine();
        InputValidator.validateIsNumber(input);
        dto.setBonus(Integer.parseInt(input));
    }
}
