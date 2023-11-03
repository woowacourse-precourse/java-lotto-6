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
    }

    // 당첨 번호 받기.
    private static List<Integer> winningNumber() {
        String input = Console.readLine();
        List<String> inputdate = Arrays.asList(input.split(","));
        List<Integer> winningNumber = new ArrayList<>();
        for (String s : inputdate) {
            winningNumber.add(Integer.parseInt(s));
        }
        validateWinningNumber(winningNumber);
        return winningNumber;
    }

    // 당첨 번호 숫자 확인.
    private static void validateWinningNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 && number > 45) {
                throw new IllegalArgumentException("입력 가능한 숫자는 1~45 사이의 숫자 입니다.");
            }
        }
    }
}
