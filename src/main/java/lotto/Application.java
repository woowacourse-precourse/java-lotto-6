package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Application {
    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String SHOW_WINNING_STATISTICS = "당첨 통계" + "\n" + "---";

    public static int lottery;

    public static void main(String[] args) {

        getLottery();

        GuessLottoTickets guessLotto = new GuessLottoTickets(lottery);
        guessLotto.printWinningLottoList();

        WinningLotto winningLotto = getWinningLotto();

        System.out.println(SHOW_WINNING_STATISTICS);
        Statistics statistics = new Statistics();
        statistics.printMatchResult(winningLotto.countContainsNumber(guessLotto),
                winningLotto.containsBonus(guessLotto), lottery);


    }

    private static WinningLotto getWinningLotto() {
        Lotto winningLotto = generateWinningLotto();
        Bonus bonus = generateBonus();
        return new WinningLotto(winningLotto, bonus);
    }

    private static void getLottery() {
        while (true) {
            try {
                setLottery();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void setLottery() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
        int price = getNumber();

        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요.");
        }

        lottery = price / 1000;
        System.out.println(lottery + "개를 구매했습니다.");


        if (lottery < 1) {
            throw new IllegalArgumentException("[ERROR] 한 장 이상 구매하세요.");
        }
    }

    private static Bonus generateBonus() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int number = getNumber();
                return new Bonus(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Lotto generateWinningLotto() {
        while (true) {
            try {
                System.out.println(REQUEST_LOTTO_NUMBER);
                String[] splittedNumbers = Console.readLine().split(",");
                List<Integer> numbers = toNumbers(splittedNumbers);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자를 입력하세요.");
        }
    }

    private static List<Integer> toNumbers(String[] splittedNumbers) {
        try {
            return Arrays.stream(splittedNumbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자만 입력하세요.");
        }
    }
}
