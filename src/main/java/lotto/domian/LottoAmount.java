package lotto.domian;

public class LottoAmount {
    public long lottoAmount(long amount) {
        validateAmount(amount);
        return amount / 1000;
    }

    public static void validateAmount(long amount) {
        validateMinAmount(amount);
        validateRemainderDivisionBy1000(amount);
    }

    private static void validateMinAmount(long amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("최소 입력 금액은 1,000입니다.");
        }
    }

    private static void validateRemainderDivisionBy1000(long amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("입력 금액은 1,000원 단위로 입력이 필요합니다.");
        }
    }
}