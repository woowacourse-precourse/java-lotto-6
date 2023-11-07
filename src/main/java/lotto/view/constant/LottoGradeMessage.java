package lotto.view.constant;

public enum LottoGradeMessage {

    THREE_GRADE(0,3, 5000,"3개 일치 (5,000원) - "),
    FOUR_GRADE(1,4, 50000,"4개 일치 (50,000원) - "),
    FIVE_GRADE(2,5, 1500000,"5개 일치 (1,500,000원) - "),
    FIVE_GRADE_AND_BONUS(3,5, 30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_GRADE(4,6, 2000000000,"6개 일치 (2,000,000,000원) - ");
    private final Integer index;
    private final Integer matchCount;
    private final Integer prize;
    private final String comment;
    LottoGradeMessage(Integer index,Integer matchCount, Integer prize, String comment){
        this.index = index;
        this.matchCount = matchCount;
        this.prize = prize;
        this.comment = comment;
    }
    public Integer getPrize() {
        return this.prize;
    }
    public String getComment() {
        return this.comment;
    }
    public Integer getIndex() {
        return this.index;
    }
    public String getComment(Integer count) {
        return this.comment + count + LottoMessage.COMMENT_SUFFIX.getMessage();
    }
}
