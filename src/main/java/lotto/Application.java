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

        for (int i = 0; i < ticketCount; i++) {
            tickets[i] = Lotto.generate();
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoNumbers = readLine();

        List<Integer> numbers = Arrays.stream(lottoNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());

        WinningNumbers win = new WinningNumbers(numbers, bonusNumber);

        int[] rankCount = new int[6];
        for (int i = 0; i < ticketCount; i++) {
            int rank = win.getWinningRank(tickets[i]);
            rankCount[rank]++;
        }

    }
}
