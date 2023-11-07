package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        // 기능4. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고,
        // "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호에 중복이 있습니다.");
        }
        if (!isInRange(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현

        // 기능1. 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 1장 당 1000원의 로또를 발행해야 한다.
        // 1000원으로 나눠 떨어지지 않는 경우 예외처리를 한다.
        final static int LOTTO_PRICE = LottoConstants.PRICE.getValue();
        public static List<Lotto> buyLottos(int amount) {
                if(amount % LOTTO_PRICE != 0) {
                        throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_PRICE + "원 단위로 입력 가능합니다.");
                }
                int numberOfLottos = amount / LOTTO_PRICE;
                List<Lotto> lottos = new ArrayList<>();
                for (int i = 0; i < numberOfLottos; i++) {
                    lottos.add(getLotto());
                }
                return lottos;
        }

        private static Lotto getLotto() {
                List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
                Collections.sort(numbers);
                return new Lotto(numbers);
        }

        public int numOfMatches(Set<Integer> winningNumbers) {
                int matches = 0;
                for (int number : numbers) {
                        if(winningNumbers.contains(number)) {
                                matches++;
                        }
                }
                return matches;
        }

        public boolean hasBonusNumber(int bonusNumber) {
            return numbers.contains(bonusNumber);
        }

        // 기능4. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고,
        // "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
        private boolean hasDuplicate(List<Integer> numbers) {
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            return uniqueNumbers.size() != numbers.size();
        }

        private boolean isInRange(List<Integer> numbers) {
            return numbers.stream().allMatch(number -> number >= LottoConstants.MIN_NUMBER.getValue() && number <= LottoConstants.MAX_NUMBER.getValue());
        }
}
