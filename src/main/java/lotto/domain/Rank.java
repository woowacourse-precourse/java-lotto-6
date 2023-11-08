package lotto.domain;

public enum Rank {
    first(6,2000000000,"6개 일치 (2,000,000,000원) - "),
    second(5,30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    third(5,1500000,"5개 일치 (1,500,000원) - "),
    fourth(4,50000,"4개 일치 (50,000원) - "),
    fifth(3,5000,"3개 일치 (5,000원) - ");

    String message;
    int value, prize;

    Rank(int value, int prize, String message){
        this.value=value;
        this.message=message;
        this.prize = prize;
    }

    public int getValue(){
        return value;
    }
    public String getMessage(){return message;}
    public int getPrize(){
        return prize;
    }

    public static Rank valueOf(int count, boolean bonusMatch) {
        if (second.value == count && bonusMatch) {
            return second;
        }
        for (Rank rank : values()) {
            if (rank.value == count && rank != second) {
                return rank;
            }
        }
        return null;
    }


}


