package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    static int price = 0;
    static int bonusNumber = 0;
    static int prizeMoney = 0;

    static List<Lotto> lottoes = new ArrayList<>();
    static List<Integer> winningNumbers = new ArrayList<>();
    static Map<Rank, Integer> lottoResult = new TreeMap<>(Collections.reverseOrder());

    public static void main(String[] args) {
        startLotto();
    }

    public static void startLotto() {
        inputPrice();
        System.out.println();
        makeLottoes(price / 1000);
        printLottoes();
        System.out.println();
        inputWinningNumbers();
        System.out.println();
        inputBonusNumber();
        System.out.println();
        checkResult();
        printResult(calculateProfits());
    }

    public static void inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int input = Integer.parseInt(Console.readLine());

        try {
            Exception.priceValidate(input);
            price = input;
        } catch (IllegalArgumentException e) {
            Exception.printException(e.getMessage());
            inputPrice();
        }
    }

    public static void makeLottoes(int count) {
        while(true) {
            if(count == 0) break;
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoes.add(new Lotto(numbers));
            count--;
        }
    }

    public static void printLottoes() {
        System.out.println(lottoes.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottoes) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        winningNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        try {
            Exception.winningNumberValidate(winningNumbers);
        } catch (IllegalArgumentException e) {
            Exception.printException(e.getMessage());
            inputWinningNumbers();
        }
    }

    public static void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        try {
            Exception.bonusNumberValidate(input, winningNumbers);
        } catch (IllegalArgumentException e) {
            Exception.printException(e.getMessage());
            inputBonusNumber();
        }
    }

    public static void initLottoResult() {
        lottoResult.put(Rank.RANK_0, 0);
        lottoResult.put(Rank.RANK_1, 0);
        lottoResult.put(Rank.RANK_2, 0);
        lottoResult.put(Rank.RANK_3, 0);
        lottoResult.put(Rank.RANK_4, 0);
        lottoResult.put(Rank.RANK_5, 0);
    }

    public static void checkResult() {
        initLottoResult();
        for(Lotto lotto : lottoes) {
            Rank rank = Rank.checkResult(countMatchNumber(lotto), checkBonusNumber(lotto));
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
            prizeMoney += rank.getPrizeMoney();
        }
    }

    public static int countMatchNumber(Lotto lotto) {
        int count = 0;
        for(int number : lotto.getNumbers()) {
            if(winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public static double calculateProfits() {
        return ((double) prizeMoney / (double) price) * 100.0;
    }

    public static void printResult(double profits) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for(Rank rank : lottoResult.keySet()) {
            if(rank == Rank.RANK_0) continue;
            System.out.println(rank.getPrintMessage() + " - " + lottoResult.get(rank) + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.1f", profits) + "%입니다.");
    }
}
