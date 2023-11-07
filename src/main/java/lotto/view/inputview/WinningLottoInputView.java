package lotto.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.dto.DTO;
import lotto.dto.WinningLottoDTO;
import lotto.view.InputView;
import lotto.view.ParameterConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class WinningLottoInputView implements InputView {

    private static final String DELIMITER = ",";

    @Override
    public void read(Map<String, ? super DTO.Input> parameter) {
        WinningLottoDTO input = (WinningLottoDTO) parameter.get(ParameterConfig.WINNING_LOTTO);
        if (input.getLotto() == null) {
            inputLottoNumbers(input);
            return;
        }
        input.setBonus(inputBonusNumber(input));
    }

    private void inputLottoNumbers(WinningLottoDTO dto) {
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

    private Integer inputBonusNumber(WinningLottoDTO dto) {
        if (dto.getBonus() != null) {
            return dto.getBonus();
        }
        String input = Console.readLine();
        InputValidator.validateIsNumber(input);
        return Integer.parseInt(input);
    }
}
