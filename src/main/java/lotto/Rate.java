package lotto;

public enum Rate {
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    SIXTH(6);

    private final int matchingNumbers;
    // 생성자
    Rate(int matchingNumbers) {
        this.matchingNumbers = matchingNumbers;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

}

