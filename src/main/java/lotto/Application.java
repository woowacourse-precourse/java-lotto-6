package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    enum LottoRank {
        FIRST(6, "2,000,000,000"),
        SECOND(5, "30,000,000"),
        THIRD(5, "1,500,000"),
        FOURTH(4, "50,000"),
        FIFTH(3, "5,000"),
        NONE(0, "0");

        private final int countOfMatch;
        private final String winningMoney;

        LottoRank(int countOfMatch, String winningMoney) {
            this.countOfMatch = countOfMatch;
            this.winningMoney = winningMoney;
        }

        public int getCountOfMatch() {
            return countOfMatch;
        }
        public String getWinningMoney() {
            return winningMoney;
        }
    }

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int money = getLottoPurchasePrice();
        System.out.println("\n" + money / 1000 + "개를 구매했습니다.");

        ArrayList<Lotto> lottos = makeLottery(money);
        printLottoNumbers(lottos);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        int[] winningNumbers = receiveWinningNumbers(Console.readLine());
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        //HashMap<LottoRank, Integer> matchCountByRank = getMatchCountByRank(lottos, winningNumbers, bonusNumber);
    }

    public static int getLottoPurchasePrice() {
        int money;
        while (true) {
            try {
                String str = Console.readLine();
                if (!str.matches("^[0-9]*$")) throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
                money = Integer.parseInt(str);
                if (money % 1000 != 0)  throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 구매할 수 있습니다.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    public static ArrayList<Lotto> makeLottery(int money) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / 1000; ++i) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public static int[] receiveWinningNumbers(String str) {
        int[] winningNumbers = Arrays.stream(str.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        return winningNumbers;
    }

    public static HashMap<LottoRank, Integer> getMatchCountByRank(ArrayList<Lotto> lottos, int[] winningNumbers, int bonusNumber) {
        HashMap<LottoRank, Integer> matchCountByRank = new HashMap<>();
        matchCountByRank.put(LottoRank.FIFTH, lottos.stream().filter(lotto -> lotto.matchCount(winningNumbers) == 3).toArray().length);
        matchCountByRank.put(LottoRank.FOURTH, lottos.stream().filter(lotto -> lotto.matchCount(winningNumbers) == 4).toArray().length);
        matchCountByRank.put(LottoRank.THIRD, lottos.stream().filter(lotto -> lotto.matchCount(winningNumbers) == 5).toArray().length);
        matchCountByRank.put(LottoRank.SECOND, lottos.stream().filter(lotto -> lotto.matchCount(winningNumbers) == 5 && lotto.matchBonusNumber(bonusNumber)).toArray().length);
        matchCountByRank.put(LottoRank.FIRST, lottos.stream().filter(lotto -> lotto.matchCount(winningNumbers) == 6).toArray().length);
        return matchCountByRank;
    }

    public static int getEarnedMoney(HashMap<LottoRank, Integer> matchCountByRank) {
        int earned = matchCountByRank.get(LottoRank.FIFTH) * Integer.parseInt(LottoRank.FIFTH.getWinningMoney().replace(",", ""))
                + matchCountByRank.get(LottoRank.FOURTH) * Integer.parseInt(LottoRank.FOURTH.getWinningMoney().replace(",", ""))
                + matchCountByRank.get(LottoRank.THIRD) * Integer.parseInt(LottoRank.THIRD.getWinningMoney().replace(",", ""))
                + matchCountByRank.get(LottoRank.SECOND) * Integer.parseInt(LottoRank.SECOND.getWinningMoney().replace(",", ""))
                + matchCountByRank.get(LottoRank.FIRST) * Integer.parseInt(LottoRank.FIRST.getWinningMoney().replace(",", ""));
        return earned;
    }

    public static double getRevenueRate(int earned, int money) {
        double rate = (double) earned / money * 100;
        rate = Math.round(rate * 100.0) / 100.0;
        return rate;
    }

    public static void printLottoNumbers(ArrayList<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = Arrays.asList(lotto.getNumbers().toArray(new Integer[0]));
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }
}
