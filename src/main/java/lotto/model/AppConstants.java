package lotto.model;

public interface AppConstants {
    enum exceptionMessage {
        INPUT_MUST_NOT_CONTAINS_SPACE("[ERROR]] 공백없이 입력해주세요."),
        INPUT_MUST_BE_NUMERIC("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        INPUT_MUST_BE_1000s("[ERROR] 로또 가격은 1000원 단위로 입력해주세요."),
        INPUT_MUST_BE_6s("[ERROR] 로또 번호는 6개여야 합니다."),
        INPUT_MUST_BE_UNIQUE("[ERROR] 중복된 숫자가 있습니다."),
        INPUT_MUST_BE_FALSENESS("[ERROR] 입력을 다시한번 확인해주세요."),
        INPUT_MUST_BE_NOTNULL("[ERROR] 입력은 null이 될 수 없습니다.");

        public final String message;

        exceptionMessage(final String message) {
            this.message = message;
        }
    }

    enum lottoConstants {
        LOTTO_NUMBER_MAX(45),
        LOTTO_NUMBER_MIN(1),
        TOTAL_LOTTO_NUMBER_COUNT(6),
        LOTTO_TICKET_PRICE(1000);

        public final int constantName;

        lottoConstants(final int constantName) {
            this.constantName = constantName;
        }

        public int getValue() {
            return constantName;
        }

    }

    enum lottoMatchingConstants {
        MATCHING_3("5등",5_000),
        MATCHING_4("4등",50_000),
        MATCHING_5("3등",1_500_000),
        MATCHING_5_AND_BONUS("2등",30_000_000),
        MATCHING_6("1등",2_000_000_000);

        public final String grade;
        public final int prizeAmount;

        lottoMatchingConstants(final String grade,final int prizeAmount) {
            this.grade = grade;
            this.prizeAmount = prizeAmount;
        }

        public int getValue() {
            return prizeAmount;
        }
    }

}
