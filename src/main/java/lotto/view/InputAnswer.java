package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedList;
import java.util.List;

public class InputAnswer {
    private static final String WRONG_ANSWER = "6개의 당첨번호가 아닙니다";
    int answer[] = Console.readLine();


    private static void numberCheck(String answer) {
        String[] numbers = answer.split(",");
        if (numbers.length != 6)
            throw new IllegalArgumentException(WRONG_ANSWER);

    }
}
