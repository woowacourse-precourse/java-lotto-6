package lotto.util.validate;

public class DomainValidate {

    public static void validateOutOfRankingIndex(int rank) {
        if (rank > 6) {
            throw new IllegalStateException("[ERROR] 잘못된 랭킹입니다. 랭킹은 1등부터 5등 사이여야 합니다.");
        }
    }

    public static void validateDivideZeroDenominator(int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 크기입니다. 0으로 나눌 수 없습니다.");
        }
    }
}
