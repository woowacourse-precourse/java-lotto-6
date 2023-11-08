package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGameView {
    static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    static final String WINNING_NUM_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String BONUS_NUM_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputMoney(){
        System.out.println(MONEY_INPUT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputWinningLotto(){
        System.out.println(WINNING_NUM_INPUT_MESSAGE);
        List<Integer> winningNumber = Stream.of(Console.readLine().split(",")).map(x -> Integer.parseInt(x.trim())).collect(Collectors.toList());
        Collections.sort(winningNumber);
        return winningNumber;
    }

    public static int inputBonusNumber(){
        System.out.println(BONUS_NUM_INPUT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}
