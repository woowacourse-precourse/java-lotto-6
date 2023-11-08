package lotto.service;

import static lotto.view.InputView.winningNumber;

import java.util.ArrayList;
import java.util.List;

public class InputService {
    public static List<Integer> winningNumberList = new ArrayList<>();

    public static void transformWinningNumber() {
        String[] split = winningNumber.split(",");

        for (String element : split) {
            int i = Integer.parseInt(element);
            winningNumberList.add(i);
        }
    }
}
