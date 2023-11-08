package lotto;

public enum LottoResults {
    FIRST(0),SECOND(0),THIRD(0),FOURTH(0),FIFTH(0);

    private Integer counts;

    LottoResults(Integer counts){
        this.counts = counts;
    }

    public Integer getCounts() {
        return counts;
    }

    public void addCounts(){this.counts += 1;}

    public void setCounts(Integer count) {this.counts = count;}
}



