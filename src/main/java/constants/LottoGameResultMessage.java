package constants;

public enum LottoGameResultMessage {

    LOTTO_3_WINNING("3개 일치 (5,000원) - {lotto_3}개","{lotto_3}"),
    LOTTO_4_WINNING("4개 일치 (50,000원) - {lotto_4}개","{lotto_4}"),
    LOTTO_5_WINNING("5개 일치 (1,500,000원) - {lotto_5}개","{lotto_5}"),
    LOTTO_5_BONUS_WINNING("5개 일치, 보너스 볼 일치 (30,000,000원) - {lotto_5_bonus}개","{lotto_5_bonus}"),
    LOTTO_6_WINNING("6개 일치 (2,000,000,000원) - {lotto_6}개","{lotto_6}"),
    PROFIT_RATE("총 수익률은 {profit_rate}%입니다.","{profit_rate}");

    private String message;
    private String messageReplace;

    LottoGameResultMessage(String message, String messageReplace){
        this.message = message;
        this.messageReplace = messageReplace;
    }

    public String replaceEnumToString(String winningCount){
        return this.message.replace(this.messageReplace, winningCount);
    }

}
