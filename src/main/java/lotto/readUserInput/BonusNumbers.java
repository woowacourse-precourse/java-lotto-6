package lotto.readUserInput;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumbers implements UserInput {
    public static int number;

    public void read() {
        number = singleTypeConversion(userInput());
    }

    public String userInput() {
        return Console.readLine();
    }

    public int singleTypeConversion(String readSingleNumber) {
        return Integer.parseInt(readSingleNumber);
    }

}
