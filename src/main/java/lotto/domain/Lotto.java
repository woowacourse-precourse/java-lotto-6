package lotto.domain;

import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || hasDuplicates(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int calculateMatchingCount(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public int calculateBonusCount(int bonusNumber) {
        int bonusCount = 0;
        if (numbers.contains(bonusNumber)) {
            bonusCount++;
        }
        return bonusCount;
    }

    public void updateLottoResult(Map<String, Integer> lottoResult, int matchingCount, int bonusCount) {
        LottoRank lottoRank = LottoRank.findByMatchCount(matchingCount, bonusCount);
        if (lottoRank != null) {
            String rank = lottoRank.getRank();
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
