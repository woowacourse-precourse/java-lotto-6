package lotto.domain.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.enums.UserInterfaceMessage;

public class InputView {
    public String requestInputPrice() {
        System.out.println(UserInterfaceMessage.REQUEST_INPUT_PRICE.getValue());
        return readLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
