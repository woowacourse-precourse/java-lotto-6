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

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winNumbers = readNumbers(input);

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        int[] winStatistics = calWinStatistics(lottoTickets, winNumbers, bonusNumber);
        printWinStatistics(winStatistics, price);
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

    public static List<Integer> readNumbers(String input) {
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            numbers.add(number);
        }
        return numbers;
    }

    public static int[] calWinStatistics(List<Lotto> lottoTickets, List<Integer> winNumbers, int bonusNumber) {
        int[] statistcs = new int[LottoRank.values().length];

        for (Lotto lottoTicket : lottoTickets) {
            int matchingCount = countMatchNumbers(lottoTicket.getNumbers(), winNumbers);
            LottoRank rank = getLottoRank(matchingCount, lottoTicket.getNumbers().contains(bonusNumber));
            statistcs[rank.ordinal()]++;
        }
        return statistcs;
    }

    public static int countMatchNumbers(List<Integer> lottoNumbers, List<Integer> winNumbers) {
        int countMatch = 0;
        for (int number : lottoNumbers) {
            if (winNumbers.contains(number)) {
                countMatch++;
            }
        }
        return countMatch;
    }

    public static LottoRank getLottoRank(int matchingCount, boolean hasBonus) {
        if (matchingCount == 6) {
            return LottoRank.FIRST;
        }
        if (matchingCount == 5 && hasBonus) {
            return LottoRank.SECOND;
        }
        if (matchingCount == 5) {
            return LottoRank.THIRD;
        }
        if (matchingCount == 4) {
            return LottoRank.FOURTH;
        }
        if (matchingCount == 3) {
            return LottoRank.FIFTH;
        }
        return LottoRank.NONE;
    }

    public static void printWinStatistics(int[] statistics, int price) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int totalWinAmount = 0;
        LottoRank[] ranks = LottoRank.values();
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        Arrays.sort(ranks, Comparator.comparingInt(LottoRank::getPrize));

        for (LottoRank rank : ranks) {
            if (rank != LottoRank.NONE) {
                int prize = rank.getPrize();
                int matchingCount = rank.getMatchingCount();
                int numMatches = statistics[rank.ordinal()];
                int totalPrize = prize * numMatches;

                String bonusBallInfo = "";
                if (rank == LottoRank.SECOND) {
                    bonusBallInfo = ", 보너스 볼 일치";
                }

                String formattedPrize = numberFormat.format(prize);
                String result = String.format("%d개 일치%s (%s원) - %d개%s", matchingCount, bonusBallInfo, formattedPrize, numMatches, bonusBallInfo);
                System.out.println(result);
                totalWinAmount += totalPrize;
            }
        }

        double earningRate = ((double) totalWinAmount / price) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f%%", earningRate) + "입니다.");
    }
}
