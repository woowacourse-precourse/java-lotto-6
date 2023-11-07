package lotto.ui;

import lotto.LottoScore;

public enum LottoResult {
    FIRST_PLACE(LottoScore.FIRST_PLACE, "6개 일치 (2,000,000,000원) - %S개"),
    SECOND_PLACE(LottoScore.SECOND_PLACE, "5개 일치, 보너스 볼 일치 (30,000,000원) - %S개"),
    THIRD_PLACE(LottoScore.THIRD_PLACE, "5개 일치 (1,500,000원) - %S개"),
    FOURTH_PLACE(LottoScore.FOURTH_PLACE, "4개 일치 (50,000원) - %S개"),
    FIFTH_PLACE(LottoScore.FIFTH_PLACE, "3개 일치 (5,000원) - %S개");
    private LottoScore lottoScore;
    private String message;

    LottoResult(LottoScore lottoScore, String message) {
        this.lottoScore = lottoScore;
        this.message = message;
    }

    public LottoScore getLottoScore() {
        return lottoScore;
    }

    public String getMessage(Long count) {
        return String.format(message, count);
    }
}
