package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String enterAmount() {
        return Console.readLine();
    }

    public String enterWiningNumber() {
        return Console.readLine();
    }

    public String enterBonusNumber() {
        return Console.readLine();
    }

    public void inputClose() {
        Console.close();
    }
}
