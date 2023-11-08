package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.input.Input;
import lotto.output.Output;

public class GameController {

    public int getNumber(final String inputMessage) {
        Output.print(inputMessage);
        try {
            return Input.getInteger();
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return getNumber(inputMessage);
        }
    }

    public List<Integer> getLottoNumbers() {
        Output.print(Output.LOTTO_NUMBERS_INPUT_MESSAGE);
        try {
            String readLine = Input.getLine();
            return Arrays.stream(readLine.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            Output.print("[ERROR] 정수와 쉼표만 입력해야 합니다.");
            return getLottoNumbers();
        }
    }
}
