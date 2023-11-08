/**
 * @Package_name : model.enums
 * @Enum_name : LottoWinPrize
 * <p>
 * Create Date : 2023-11-08 Create User : 정은채
 */
package model.enums;

public enum LottoWinPrize {
    LOTTO_3SAME_PRIZE(5000),
    LOTTO_4SAME_PRIZE(50000),
    LOTTO_5SAME_PRIZE(1_500_000),
    LOTTO_5SAME_BONUS_PRIZE(30_000_000),
    LOTTO_6SAME_PRIZE(2_000_000_000);
    private final int winPrize;

    LottoWinPrize(int winPrize) {
        this.winPrize = winPrize;
    }

    /**
     * Description : 해당 상금 반환
     *
     * @Method : getValue()
     * @return : int
     */
    public int getValue() {
        return winPrize;
    }
}
