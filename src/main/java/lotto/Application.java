package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    private static void setLottoWinningNumbers() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            inputLottoWinningNumbers();
        } catch (IllegalArgumentException e) {
            setLottoWinningNumbers();
        }
    }

    private static void inputLottoWinningNumbers() {
        String userInputWinningNumbers = Console.readLine();
        checkSeparator(userInputWinningNumbers);
    }

    private static void checkSeparator(String numbers) {
        String regularExpressionNumbers = numbers.replaceAll("[0-9,]", "");
        System.out.println(regularExpressionNumbers);
        if (!regularExpressionNumbers.equals("")) {
            System.out.println("당첨 번호는 숫자만 입력해야 하며 구분자는 쉼표(,)로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        setLottoWinningNumbers();
    }
}
