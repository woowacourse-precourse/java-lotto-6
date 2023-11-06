package lotto.view.constant;

import java.util.Arrays;
import java.util.List;

public enum LottoGrade {
    THREE_GRADE(3, 5000,"3개 일치 (5,000원) - "),
    FOUR_GRADE(4, 50000,"4개 일치 (50,000원) - "),
    FIVE_GRADE(5, 1500000,"5개 일치 (1,500,000원) - "),
    FIVE_GRADE_AND_BONUS(5, 30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_GRADE(6, 2000000000,"6개 일치 (2,000,000,000원) - ");
    private final Integer matchCount;
    private final Integer prize;
    private final String comment;
    LottoGrade(Integer matchCount, Integer prize, String comment){
        this.matchCount = matchCount;
        this.prize = prize;
        this.comment = comment;
    }
    public Integer getMatchCount() {
        return matchCount;
    }
    public Integer getPrize() {
        return prize;
    }
    public String getComment() {
        return comment;
    }
    public String getComment(Integer count) {
        return comment + count + LottoMessage.COMMENT_SUFFIX.getMessage();
    }
}
