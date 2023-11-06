package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Inputter {

    private static final int MONEY_UNIT = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static Inputter inputter;

    private Inputter() {}

    public static Inputter getInputter() {
        if (inputter == null) {
            inputter = new Inputter();
        }
        return inputter;
    }

    public int purchase() {
        int won;

        System.out.println("구입금액을 입력해 주세요.");
        won = parseInt(Console.readLine());
        validatePurchase(won);
        return won;
    }

    public List<Integer> lottoNumbers() {
        return Arrays.stream(Console.readLine().split(","))
                .mapToInt(this::parseInt).map(this::validateLottoNumber)
                .boxed().collect(Collectors.toList());
    }

    private void validatePurchase(int won) {
        if (won % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] "+ MONEY_UNIT + "원 단위로 입력해주세요.");
        }
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해주세요.");
        }
    }

    private int validateLottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + MIN_LOTTO_NUMBER +
                    "부터 " + MAX_LOTTO_NUMBER + " 사이의 숫자여야 합니다.");
        }
        return number;
    }
}
