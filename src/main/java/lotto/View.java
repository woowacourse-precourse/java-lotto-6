package lotto;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public String getUserInput() {
        return Console.readLine();
    }

    public void printMessage(Notice notice) {
        System.out.println(notice.getMessage());
    }
}
