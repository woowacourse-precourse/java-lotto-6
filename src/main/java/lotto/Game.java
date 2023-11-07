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
        try {
            long money = inputMoney();
            List<Lotto> tickets = buy(money);
            WinningNumbers winningNumbers = inputWinningNumbers();
            Map<Grade, Integer> winners = winningNumbers.draw(tickets);
            printResult(winners, money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_SIZE);
    }

    private WinningNumbers inputWinningNumbers() {
        Lotto winning = new Lotto(inputNumbers());
        int bonus = inputBonus();
        return new WinningNumbers(winning, bonus);
    }

    private List<Integer> inputNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = Arrays.stream(Console.readLine().split(WINNING_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numbers.forEach(this::validateNumber);
        return numbers;
    }

    private void validateNumber(int number) {
        if (number < LOTTO_MIN || number > LOTTO_MAX) {
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
        validateNumber(bonus);
        return bonus;
    }

    private void printResult(Map<Grade, Integer> winners, long money) {
        printWinners(winners);
        long profit = 0;
        for (Grade grade : winners.keySet()) {
            profit += grade.calculatePrize(winners.get(grade));
        }
        printYield(profit, money);
    }

    private void printWinners(Map<Grade, Integer> winners) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Grade grade : Grade.values()) {
            grade.print(winners.getOrDefault(grade, 0));
        }
    }

    private void printYield(long profit, long money) {
        String yield = String.format("%.1f", 100.0 * profit / money);
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
