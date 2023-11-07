package lotto.model;

public enum OutputByRank {
    FIFTH(5,"3개 일치 (5,000원) - ",5000),
    FOURTH(4,"4개 일치 (50,000원) - ",50000),
    THIRD(3,"5개 일치 (1,500,000원) - ",1500000),
    SECOND(2,"5개 일치, 보너스 볼 일치 (30,000,000원) - ",30000000),
    FIRST(1,"6개 일치 (2,000,000,000원) - ",2000000000);

    private String outputByRank;
    private int rank;
    private int price;

    private OutputByRank(int rank,String outputByRank,int price) {
        this.rank = rank;
        this.outputByRank = outputByRank;
        this.price = price;
    }

    public String getOutput() {
        return outputByRank;
    }

    public int getRank() {
        return rank;
    }
}
