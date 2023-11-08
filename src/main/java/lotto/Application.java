package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static int LOTTO_PRIZE = 1000;
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");

        String input = Console.readLine();
        int lottoPay = Integer.parseInt(testInput(input));
        int lottoNum = lottoPay / LOTTO_PRIZE;
        if (lottoPay % LOTTO_PRIZE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력되어야 합니다.");
        }

        System.out.println(lottoNum + "개를 구매했습니다.");

        List<Lotto> numbersList = generateLotto(lottoNum);
        printLottoNumbers(numbersList);

        System.out.println("당첨 번호를 입력해주세요.");
        List<Integer> prizeNum = readPrizeNumbers();

        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNum = Integer.parseInt(Console.readLine());

        checkWinningNumbers(numbersList, prizeNum, bonusNum);
        printWinningNumbers(lottoPay);
    }

    protected static List<Lotto> generateLotto(int lottoNum) {
        List<Lotto> numbersList = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            numbersList.add(lotto);
        }
        return numbersList;
    }

    private static void printLottoNumbers(List<Lotto> numbersList) {
        for(Lotto lotto : numbersList) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < lotto.getNumbers().size(); i++) {
                sb.append(lotto.getNumbers().get(i));
                if (i != lotto.getNumbers().size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }

    private static List<Integer> readPrizeNumbers() {
        String[] strPrize = Console.readLine().split(",");
        List<Integer> prizeNum = new ArrayList<>();
        for (String str : strPrize) {
            int num = Integer.parseInt(str.trim());
            prizeNum.add(num);
        }
        return prizeNum;
    }

    private static void checkWinningNumbers(List<Lotto> numbersList, List<Integer> prizeNum, int bonusNum) {
        for (Lotto lotto : numbersList) {
            for (Prize prize : Prize.values()) {
                prize.checkLotto(lotto, prizeNum, bonusNum);
            }
        }
    }

    private static void printWinningNumbers(int payforLotto){
        int totalPrize = 0;
        System.out.println("당첨통계");
        System.out.println("--");
        for (Prize prize : Prize.values()) {
            System.out.println(prize.description + "-" + prize.storNum + "개");
            totalPrize += Integer.parseInt(prize.cash);
        }

        double benefit = (double)totalPrize / (double)payforLotto;
        System.out.println("총 수익률은 " + Math.round(benefit * 100) / 100.0 + "%입니다.");
    }

    private static String testInput(String minput) {
        while (!minput.matches("\\d+")) {
            System.out.println("[ERROR] 입력 금액의 형식이 올바르지 않습니다.");
            minput = Console.readLine();
        }
        return  minput;
    }
}