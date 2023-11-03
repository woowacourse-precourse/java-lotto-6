package lotto.util;

import lotto.domain.constants.CharacterSetting;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private List<String> inputToStringList() {
        outputView.printInputWinningNumbersMessage();

        String playerInput = inputView.getWinningNumbersInput();
        return Arrays.stream(playerInput.split(CharacterSetting.INPUT_DELIMITER.getCharacter())).toList();
    }

    public List<Integer> stringListToNumberList() {
        return inputToStringList().stream()
                .mapToInt(Integer::parseInt)
                .boxed().toList();
    }

    public int inputToNumber() {
        outputView.printInputBonusNumberMessage();

        String playerInput = inputView.getBonusNumberInput();
        return Integer.parseInt(playerInput);
    }
}
