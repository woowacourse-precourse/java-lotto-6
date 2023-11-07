package lotto.model;

import static lotto.model.Constants.*;

public enum Grade {
    FIRST(6, 2000000000,RESULT_GRADE_FIRST),
    SECOND(5,30000000, RESULT_GRADE_SECOND),
    THIRD(5, 1500000, RESULT_GRADE_THIRD),
    FOURTH(4, 50000, RESULT_GRADE_FOURTH),
    FIFTH(3, 5000, RESULT_GRADE_FIFTH);

    private final int hit;
    private final int account;
    private final String comment;

    Grade(int hit, int account, String comment) {
        this.hit = hit;
        this.account = account;
        this.comment = comment;
    }
}
