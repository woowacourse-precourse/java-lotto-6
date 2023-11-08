package lotto;

public enum Rank {
    FIRST("6개 일치 (2,000,000,000원) - "),//"3개 일치 (5,000원) -"
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),//"4개 일치 (50,000원) -"
    THIRD("5개 일치 (1,500,000원) - "),//arr[2]
    FOURTH("4개 일치 (50,000원) - "),//arr[1]
    FIFTH("3개 일치 (5,000원) - ");//arr[0]

    private final String ment;
    private final String last_ment="개";

    Rank(String ment) {
        this.ment=ment;
    }

    public String getMent(){
        return ment;
    }

    public String getLastMent(){
        return last_ment;
    }
}
