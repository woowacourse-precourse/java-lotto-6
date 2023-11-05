package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    public Integer getPurchaseQuantity() {
        int purchaseAmount = Integer.parseInt(Console.readLine().trim());

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        return purchaseAmount / 1000;
    }

    public List<Integer> readWinningNumber() {
        List<Integer> winningNumbers = new ArrayList<>();
        List<String> inputNumbers;

        inputNumbers = Arrays.stream(Console.readLine().replaceAll(" ", "").split(",")).toList();
        for (String inputNumber : inputNumbers) {
            winningNumbers.add(Integer.parseInt(inputNumber));
        }

        return winningNumbers;
    }
}
