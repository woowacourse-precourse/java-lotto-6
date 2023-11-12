package lotto.util;

import lotto.constant.Grade;

public class GradeUtil {
    public static Grade gradeMapper(int corrects, boolean bonus) {
        if (corrects == 6) {
            return Grade.FIRST_GRADE;
        }
        if (corrects == 5) {
            return isBonus(bonus);
        }
        if (corrects == 4) {
            return Grade.FORTH_GRADE;
        }
        if (corrects == 3) {
            return Grade.FIFTH_GRADE;
        }
        return Grade.NONE;
    }

    private static Grade isBonus(boolean bonus) {
        if (bonus) {
            return Grade.SECCOND_GRADE;
        }
        return Grade.THIRD_GRADE;
    }
}
