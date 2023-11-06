package lotto.model;

public enum Prize {
    First(6,2_000_000_000,"6개 일치 (2,000,000,000원ㄴ) -"),
    Second(5,20_000_000,"5개 일치, 보너스 볼 일치 (30,000,000원) -"),
    Third(5,1_500_000,"5개 일치 (1,500,000원) -"),
    Fourth(4,50_000,"4개 일치 (50,000원) -"),
    Fifth(3,5_000,"3개 일치 (5,000원) -"),
    Miss(0,0,"");

    private int matchOfLotto;
    private int prizeOfLotto;
    private String message;

    Prize(int matchOfLotto, int prizeOfLotto, String message) {
        this.matchOfLotto = matchOfLotto;
        this.prizeOfLotto = prizeOfLotto;
        this.message = message;
    }

    public static Prize valueOf(int countOfMatch, boolean checkBonus){
        if(countOfMatch < 3){
            return Miss;
        }
        if(countOfMatch == Prize.Fifth.matchOfLotto){
            return Fifth;
        }
        if(countOfMatch == Prize.Fourth.matchOfLotto){
            return Fourth;
        }
        if(countOfMatch == Prize.Third.matchOfLotto && !checkBonus){
            return Third;
        }
        if(countOfMatch == Prize.Second.matchOfLotto && checkBonus){
            return Second;
        }
        return First;
    }

    public static String printMessage(Prize prize){
        return prize.message;
    }

}
