package lotto.domain;

import lotto.domain.Exception;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public Long InputPrice() {

        String initial_input = Console.readLine();

        while (Exception.CheckValidateInput(initial_input) == 0) {
            initial_input = Console.readLine();
        }

        Long result = Long.parseLong(initial_input);

        while (Exception.CheckPriceValidate(result) == 0) {
            return InputPrice();
        }

        return result;
    }

    public List<Integer> InputWinnerNumber() {
        List<Integer> winner_number = new ArrayList<>();

        String input;
        input = Console.readLine();
        String[] result = input.split(",");

        while (Exception.CheckWinnerNumber(result) == 0) {
            return InputWinnerNumber();
        }

        for (String a : result) {
            winner_number.add(Integer.parseInt(a));
        }

        return winner_number;
    }

    public int InputBonusNumber(List<Integer> winner_number) {
        String input = Console.readLine();

        while (Exception.CheckValidateInput(input) == 0) {
            input = Console.readLine();
        }

        int result = Integer.parseInt(input);

        while (Exception.CheckValidateNumber(result) == 0
                || Exception.CheckOverlapWinnernumber(result, winner_number) == 0) {
            return InputBonusNumber(winner_number);
        }

        return result;
    }


}
