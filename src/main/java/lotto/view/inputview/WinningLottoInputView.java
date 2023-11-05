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
import java.util.function.Consumer;

public final class WinningLottoInputView implements InputView {

    private static final String DELIMITER = ",";
    private final Map<String, Consumer<WinningLottoDTO>> methods = Map.ofEntries(
            Map.entry(ParameterConfig.WINNING_LOTTO_NUMBERS, this::inputLottoNumbers),
            Map.entry(ParameterConfig.BONUS_NUMBER, this::inputBonusNumber)
    );

    @Override
    public void read(Map<String, ? extends DTO.Input> parameter) {
        parameter.forEach(this::runMethod);
    }

    private void runMethod(String key, DTO.Input value) {
        WinningLottoDTO dto = (WinningLottoDTO) value;

        if (methods.containsKey(key)) {
            methods.get(key).accept(dto);
        }
    }

    private void inputLottoNumbers(WinningLottoDTO dto) {
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

    private void inputBonusNumber(WinningLottoDTO dto) {
        String input = Console.readLine();
        InputValidator.validateIsNumber(input);
        dto.setBonus(Integer.parseInt(input));
    }
}
