package lotto.domain;

public class LottoAmount {
    private static final int LOTTO_PRICE = 1000;
    private final long amount;
    public LottoAmount(long amount) {
        validateAmount(amount);
        this.amount = amount;
    }
    public long calculateLottoAmount(int lottoAmount) {
        return lottoAmount / LOTTO_PRICE;
    }

    public static void validateAmount(long amount) {
        validateMinAmount(amount);
        validateRemainderDivisionBy1000(amount);
    }

    private static void validateMinAmount(long amount) {
        if (amount < LOTTO_PRICE) {
            System.out.println("[ERROR] 최소 입력 금액은 1,000입니다.");
            throw new IllegalArgumentException("[ERROR] 최소 입력 금액은 1,000입니다.");
        }
    }

    private static void validateRemainderDivisionBy1000(long amount) {
        if (amount % LOTTO_PRICE != 0) {
            System.out.println("[ERROR] 입력 금액은 1,000원 단위로 입력이 필요합니다.");
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1,000원 단위로 입력이 필요합니다.");
        }
    }

    public long getLottoAmount() {
        return amount;
    }
}