package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static List<Integer> generateRandomNumbers() {
        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < LOTTO_SIZE) {
            int number = random.nextInt(MAX_NUMBER) + 1;
            uniqueNumbers.add(number);
        }

        return new ArrayList<>(uniqueNumbers);
    }

    public LottoResult calculateMatch(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> matchedNumbers = numbers.stream()
                .filter(winningNumbers::contains)
                .collect(Collectors.toList());

        boolean hasBonus = matchedNumbers.contains(bonusNumber);

        if (matchedNumbers.size() == 6) {
            return new LottoResult(1, hasBonus);
        } else if (matchedNumbers.size() == 5 && hasBonus) {
            return new LottoResult(2, hasBonus);
        } else if (matchedNumbers.size() == 5) {
            return new LottoResult(3, hasBonus);
        } else if (matchedNumbers.size() == 4) {
            return new LottoResult(4, hasBonus);
        } else if (matchedNumbers.size() == 3) {
            return new LottoResult(5, hasBonus);
        } else {
            return new LottoResult();
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호의 개수가 6개가 아닙니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }

        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }
}
