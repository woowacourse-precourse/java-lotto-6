package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.message.OutputMessage;

public class LottoView {
    public String readInput() {
        return Console.readLine();
    }

    public void closeInput() {
        Console.close();
    }

    public void displayMessage(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    public void displayFormattedMessage(OutputMessage formattedMessage, float percentage) {
        System.out.printf(formattedMessage.getMessage(), percentage);
    }

}
