package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Input {

    public static String inputPrice() {
        String price = Console.readLine();
        return price;
    }

    public static String inputWinningNumbers() {
        String winningNumbers = Console.readLine();
        return winningNumbers;
    }

    public static String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
