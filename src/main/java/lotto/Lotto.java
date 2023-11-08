package lotto;

import java.util.List;
import java.util.stream.Stream;

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
    }

    public void printLottoNumbers() {
        System.out.println(this.numbers);
    }

    public int calcSameNumberCount(List<Integer> otherList) {
        Stream<Integer> allNumbers = Stream.concat(this.numbers.stream(), otherList.stream());
        int sameCount = LottoPrinciples.MAX_SUM_COUNT.getNumber();
        sameCount -= (int) allNumbers.distinct().count();
        return sameCount;
    }

    public int getRank(List<Integer> otherList, Integer bonusNumber) {
        Integer sameCount = calcSameNumberCount(otherList);
        if (sameCount == LottoPrinciples.SIXTH_MATCHES.getNumber()) {
            return WinnerRank.FIFTH_PLACE.getRank();
        } else if (sameCount == LottoPrinciples.FIFTH_MATCHES.getNumber()) {
            if (containsBonusNumber(bonusNumber)) {
                return WinnerRank.FIFTH_PLACE.getRank();
            }
            return WinnerRank.THIRD_PLACE.getRank();
        } else if (sameCount == LottoPrinciples.FOURTH_MATCHES.getNumber()) {
            return WinnerRank.FOURTH_PLACE.getRank();
        }
        return WinnerRank.FIFTH_PLACE.getRank();
    }

    public boolean containsBonusNumber(Integer bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }
}
