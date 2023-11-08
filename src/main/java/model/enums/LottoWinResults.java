/**
 * @Package_name : model.enums
 * @Enum_name : LottoResults
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package model.enums;

public enum LottoWinResults {
    LOTTO_3SAME("3개 일치"),
    LOTTO_4SAME("4개 일치"),
    LOTTO_5SAME("5개 일치"),
    LOTTO_5SAME_BONUS("5개 일치, 보너스 볼"),
    LOTTO_6SAME("6개 일치"),
    LOTTO_NOTHING("nothing");

    private final String lottoResult;

    LottoWinResults(String lottoResult) {
        this.lottoResult = lottoResult;
    }

    /**
     * Description : 로또 상 결과 메세지 반환
     *
     * @Method : getMessage()
     * @return : String
     */
    public String getMessage() {
        return this.lottoResult;
    }
}