/**
 * @Package_name : model.enums
 * @Enum_name : LottoError
 * <p>
 * Create Date : 2023-11-08 Create User : 정은채
 */
package model.enums;

public enum LottoError {
    LOTTO_NUM_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.\n"),
    LOTTO_NUMBER_RIGHT("로또 번호는 숫자여야 합니다\n"),
    PRIZE_1000("금액은 1000로 나눠져야 합니다\n"),
    LOTTO_LIST_SIX("로또 숫자는 6개여야 합니다.\n"),
    LOTTO_NUM_SAME("로또 숫자는 겹치는 숫자가 없어야 합니다.\n"),
    ERROR("[ERROR]");


    private final String lottoError;

    LottoError(String lottoError) {
        this.lottoError = lottoError;
    }

    /**
     * Description : 로또 에러 메세지 반환
     *
     * @Method : getMessage()
     * @return : String
     */
    public String getErrorMessage() {
        return this.lottoError;
    }
}
