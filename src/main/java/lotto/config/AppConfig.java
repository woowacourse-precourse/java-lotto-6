package lotto.config;

import lotto.domain.UserInterface;
import lotto.domain.UserInterfaceImpl;

public class AppConfig {

    private static final UserInterface userInterface = new UserInterfaceImpl();

    public static UserInterface userInterface() {
        return userInterface;
    }
}
