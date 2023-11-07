package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int getAmount() {
        String input = Console.readLine();
        int amount = Integer.parseInt(input);

        if (!validAmount(amount)) {
            throw new IllegalArgumentException();
        }
        return amount;
    }

    public static String getLottoNumbers() {
        String lottoNumbers = Console.readLine();
        // 입력된 값이 숫자,숫자,숫자,숫자,숫자,숫자인 경우에만 유효
        // 입력된 값의 숫자들이 1~45 범위이면 유효
        // 유효가 아닌 경우 예외처리
        if (lottoNumbers.s)
        return lottoNumbers;
    }

    private static boolean validAmount(int amount) {
        return (amount % 1000) == 0;
    }
}
