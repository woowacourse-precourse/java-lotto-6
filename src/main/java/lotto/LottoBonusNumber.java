package lotto;

public record LottoBonusNumber(
        int value
) {

    public LottoBonusNumber {
        if (value < Lotto.MIN_NUMBER || value > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("로또 숫자의 범위는 %d에서 %d 사이여야 합니다.", Lotto.MIN_NUMBER, Lotto.MAX_NUMBER));
        }
    }
}
