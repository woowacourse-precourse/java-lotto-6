package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();

        int numberOfTickets = purchaseAmount / 1000;
        if (numberOfTickets == 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다.");
        }

        List<Lotto> tickets = generateLottoTickets(numberOfTickets);

        System.out.println( numberOfTickets + "개를 구매했습니다.\n");
        for (Lotto ticket : tickets) {
            System.out.println(ticket);
        }

        System.out.println();
        Lotto winningLotto = readWinningLotto();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        calculateAndPrintLottoStatistics(tickets, winningLotto, bonusNumber);
    }

    private static List<Lotto> generateLottoTickets(int numberOfTickets) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(Lotto.generateLotto());
        }
        return tickets;
    }

    private static Lotto readWinningLotto() {
        List<Integer> winningNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        String[] numbersStr = input.split(",");

        if (numbersStr.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        for (String numberStr : numbersStr) {
            int number = Integer.parseInt(numberStr);
            if (winningNumbers.contains(number) || number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winningNumbers.add(number);
        }

        Collections.sort(winningNumbers);
        return new Lotto(winningNumbers);
    }

    private static void calculateAndPrintLottoStatistics(List<Lotto> ignoredTickets, Lotto ignoredWinningLotto, int ignoredBonusNumber) {
        // TODO: 로또 통계 계산 및 출력

    }

}