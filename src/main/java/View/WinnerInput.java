package View;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

enum REQUEST_MESSAGE {
    REQUEST_INPUT("당첨 번호를 입력해 주세요."),
    REQUEST_PRICE("구입금액을 입력해 주세요.");
    private final String label;

    REQUEST_MESSAGE(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}

public class WinnerInput {
    private static List<Integer> winnerCode = new ArrayList<>();
    private static int bonus;

    private static List<Integer> parsing(List<String> temp) throws NumberFormatException {
        winnerCode.clear();
        for (String s : temp) {
            winnerCode.add(parseInt(s));
        }
        return winnerCode;
    }

    public static List<Integer> getWinner() {
        int i = 0;
        System.out.println(REQUEST_MESSAGE.REQUEST_INPUT.label());
        String winningBall = Console.readLine();
        for (String s :  winningBall.split(",")) {
            winnerCode.add(Integer.parseInt(s));
        }
        return winnerCode;
    }
}