package lotto;

import java.util.*;

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

        System.out.println("\n" + numberOfTickets + "개를 구매했습니다.");
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
        System.out.println("당첨 번호를 입력해 주세요.");
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

    private static void calculateAndPrintLottoStatistics(List<Lotto> tickets, Lotto winningLotto, int bonusNumber) {
        // TODO: 로또 통계 계산 및 출력
        int totalPrize;
        int countOf3Match = 0;
        int countOf4Match = 0;
        int countOf5Match = 0;
        int countOf5AndBonusMatch = 0;
        int countOf6Match = 0;

        List<Integer> prizes = new ArrayList<>();

        for (Lotto ticket : tickets) {
            int matchedCount = getMatchedNumbers(ticket, winningLotto);
            boolean isBonusMatch = ticket.numbers().contains(bonusNumber);

            if (matchedCount == 3) {
                prizes.add(5000);
                countOf3Match++;
            }
            if (matchedCount == 4) {
                prizes.add(50000);
                countOf4Match++;
            }
            if (matchedCount == 5) {
                if (isBonusMatch) {
                    prizes.add(30000000);
                    countOf5AndBonusMatch++;
                } else {
                    prizes.add(1500000);
                    countOf5Match++;
                }
            }
            if (matchedCount == 6) {
                prizes.add(2000000000);
                countOf6Match++;
            }
        }

        totalPrize = prizes.stream().mapToInt(Integer::intValue).sum();

        double profitRate = (double) totalPrize / (tickets.size() * 1000) * 100;

        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + countOf3Match + "개");
        System.out.println("4개 일치 (50,000원) - " + countOf4Match + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countOf5Match + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countOf5AndBonusMatch + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countOf6Match + "개");
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    private static int getMatchedNumbers(Lotto ticket, Lotto winningLotto) {
        List<Integer> ticketNumbers = ticket.numbers();
        List<Integer> winningNumbers = winningLotto.numbers();

        int matchedCount = 0;
        for (int number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                matchedCount++;
            }
        }
        return matchedCount;
    }
}