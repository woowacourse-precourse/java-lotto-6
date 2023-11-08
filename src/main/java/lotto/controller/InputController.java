package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Util;
import lotto.view.InputView;

public class InputController {

    Validation validation = new Validation();
    InputView inputView = new InputView();
    Util util = new Util();
    public int purchaseAmount() {

        inputView.purchaseAmount();

        String input = Console.readLine();

        try {
            validation.purchaseAmount(input);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseAmount();
        }

        return Integer.parseInt(input);
    }

    public List<Integer> winNumbers() {
        inputView.winNumbers();

        List<String> input = util.stringToList(Console.readLine(), ",");

        try {
            validation.isNumber(input);
            validation.winNumber(input);

        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winNumbers();
        }

        List<Integer> winNumber = util.stringListToIntegerList(input);

        return winNumber;
    }

    public int bonusNumber(List<Integer> winNumber) {
        inputView.bonusNumber();
        String input = Console.readLine();

        try {
            validation.bonusNumber(input, winNumber);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber(winNumber);
        }

        int bonusNumber = Integer.parseInt(input);

        return bonusNumber;
    }
}
