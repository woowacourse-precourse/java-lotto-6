package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        int purchaseAmount = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                if (!input.matches("\\d+")) {
                    throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해 주세요.");
                }
                purchaseAmount = Integer.parseInt(input);
                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
                }
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int numberOfTickets = purchaseAmount / 1000;
        System.out.println("\n" + numberOfTickets + "개를 구매했습니다.");

        List<Lotto> tickets = generateLottoTickets(numberOfTickets);
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers());
        }

        Lotto winningLotto = null;
        validInput = false;

        while (!validInput) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                winningLotto = readLotto();
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int bonusNumber = 0;
        validInput = false;

        while (!validInput) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                bonusNumber = Integer.parseInt(Console.readLine());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int[] result = calculateResult(tickets, winningLotto, bonusNumber);
        printResult(numberOfTickets, result);
    }

    private static Lotto readLotto() {
        System.out.println("로또 번호를 입력해 주세요. (1부터 45까지의 숫자, 중복 없이 6개, 쉼표(,)로 구분)");
        String input = Console.readLine();
        String[] numberStrings = input.split(",");

        if (numberStrings.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            if (number < 1 || number > 45 || numbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 올바른 로또 번호를 입력해 주세요.");
            }
            numbers.add(number);
        }
        return new Lotto(numbers);
    }


    private static List<Lotto> generateLottoTickets(int numberOfTickets) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            tickets.add(new Lotto(numbers));
        }
        return tickets;
    }

    private static int countMatchingNumbers(Lotto ticket, Lotto winningNums) {
        int count = 0;
        List<Integer> ticketNumbers = ticket.getNumbers();
        List<Integer> winningNumbers = winningNums.getNumbers();
        for (int number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static int[] calculateResult(List<Lotto> tickets, Lotto winningLotto, int bonusNumber) {
        int[] result = new int[6];
        for (Lotto ticket : tickets) {
            int matchedNumbers = countMatchingNumbers(ticket, winningLotto);
            boolean hasBonusNumber = ticket.getNumbers().contains(bonusNumber);
            if (matchedNumbers == 6) {
                result[0]++;
            } else if (matchedNumbers == 5 && hasBonusNumber) {
                result[1]++;
            } else if (matchedNumbers == 5) {
                result[2]++;
            } else if (matchedNumbers == 4) {
                result[3]++;
            } else if (matchedNumbers == 3) {
                result[4]++;
            }
        }
        return result;
    }

    private static void printResult(int numberOfTickets, int[] result) {
        int totalWinningAmount = result[0] * 2000000000 + result[1] * 30000000 + result[2] * 1500000
                + result[3] * 50000 + result[4] * 5000;
        double totalPurchaseAmount = numberOfTickets * 1000;

        double profitRate = (totalWinningAmount / totalPurchaseAmount) * 100;

        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + result[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result[0] + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

}
