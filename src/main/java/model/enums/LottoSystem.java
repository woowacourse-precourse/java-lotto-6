/**
 * @Package_name : model.enums
 * @Enum_name : LottoSystem
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package model.enums;

public enum LottoSystem {
    LOTTO_SET_LENGTH(6),
    LOTTO_MAX_RANGE(45),
    LOTTO_MIN_RANGE(1);

    private final int value;

    LottoSystem(int value) {
        this.value = value;
    }

    /**
     * Description : 요청 수 반환
     *
     * @Method : getValue()
     * @return : int
     */
    public int getValue() {
        return value;
    }
}
