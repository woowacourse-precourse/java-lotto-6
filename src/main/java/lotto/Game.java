package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.ErrorMessage.*;
import static lotto.LottoConstants.*;

public class Game {

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    public Game() {
        long money = inputMoney();
        List<Lotto> tickets = buy(money);
        WinningNumbers winningNumbers = inputWinningNumbers();
    }

    private long inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        long money;
        try {
            money = Long.parseLong(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_PARSING_ERROR_MESSAGE);
        }
        validateMoney(money);
        return money;
    }

    private void validateMoney(long money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE_ERROR_MESSAGE);
        }
    }

    private List<Lotto> buy(long money) {
        List<Lotto> tickets = new ArrayList<>();
        int count = (int) (money / LOTTO_PRICE);
        for (int i = 0; i < count; i++) {
            tickets.add(new Lotto(generateNumbers()));
        }
        System.out.println(count + "개를 구매했습니다.");
        tickets.forEach(System.out::println);
        return tickets;
    }

    private List<Integer> generateNumbers() {
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

    private WinningNumbers inputWinningNumbers() {
        List<Integer> numbers = inputNumbers();
        int bonus = inputBonus();
        return new WinningNumbers(numbers, bonus);
    }

    private List<Integer> inputNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = Arrays.stream(Console.readLine().split(WINNING_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateNumbers(numbers);
        return numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        boolean outOfBound = numbers.stream().anyMatch(number -> number < LOTTO_MIN || number > LOTTO_MAX);
        if (outOfBound) {
            throw new IllegalArgumentException(LOTTO_OUT_OF_RANGE_MESSAGE);
        }
    }

    private int inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus;
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_PARSING_ERROR_MESSAGE);
        }
        return bonus;
    }
}
