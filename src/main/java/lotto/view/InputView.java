package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static InputView inputView;

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private String readInput() {
        return Console.readLine();
    }

    public int readAmount() {
        try {
            String input = readInput();
            System.out.println();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public WinningNumber readWinningNumber() {
        String input = readInput();
        System.out.println();

        try {
            List<Integer> numbers = new ArrayList<>();
            for (String s : input.split(",")) {
                numbers.add(Integer.parseInt(s));
            }
            return new WinningNumber(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
