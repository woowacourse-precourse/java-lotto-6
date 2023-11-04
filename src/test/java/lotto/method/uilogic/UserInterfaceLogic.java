package lotto.method.uilogic;

import camp.nextstep.edu.missionutils.Console;

import java.io.ByteArrayInputStream;

public class UserInterfaceLogic {

    private UserInterfaceLogic() {}

    public static void setUserInput(String userInput) {
        Console.close();
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
    }
}
