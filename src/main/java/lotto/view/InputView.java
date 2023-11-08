package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.User;

public class InputView {
    public static User readPayment() {
        String pay = Console.readLine();
        return User.paid(pay);
    }
}
