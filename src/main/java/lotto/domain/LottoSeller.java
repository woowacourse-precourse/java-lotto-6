package lotto.domain;

public class LottoSeller {
    public static final int Lotto_Price = 1_000;

    public int calculateNumberOfLottos(int money) {
        validatePurchaseAmount(money);
        int LottosAmount = money / Lotto_Price;

        return LottosAmount;
    }

    public Lottos getLottos(int money) {
        int numberOfLottos = calculateNumberOfLottos(money);

        return Lottos.createLottos(numberOfLottos);
    }

    public void validatePurchaseAmount(int money) {
        if (money % Lotto_Price != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
