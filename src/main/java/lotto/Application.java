package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Constant.LOTTO_TICKET_PRICE;
import static lotto.Util.println;

public class Application {
    public static void main(String[] args) {
        println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(readLine());

        int ticketCount = purchaseAmount / LOTTO_TICKET_PRICE;
        Lotto[] tickets = new Lotto[ticketCount];

        System.out.printf("\n%d개를 구매했습니다.\n", ticketCount);
        for (int i = 0; i < ticketCount; i++) {
            tickets[i] = Lotto.generate();
            println(tickets[i].getNumbers());
        }

        println("\n당첨 번호를 입력해 주세요.");
        String lottoNumbers = readLine();

        List<Integer> numbers = Arrays.stream(lottoNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());

        WinningNumbers win = new WinningNumbers(numbers, bonusNumber);

        int[] rankCount = new int[6];
        for (int i = 0; i < ticketCount; i++) {
            int rank = win.getRank(tickets[i]);
            rankCount[rank]++;
        }

        println("\n당첨 통계");
        println("---");
        for (int i = 5; i >= 1; i--) {
            RankType type = RankType.values()[i - 1];
            String detail = type.getDetail();
            String content = String.format("%s - %d개", detail, rankCount[i]);
            println(content);
        }

        int profitTotal = 0;
        for (int i = 1; i <= 5; i++) {
            RankType type = RankType.values()[i - 1];
            profitTotal += type.multiplePrize(rankCount[i]);
        }

        double profitRate = (double)(profitTotal) / purchaseAmount * 100;
        String temp = String.format("총 수익률은 %.1f%%입니다.", profitRate);
        println(temp);
    }
}
