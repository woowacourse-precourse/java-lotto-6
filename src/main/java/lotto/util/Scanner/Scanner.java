package lotto.util.Scanner;

import camp.nextstep.edu.missionutils.Console;

public class Scanner implements IScanner {

    @Override
    public String readLine() {
        return Console.readLine();
    }

}
