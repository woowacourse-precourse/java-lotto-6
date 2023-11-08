package lotto.contants;

public class OutputEnum {
    public enum output{

        ERR_AMOUNT_MUST_BE_NUMBER("[ERROR] 구입 금액은 숫자여야 합니다."),
        ERR_LOTTO_MUST_BE_NUMBER("[ERROR] 로또 번호는 숫자여야 합니다."),
        ERR_LOTTO_MUST_BE_SIX_NUMBER("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
        ERR_LOTTO_NOT_IN_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        ERR_LOTTO_DUPLICATED("[ERROR] 로또 번호는 중복되지 않은 숫자여야 합니다."),
        ERR_BONUS_MUST_BE_NUMBER("[ERROR] 보너스 번호는 숫자여야 합니다."),
        ERR_BONUS_NOT_IN_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
        ERR_BONUS_DUPLICATED("[ERROR] 보너스 번호는 당첨번호와 중복되지 않는 숫자여야 합니다."),

        WINNING_STATISTICS("당첨 통계"),
        ___("---"),
        THREE_MATCH("3개 일치 (5,000원) - "),
        FOUR_MATCH("4개 일치 (50,000원) - "),
        FIVE_MATCH("5개 일치 (1,500,000원) - "),
        FIVE_MATCH_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        SIX_MATCH("6개 일치 (2,000,000,000원) - "),
        COUNT("개"),

        PROFIT_RATE_IS("총 수익률은 "),
        PERCENTAGE("%입니다.");


        private final String description;

        output(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
