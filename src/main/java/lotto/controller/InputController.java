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
            validation.winNumber(input);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winNumbers();
        }

        return util.stringListToIntegerList(input);
    }
}
