package lotto;

import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.implementation.ExceptionMethod;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_PLAYER = "당첨 번호를 입력해주세요.";
    private static final String INPUT_LOTTO_BONUS = "보너스 번호를 입력해 주세요.";

    public static String inputAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Console.readLine();
    }

    public static List<Integer> inputPlayer() {
        System.out.println(INPUT_LOTTO_PLAYER);
        return playerNumberList(Console.readLine());
    }

    public static int inputBonus() {
        System.out.println(INPUT_LOTTO_BONUS);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> playerNumberList(String playerNumbers) {
        //","를 기준으로 값을 나누어 준다.
        String[] result = playerNumbers.split(",");
        List<Integer> playerBallList = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            playerBallList.add(content(result[i]));
        }
        return playerBallList;
    }

    //숫자 또는 에러메세지를 넣어주기 위해 따로 분리를 한다.
    private static int content(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            //입력된 값이 숫자가 아닐경우
            ErrorMessage.setTypeError();
            throw new IllegalArgumentException();
        }
    }
}
