package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Lotto lotto = new Lotto(winningNumber());
        lotto.outputLottoNumber();

//        LottoPick lottoPick = new LottoPick(getMoney());
//        lottoPick.makeLottoPick();
//        lottoPick.outputLottoPick();
    }

    // 금액 받기.
    private static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    // 당첨 번호 받기.
    private static List<Integer> winningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<String> inputdate = Arrays.asList(input.split(","));
        List<Integer> winningNumber = new ArrayList<>();
        for (String s : inputdate) {
            winningNumber.add(Integer.parseInt(s));
        }
        return winningNumber;
    }
}
