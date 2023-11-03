package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input {
    public int getPrice() {
        String inputPrice = Console.readLine();

        return Integer.parseInt(inputPrice);
    }
}
