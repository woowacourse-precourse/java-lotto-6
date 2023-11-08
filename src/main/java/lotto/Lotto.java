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
        Integer rank = Rank.LOSE_PLACE.getRank();
        rank = calcFirstPlaceNumber(sameCount, rank);
        rank = calcSecondOrThirdPlaceNumber(sameCount, bonusNumber, rank);
        rank = calcFourthPlaceNumber(sameCount, rank);
        rank = calcFifthPlaceNumber(sameCount, rank);
        return rank;
    }

    public boolean containsBonusNumber(Integer bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    private int calcFirstPlaceNumber(Integer sameCount, Integer rank) {
        if (sameCount == LottoPrinciples.SIXTH_MATCHES.getNumber()) {
            return Rank.FIRST_PLACE.getRank();
        }
        return rank;
    }

    private int calcSecondOrThirdPlaceNumber(Integer sameCount, Integer bonusNumber, Integer rank) {
        if (sameCount == LottoPrinciples.FIFTH_MATCHES.getNumber()) {
            if (containsBonusNumber(bonusNumber)) {
                return Rank.SECOND_PLACE.getRank();
            }
            return Rank.THIRD_PLACE.getRank();
        }
        return rank;
    }

    private int calcFourthPlaceNumber(Integer sameCount, Integer rank) {
        if (sameCount == LottoPrinciples.FOURTH_MATCHES.getNumber()) {
            return Rank.FOURTH_PLACE.getRank();
        }
        return rank;
    }

    private int calcFifthPlaceNumber(Integer sameCount, Integer rank) {
        if (sameCount == LottoPrinciples.FIFTH_MATCHES.getNumber()) {
            return Rank.FIFTH_PLACE.getRank();
        }
        return rank;
    }
}
