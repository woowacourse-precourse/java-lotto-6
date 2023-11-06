package lotto.io;

import java.util.Map;

public enum LottoPrizeResult {
    // 맞춘 숫자, 보너스여부, 스트링 포멧 문구
    THREE_MATCH
      (3,false,5_000,"3개 일치 ( %,d원 ) - %d개"),
    FOUR_MATCH
      (4,false,50_000,"4개 일치 ( %,d월 ) - %d개"),
    FIVE_MATCH
      (5,false,1_500_000,"5개 일치 ( %,d원 ) - %d개"),
    FIVE_MATCH_WITH_BONUS
      (5,true,30_000_000,"5개 일치, 보너스 볼 일치 ( %,d원 ) - %d개"),
    SIX_MATCH
      (6,false,2_000_000_000,"6개 일치 ( %,d원 ) - %d개");

    private final int matchPoint;
    private final boolean isBonus;
    private final int prizeMoney;
    private final String prizeResultMessage;

    // 생성자
    LottoPrizeResult(int matchPoint,boolean isBonus,int prizeMoney,String prizeResultMessage){
        this.matchPoint = matchPoint;
        this.isBonus = isBonus;
        this.prizeMoney = prizeMoney;
        this.prizeResultMessage = prizeResultMessage;
    }
    // 메시지 가져올 때 사용할 메서드 필요 - count 는 당첨된 티켓의 수를 나타냄
    public String getPrizeResultMessage(int count){
        return String.format(prizeResultMessage, prizeMoney, count);
    }
    // 번호의 일치 개수와 보너스 볼 일치를 체크
    // 당첨 결과 메서드에서 사용할 것임
    public static LottoPrizeResult getPrizeResult(int matchPoint,boolean isBonus){
        for(LottoPrizeResult result : values()){
            if(result.matchPoint == matchPoint && result.isBonus == isBonus){
                return result;
            }
        }
        return null;
    }int 커밋용도로_임시생성 = 1;
    public int getPrizeMoney(){
        return prizeMoney;
    }

}
