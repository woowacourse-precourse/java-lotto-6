package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public static String inputAmount() {
        return Console.readLine();
    }

    public static List<Integer> input_Winning_Number() { // List로 바꿔서 입력하도록
        return numberList(Console.readLine());
    }

    public static int input_BonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> numberList(String winningNumber) {
        List<String> str = List.of(winningNumber.split(",")); //매직 리터롤
        List<Integer> winnerNumberList = new ArrayList<>();
        for (int i = 0; i < str.size(); i++) {
            winnerNumberList.add(Integer.valueOf(winningNumber));
        }

        return winnerNumberList;
    }
}
