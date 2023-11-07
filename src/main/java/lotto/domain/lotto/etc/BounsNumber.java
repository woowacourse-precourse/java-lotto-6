package lotto.domain.lotto.etc;

public class BounsNumber {
    private final int bounsNumber;

    public BounsNumber(int number) {
        this.bounsNumber = number;
    }

    public int getBounsNumber() {
        return bounsNumber;
    }

    public void bonusnumNyRange() {
        if (bounsNumber > 45 || bounsNumber < 1) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자를 입력해주세요.");
        }
    }
}
