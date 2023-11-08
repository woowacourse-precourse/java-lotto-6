package view;

import camp.nextstep.edu.missionutils.Console;
import message.InputMessage;

import java.util.List;

public class InputView {
    public String inputMoney() {
        System.out.println(InputMessage.PAYMENT.getMessage());
        return Console.readLine();
    }

    public List<Integer> inputWinning() {
        System.out.println(InputMessage.WINNINGNUMBERS.getMessage());
        List<String> input = List.of(Console.readLine().split(","));

        return input.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public String inputBonus() {
        System.out.println(InputMessage.BONUSNUMBER.getMessage());
        return Console.readLine();
    }
}
