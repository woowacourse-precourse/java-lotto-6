package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RunApplication {

    private final static Scanner scanner =  new Scanner(System.in);
    private final int PRICE_OF_LOTTO = 1000;
    private final int NUMBER_OF_RANKS = 5;

    /**
     * 로또 구매비용 입력
     * 구입한 수만큼 로또를 발행한다.
     * 당첨번호, 보너스 번호 입력
     * 발행한 로또의 등수를 확인한다.
     * 당첨 통계
     */
    public void run() {
        int costOfLotto = getCostOfLotto();
        int numberOfLotto = costOfLotto / PRICE_OF_LOTTO;
        List<List<Integer>> myLottoNumbers = getMyLottoNumbers(numberOfLotto);
        List<Integer> lottoNumbers = getLottoNumbers();
        int bonus = getBonus(lottoNumbers);
        Map<LottoRank, Integer> ranks = getRanks(numberOfLotto, lottoNumbers, bonus, myLottoNumbers);
        getResult(costOfLotto, ranks);
    }

    private void getResult(int costOfLotto, Map<LottoRank, Integer> ranks) {
        System.out.println("당첨 통계");
        System.out.println("---");
        double profit = 0.0;
        for (LottoRank value : LottoRank.values()) {
            System.out.println(value.getResult(ranks.get(value)));
            profit += value.getWinningPrice() * ranks.get(value);
        }
        BigDecimal profitDecimal = new BigDecimal(profit / costOfLotto * 100).setScale(1, RoundingMode.HALF_UP);
        System.out.printf("총 수익률은 %s%%입니다.\n", profitDecimal);
    }

    public Map<LottoRank, Integer> getRanks(int numberOfLotto, List<Integer> lottoNumbers, int bonus, List<List<Integer>> myLottoNumbers) {
        Map<LottoRank, Integer> ranks = Arrays.stream(LottoRank.values()).collect(Collectors.toMap(lottoRank -> lottoRank, lottoRank -> 0));
        for (int i = 0; i < numberOfLotto; i++) {
            LottoRank rank = getRank(lottoNumbers, bonus, myLottoNumbers, i);
            if (rank != null) {
                ranks.put(rank, ranks.get(rank) + 1);
            }
        }
        return ranks;
    }

    public List<List<Integer>> getMyLottoNumbers(int numberOfLotto) {
        System.out.printf("%d개를 구매했습니다.\n", numberOfLotto);
        List<List<Integer>> myLottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myLottoNumbers.add(numbers);
            System.out.println(numbers);
        }
        System.out.println();

        return myLottoNumbers;
    }

    private LottoRank getRank(List<Integer> lottoNumbers, int bonus, List<List<Integer>> myLottoNumbers, int i) {
        List<Integer> numbers = myLottoNumbers.get(i);
        long count = numbers.stream()
                .filter(lottoNumbers::contains)
                .count();
        if (count >= 6) return LottoRank.one;
        if (count == 5) {
            if (lottoNumbers.contains(bonus)) return LottoRank.two;
            return LottoRank.three;
        }
        if (count == 4) return LottoRank.four;
        if (count == 3) return LottoRank.five;
        return null;
    }

    public int getCostOfLotto() {
        int cost;
        try {
            cost = getCostOfLottoWithChainedException();
            System.out.println();
        } catch (IllegalArgumentException e) {
            return getCostOfLotto();
        }

        return cost;
    }

    /**
     * 위에 메서드랑 다르게 try안에서 return해도 문제가 없네?
     */
    public int getCostOfLottoWithChainedException() throws IllegalArgumentException {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int cost = Integer.parseInt(readLine());
            if (cost % 1000 != 0) {
                System.out.println(ExceptionMessage.로또_구입_비용_천원단위가아닌경우);
                throw new IllegalArgumentException();
            }
            return cost;
        } catch (NumberFormatException nfe) {
            System.out.println(ExceptionMessage.로또_구입비용_숫자가아닐때);
            throw new IllegalArgumentException(nfe);
        }
    }

    /**
     * 당첨 번호를 1에서 45 사이의 값을 확인하는 메서드를
     * isNumberIn1And45 말고 더 좋은 이름은 없을까?
     */
    public List<Integer> getLottoNumbers() {
        Lotto lotto = null;
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            List<String> numbers = Arrays.asList(readLine().split(","));
            lotto = new Lotto(numbers.stream().map(Integer::parseInt).sorted().toList());
            if (isNotNumberIn1And45(lotto)) {
                System.out.println(ExceptionMessage.당첨번호_1_45_사이가아닌경우);
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            getLottoNumbers();
        }
        System.out.println();
        return lotto.getNumbers();
    }

    public boolean isNotNumberIn1And45(Lotto lotto) {
        return lotto.getNumbers().stream().anyMatch(number -> number < 1 || 45 < number);
    }

    public int getBonus(List<Integer> lotto) {
        int bonus;
        try {
            bonus = getBonusWithChainedException();
            if (bonus < 1 || 45 < bonus) {
                System.out.println(ExceptionMessage.보너스번호가_숫자가아닐때);
                throw new IllegalArgumentException();
            }
            isNotDuplicateNumberWithLotto(lotto, bonus);
        }  catch (IllegalArgumentException iae) {
            return getBonus(lotto);
        }
        System.out.println();
        return bonus;
    }

    private int getBonusWithChainedException() throws IllegalArgumentException {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            return Integer.parseInt(readLine());
        } catch (NumberFormatException nfe) {
            System.out.println(ExceptionMessage.보너스번호가_숫자가아닐때);
            throw new IllegalArgumentException(nfe);
        }
    }

    public void isNotDuplicateNumberWithLotto(List<Integer> lotto, int bonus) throws IllegalArgumentException {
        for (Integer number : lotto) {
            if (number.equals(bonus)) {
                System.out.println(ExceptionMessage.보너스번호_중복);
                throw new IllegalArgumentException();
            }
        }
    }
}
