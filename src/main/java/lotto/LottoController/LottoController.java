package lotto.LottoController;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoModel.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoModel.LottoRank.*;

public class LottoController {

    public void start(){
        int purchaseAmount = purchaseAmountAndValidCheck();
        int ticketsNumber = purchaseAmount / 1000;
        System.out.println("\n" + ticketsNumber + "개를 구매했습니다.");

        List<Lotto> tickets = generateRandomLotto(ticketsNumber);
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getLottoNums());
        }

        Lotto matchingLotto = findMatchingLotto();
        int bonusNum = bonusNumAndCheckValid();

        int[] result = calculateResult(tickets, matchingLotto, bonusNum);
        printResult(ticketsNumber, result);
    }

    public int purchaseAmountAndValidCheck(){
        int purchaseAmount = 0;
        boolean flag = false;

        while (!flag) {
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
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    public int bonusNumAndCheckValid(){
        int bonusNum = 0;
        boolean flag = false;

        while (!flag) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            bonusNum = Integer.parseInt(Console.readLine());
            try {
                if (bonusNum < 1 || bonusNum > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNum;
    }

    public Lotto findMatchingLotto(){
        Lotto matchingLotto = null;
        boolean flag = false;

        while (!flag) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                matchingLotto = inputValidLotto();
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return matchingLotto;
    }

    public Lotto inputValidLotto() {
        System.out.println("로또 번호를 입력해 주세요. (1부터 45까지의 숫자, 중복 없이 6개, 쉼표(,)로 구분)");
        String[] numberStrings = Console.readLine().split(",");

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

    public List<Lotto> generateRandomLotto(int numberOfTickets) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets.add(new Lotto(numbers));
        }
        return tickets;
    }

    public int countWinningLottos(Lotto ticket, Lotto winningNums) {
        int count = 0;
        List<Integer> ticketNumbers = ticket.getLottoNums();
        List<Integer> winningNumbers = winningNums.getLottoNums();

        for (int number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public int[] calculateResult(List<Lotto> tickets, Lotto winningLotto, int bonusNumber) {
        int[] result = new int[6];
        for (Lotto ticket : tickets) {
            int matchedNumbers = countWinningLottos(ticket, winningLotto);
            boolean hasBonusNumber = ticket.getLottoNums().contains(bonusNumber);

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

    public void printResult(int numberOfTickets, int[] result) {
        int totalAmount = result[0] * All.getPrize() + result[1] * FIVEANDBONUS.getPrize()
                + result[2] * FIVE.getPrize() + result[3] * FOUR.getPrize() + result[4] * THREE.getPrize();
        double totalPurchaseAmount = numberOfTickets * 1000;
        double profitRate = (totalAmount / totalPurchaseAmount) * 100;

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
