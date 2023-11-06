package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

import static lotto.ErrorMessage.*;
import static lotto.LottoConstants.*;

public class Game {
    private static final String WINNING_NUMBERS_DELIMITER = ",";

    private long money;

    private WinningNumbers winningNumbers;
    private final List<Lotto> tickets = new ArrayList<>();

    public void play() {
        inputMoney();

        int count = (int) (money / LOTTO_PRICE);
        buy(count);

        inputWinningNumbers();
        inputBonus();

    }

    private long inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Long.parseLong(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_PARSING_ERROR_MESSAGE);
        }
        System.out.println();

        validateMoney(money);

        return money;
    }

    private void validateMoney(long money) {
        if (money % LOTTO_PRICE != 0) {
            String lottoPrice = NumberFormat.getInstance().format(LOTTO_PRICE);
            throw new IllegalArgumentException(LOTTO_PRICE_ERROR_MESSAGE);
        }
    }

    private void buy(int count) {
        for (int i = 0; i < count; i++) {
            tickets.add(new Lotto(numbers()));
        }
        System.out.println(count + "개를 구매했습니다.");
        tickets.forEach(System.out::println);
        System.out.println();
    }

    private List<Integer> numbers() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < LOTTO_SIZE) {
            int number = Randoms.pickNumberInRange(LOTTO_MIN, LOTTO_MAX);
            if (!set.contains(number)) {
                set.add(number);
            }
        }

        return set.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = Arrays.stream(Console.readLine().split(WINNING_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validateWinningNumbers(numbers);

        System.out.println();
        return new Lotto(numbers);
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        boolean outOfBound = numbers.stream().anyMatch(number -> number < LOTTO_MIN || number > LOTTO_MAX);
        if (outOfBound) {
            throw new IllegalArgumentException(LOTTO_OUT_OF_RANGE_MESSAGE);
        }
    }

    private int inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_PARSING_ERROR_MESSAGE);
        }

        validateBonus(bonus);

        System.out.println();
        return bonus;
    }

    private void validateBonus(int bonus) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(LOTTO_AND_BONUS_DUPLICATED_MESSAGE);
        }
    }
}
