package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.NumberFormat;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int price = readConsole();

        if (price % 1000 != 0) {
            System.out.println("[ERROR] 1,000원 단위로 입력하세요.");
            return;
        }

        int count = price / 1000;
        System.out.println(count + "개를 구매했습니다.");

        List<Lotto> lottoTickets = generateLottoTickets(count);
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getNumbers());
        }
    }

    enum LottoRank {
        FIRST(6, 2000000000), SECOND(5, 30000000),
        THIRD(5, 1500000), FOURTH(4, 50000),
        FIFTH(3, 5000), NONE(0, 0);

        private final int matchingCount;
        private final int prize;

        LottoRank(int matchingCount, int prize) {
            this.matchingCount = matchingCount;
            this.prize = prize;
        }
        public int getMatchingCount() {
            return matchingCount;
        }
        public  int getPrize() {
            return prize;
        }
    }

    public static int readConsole() {
        while (true) {
            String input = Console.readLine();
            try{
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            }
        }
    }

    public static List<Lotto> generateLottoTickets(int numberOfTickets) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            lottoTickets.add(Lotto.pickRandom());
        }
        return lottoTickets;
    }
}
