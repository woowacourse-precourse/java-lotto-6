package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RunApplication {

    private final static Scanner scanner =  new Scanner(System.in);
    private final int PRICE_OF_LOTTO = 1000;

    public void run() {
        // 로또 구매비용과 당첨비용, 보너스 번호 입력
        int costOfLotto = getCostOfLotto();
        int numberOfLotto = costOfLotto / PRICE_OF_LOTTO;
        List<Integer> lottoNumbers = getLottoNumbers();
        int bonus = getBonus(lottoNumbers);

        // 구입한 수만큼 로또를 발행한다.
        System.out.printf("%d개를 구매했습니다.\n", numberOfLotto);
        List<List<Integer>> myLottoNumbers = getMyLottoNumbers(numberOfLotto);

        // 발행한 로또의 등수를 확인한다.
        // 각 등수는 ranks에 저장하고 1 인덱스는 1등, 2 인덱스는 2등처럼 저장되어 최대 5등까지 저장한다.
        List<Integer> ranks = getRanks(numberOfLotto, lottoNumbers, bonus, myLottoNumbers);
    }

    private List<Integer> getRanks(int numberOfLotto, List<Integer> lottoNumbers, int bonus, List<List<Integer>> myLottoNumbers) {
        List<Integer> ranks = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
        for (int i = 0; i < numberOfLotto; i++) {
            int rank = getRank(lottoNumbers, bonus, myLottoNumbers, i);
            ranks.set(rank, ranks.get(rank) + 1);
        }
        return ranks;
    }

    private static List<List<Integer>> getMyLottoNumbers(int numberOfLotto) {
        List<List<Integer>> myLottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myLottoNumbers.add(numbers);
            System.out.println(numbers);
        }
        return myLottoNumbers;
    }

    private int getRank(List<Integer> lottoNumbers, int bonus, List<List<Integer>> myLottoNumbers, int i) {
        List<Integer> numbers = myLottoNumbers.get(i);
        long count = numbers.stream()
                .filter(lottoNumbers::contains)
                .count();
        if (count >= 6) return 1;
        if (count == 5) {
            if (lottoNumbers.contains(bonus)) return 2;
            return 3;
        }
        if (count == 4) return 4;
        return 5;
    }

    private int getCostOfLotto() {
        int cost;
        try {
            cost = getCostOfLottoWithChainedException();
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
