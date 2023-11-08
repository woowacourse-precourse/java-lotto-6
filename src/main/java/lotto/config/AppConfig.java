package lotto.config;

import lotto.domain.LottoMachine;
import lotto.domain.RandomLottoMachine;
import lotto.domain.UserInterface;
import lotto.domain.UserInterfaceImpl;

public class AppConfig {

    private static final UserInterface userInterface = new UserInterfaceImpl();
    private static final LottoMachine lottoMachine = new RandomLottoMachine();

    public static UserInterface userInterface() {
        return userInterface;
    }

    public static LottoMachine lottoMachine() {
        return lottoMachine;
    }
}
