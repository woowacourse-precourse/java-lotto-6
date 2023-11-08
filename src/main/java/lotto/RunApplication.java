package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.IntStream;

public class RunApplication {

    private final static Scanner scanner =  new Scanner(System.in);
    private final int PRICE_OF_LOTTO = 1000;
    private final int NUMBER_OF_RANKS = 5;

    /**
     * 로또 구매비용 입력
     * 구입한 수만큼 로또를 발행한다.
     * 당첨번호, 보너스 번호 입력
     * 발행한 로또의 등수를 확인한다.
     * 각 등수는 ranks에 저장하고 0 인덱스는 5등, 1 인덱스는 4등처럼 저장되어 1등까지 저장한다.
     * 당첨 통계
     */
    public void run() {
        int costOfLotto = getCostOfLotto();
        int numberOfLotto = costOfLotto / PRICE_OF_LOTTO;
        List<List<Integer>> myLottoNumbers = getMyLottoNumbers(numberOfLotto);
        List<Integer> lottoNumbers = getLottoNumbers();
        int bonus = getBonus(lottoNumbers);
        List<Integer> ranks = getRanks(numberOfLotto, lottoNumbers, bonus, myLottoNumbers);
        getResult(costOfLotto, ranks);
    }

    private void getResult(int costOfLotto, List<Integer> ranks) {
        System.out.println("---");
        double profit = 0.0;
        for (int i = 0; i < NUMBER_OF_RANKS; i++) {
            if (i == 0){
                System.out.println(LottoRank.five.getResult(ranks.get(i)));
                profit += LottoRank.five.getWinningPrice() * ranks.get(i);
            }
            if (i == 1){
                System.out.println(LottoRank.four.getResult(ranks.get(i)));
                profit += LottoRank.four.getWinningPrice() * ranks.get(i);
            }
            if (i == 2){
                System.out.println(LottoRank.three.getResult(ranks.get(i)));
                profit += LottoRank.three.getWinningPrice() * ranks.get(i);
            }
            if (i == 3){
                System.out.println(LottoRank.two.getResult(ranks.get(i)));
                profit += LottoRank.two.getWinningPrice() * ranks.get(i);
            }
            if (i == 4){
                System.out.println(LottoRank.one.getResult(ranks.get(i)));
                profit += LottoRank.one.getWinningPrice() * ranks.get(i);
            }
        }
        System.out.printf("총 수익률은 %f%입니다.", profit / costOfLotto);
    }

    private List<Integer> getRanks(int numberOfLotto, List<Integer> lottoNumbers, int bonus, List<List<Integer>> myLottoNumbers) {
        List<Integer> ranks = new ArrayList<>(IntStream.range(0, NUMBER_OF_RANKS).boxed().map(num -> 0).toList());
        for (int i = 0; i < numberOfLotto; i++) {
            int rank = getRank(lottoNumbers, bonus, myLottoNumbers, i);
            ranks.set(rank, ranks.get(rank) + 1);
        }
        return ranks;
    }

    private List<List<Integer>> getMyLottoNumbers(int numberOfLotto) {
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

    private int getRank(List<Integer> lottoNumbers, int bonus, List<List<Integer>> myLottoNumbers, int i) {
        List<Integer> numbers = myLottoNumbers.get(i);
        long count = numbers.stream()
                .filter(lottoNumbers::contains)
                .count();
        if (count >= 6) return 4;
        if (count == 5) {
            if (lottoNumbers.contains(bonus)) return 3;
            return 2;
        }
        if (count == 4) return 1;
        return 0;
    }

    private int getCostOfLotto() {
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
    private int getCostOfLottoWithChainedException() throws IllegalArgumentException {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int cost = scanner.nextInt();
            if (cost % 1000 != 0) {
                System.out.println(ExceptionMessage.로또_구입_비용_천원단위가아닌경우);
                throw new IllegalArgumentException();
            }
            return cost;
        } catch (InputMismatchException ime) {
            System.out.println(ExceptionMessage.로또_구입비용_숫자가아닐때);
            throw new IllegalArgumentException(ime);
        }
    }

    /**
     * 당첨 번호를 1에서 45 사이의 값을 확인하는 메서드를
     * isNumberIn1And45 말고 더 좋은 이름은 없을까?
     */
    private List<Integer> getLottoNumbers() {
        Lotto lotto = null;
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            List<String> numbers = Arrays.asList(scanner.next().split(","));
            lotto = new Lotto(numbers.stream().map(Integer::parseInt).sorted().toList());
            if (isNumberIn1And45(lotto)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.당첨번호_1_45_사이가아닌경우);
            getLottoNumbers();
        }

        return lotto.getNumbers();
    }

    private static boolean isNumberIn1And45(Lotto lotto) {
        return lotto.getNumbers().stream().anyMatch(number -> number < 1 || 45 < number);
    }

    private int getBonus(List<Integer> lotto) {
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

        return bonus;
    }

    private int getBonusWithChainedException() throws IllegalArgumentException {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            return scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println(ExceptionMessage.보너스번호가_숫자가아닐때);
            throw new IllegalArgumentException(ime);
        }
    }

    private void isNotDuplicateNumberWithLotto(Lotto lotto, int bonus) throws IllegalArgumentException {
        for (Integer number : lotto.getNumbers()) {
            if (number.equals(bonus)) {
                System.out.println(ExceptionMessage.보너스번호_중복);
                throw new IllegalArgumentException();
            }
        }
    }
}
