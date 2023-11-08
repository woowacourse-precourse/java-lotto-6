package lotto.domain;

public enum Grade {
    FIRST("6개 일치 (2,000,000,000원)", 2000000000D),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000D),
    THIRD("5개 일치 (1,500,000원)", 1500000D),
    FOURTH("4개 일치 (50,000원)", 50000D),
    FIFTH("3개 일치 (5,000원)", 5000D),
    NOTHING("", 0D);

    private final String message;
    private final Double prize;

    Grade(String message, Double prize) {
        this.message = message;
        this.prize = prize;
    }

    public static Grade judge(Integer matchNum, Boolean bonus){
        if(matchNum == 6) return FIRST;

        if(matchNum == 5 && bonus) return SECOND;

        if(matchNum == 5) return THIRD;

        if(matchNum == 4) return FOURTH;

        if(matchNum == 3) return FIFTH;

        return NOTHING;
    }

    public String getMessage(){
        return message;
    }

    public Double getPrize(){
        return prize;
    }

}
