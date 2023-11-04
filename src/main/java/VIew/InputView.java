package VIew;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public String getUserInput() {
       return Console.readLine();
    }

}
