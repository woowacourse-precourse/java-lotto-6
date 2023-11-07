package lotto.global.constant.exception;

public enum ExceptionMessage {
    EXCEPTION_PREFIX("[ERROR] ")
    ,NUMBERS_DUPLICATED("숫자는 중복으로 입력하면 안됩니다.")
    ,BONUS_NUMBER_DUPLICATED("보너스 숫자가 당첨 번호와 중복됩니다.")
    ,NUMBERS_COUNT_MUST_BE_SIX("당첨 숫자 개수는 6개입니다.")
    ,NUMBERS_OUT_OF_RANGE("숫자가 범위 밖입니다.")
    ,INPUT_CANNOT_BE_NULL("입력을 해주세요.")
    ,MONEY_LESS_THAN_TEN_BILLION("10억원 미만으로 구매해야 합니다.")
    ,MONEY_DIVIDED_INTO_THOUSAND("돈은 1000원 단위로 나누어 져야 합니다.")
    ,MONEY_MORE_THAN_THOUSAND("돈은 1000원 이상 입금해야 합니다.")
    ,ILLEGAL_MATCH_COUNT("잘못된 matchCount 입력")
    ,MAX_INPUT_ATTEMPT_COUNT("입력 횟수 5번 초과")
    ;

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_PREFIX.message + message;
    }
}
