package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoNumberDTO;

import static lotto.CommonUnits.*;

public class Inputter {
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
        System.out.println();
        validatePurchase(won);
        return won;
    }

    public LottoNumberDTO lottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return new LottoNumberDTO(isDup(Arrays.stream(Console.readLine().split(","))
                .mapToInt(this::parseInt).map(this::validateLottoNumber)
                .boxed().collect(Collectors.toList())));
    }

    public int bonus() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return validateLottoNumber(parseInt(Console.readLine()));
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

    private List<Integer> isDup(List<Integer> numbers) {
        if (numbers.stream().collect(Collectors.toSet()).size() < NUMBERS_OF_LOTTO) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해주세요.");
        }
        return numbers;
    }
}
