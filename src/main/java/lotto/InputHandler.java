package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    private final InputService inputService;

    public InputHandler(InputService inputService) {
        this.inputService = inputService;
    }

    public List<Integer> getWinningNumber() {
        String inputNumber = inputService.readLine();
        List<Integer> winningNumber = new ArrayList<>();
        try {
            winningNumber = Arrays.stream(inputNumber.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        return winningNumber;
    }

    public int getInputNumber() {
        String inputNumber = inputService.readLine();
        int number = 0;
        try {
            number = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        return number;
    }
}
