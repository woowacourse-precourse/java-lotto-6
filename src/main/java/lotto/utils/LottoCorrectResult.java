package lotto.utils;

public enum LottoCorrectResult {
    NONE(0, LottoPlace.NONE), THREE(3, LottoPlace.FIFTH), FOUR(4, LottoPlace.FOURTH), FIVE(5, LottoPlace.THIRD), SIX(6, LottoPlace.FIRST);

    private final int minCorrectCount;
    private final LottoPlace lottoPlace;

    LottoCorrectResult(int correctCount, LottoPlace lottoPlace) {
        minCorrectCount = correctCount;
        this.lottoPlace = lottoPlace;
    }

    public int getMinCorrectCount() {
        return this.minCorrectCount;
    }

    public LottoPlace getLottoPlace() {
        return this.lottoPlace;
    }
}
