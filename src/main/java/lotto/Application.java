package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static final int LOTTO_TICKET_PRICE = 1_000;

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(readLine());

        int ticketCount = purchaseAmount / LOTTO_TICKET_PRICE;
        Lotto[] tickets = new Lotto[ticketCount];

        System.out.printf("\n%d개를 구매했습니다.\n", ticketCount);
        for (int i = 0; i < ticketCount; i++) {
            tickets[i] = Lotto.generate();
            System.out.println(tickets[i].getNumbers());
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String lottoNumbers = readLine();

        List<Integer> numbers = Arrays.stream(lottoNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());

        WinningNumbers win = new WinningNumbers(numbers, bonusNumber);

        int[] rankCount = new int[6];
        for (int i = 0; i < ticketCount; i++) {
            int rank = win.getWinningRank(tickets[i]);
            rankCount[rank]++;
        }

        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (int i = 5; i >= 1; i--) {
            if (i == 1) {
                System.out.println(WinMessageType.FIRST.getDetail() + " - " + rankCount[i]);
            } else if (i == 2) {
                System.out.println(WinMessageType.SECOND.getDetail() + " - " + rankCount[i]);
            } else if (i == 3) {
                System.out.println(WinMessageType.THIRD.getDetail() + " - " + rankCount[i]);
            } else if (i == 4) {
                System.out.println(WinMessageType.FOURTH.getDetail() + " - " + rankCount[i]);
            } else if (i == 5) {
                System.out.println(WinMessageType.FIFTH.getDetail() + " - " + rankCount[i]);
            }
        }
    }
}
