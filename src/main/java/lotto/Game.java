package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.ErrorMessage.*;
import static lotto.LottoConstants.*;

public class Game {

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    private final long money;
    private final Lotto winningNumbers;
    private final int bonus;
    private final List<Lotto> tickets;
    private final Map<Grade, Integer> winners;

    public Game() {
        money = money();
        tickets = buy(money);
        winningNumbers = winningNumbers();
        bonus = bonus();
        winners = draw();
    }

    private long money() {
        while (true) {
            try {
                return inputMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private long inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        long money;
        try {
            money = Long.parseLong(Console.readLine());
            validateMoney(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_PARSING_ERROR_MESSAGE);
        }
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

    private Lotto winningNumbers() {
        while (true) {
            try {
                return inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            List<Integer> numbers = Arrays.stream(Console.readLine().split(WINNING_NUMBERS_DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_PARSING_ERROR_MESSAGE);
        }
    }

    private int bonus() {
        while (true) {
            try {
                return inputBonus();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonus = Integer.parseInt(Console.readLine());
            validateBonus(bonus);
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_PARSING_ERROR_MESSAGE);
        }
    }

    private void validateBonus(int bonus) {
        Lotto.validateRange(bonus);
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(LOTTO_AND_BONUS_DUPLICATED_MESSAGE);
        }
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");

        printWinners();
        printYield();
    }

    private long calculateProfit() {
        long profit = 0;
        for (Grade grade : winners.keySet()) {
            profit += grade.calculatePrize(winners.get(grade));
        }
        return profit;
    }

    private void printWinners() {
        for (Grade grade : Grade.values()) {
            int numOfWinners = winners.getOrDefault(grade, 0);
            System.out.println(grade.info() + " - " + numOfWinners + "개");
        }
    }

    private void printYield() {
        long profit = calculateProfit();
        String yield = String.format("%.1f", 100.0 * profit / money);
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    public Map<Grade, Integer> draw() {
        Map<Grade, Integer> winners = new HashMap<>();
        for (Lotto ticket : tickets) {
            Optional<Grade> optionalGrade = ticket.draw(winningNumbers, bonus);
            if (optionalGrade.isPresent()) {
                Grade grade = optionalGrade.get();
                int numOfWinners = winners.getOrDefault(grade, 0);
                winners.put(grade, numOfWinners + 1);
            }
        }
        return winners;
    }
}
