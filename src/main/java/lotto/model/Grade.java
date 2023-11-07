package lotto.model;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public int getHit() {
        return hit;
    }

    public int getAccount() {
        return account;
    }

    public String getComment() {
        return comment;
    }

    private static final Map<Integer, Grade> BY_HIT =
            Stream.of(values()).collect(Collectors.toMap(Grade::getHit, e -> e, (SECOND, THIRD) -> THIRD));

    public static Grade valueOfHit(int hit, boolean isBonus) {
        if(isBonus) return SECOND;
        return BY_HIT.get(hit);
    }
}
