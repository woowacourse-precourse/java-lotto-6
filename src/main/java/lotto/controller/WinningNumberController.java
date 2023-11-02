package lotto.controller;

import lotto.domain.WinningNumber;
import lotto.domain.constants.CharacterSetting;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
public class WinningNumberController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private List<String> inputToStringList() {
        outputView.printInputWinningNumbersMessage();

        String playerInput = inputView.getWinningNumbersInput();
        return Arrays.stream(playerInput.split(CharacterSetting.INPUT_DELIMITER.getCharacter())).toList();
    }

    private List<Integer> stringListToNumberList() {
        return inputToStringList().stream()
                .mapToInt(Integer::parseInt)
                .boxed().toList();
    }

    public void setWinningNumbers() {
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setWinningNumbers(stringListToNumberList());
    }
}
