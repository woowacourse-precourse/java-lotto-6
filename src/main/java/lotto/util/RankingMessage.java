package lotto.util;

public enum RankingMessage {
    FIRST_RANK(LottoValues.MAX_CHECK_NUMBER +"개 일치 ("+RewardValue.FIRST_REWARD+"원)"),
    SECOND_RANK((LottoValues.MAX_CHECK_NUMBER-1) +"개 일치, 보너스 볼 일치 ("+RewardValue.SECOND_REWARD+"원)"),
    THIRD_RANK((LottoValues.MAX_CHECK_NUMBER-1) +"개 일치 ("+RewardValue.THIRD_REWARD+"원)"),
    FOURTH_RANK((LottoValues.MAX_CHECK_NUMBER-2) +"개 일치 ("+RewardValue.FOURTH_REWARD+"원)"),
    FIFTH_RANK((LottoValues.MIN_CHECK_NUMBER) +"개 일치 ("+RewardValue.FIFTH_REWARD+"원)");

    private String message;

    RankingMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
