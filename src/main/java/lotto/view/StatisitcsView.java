package lotto.view;

public enum StatisitcsView {
    FIRST(1,"6개 일치 (2,000,000,000원) - "),
    SECOND(2,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(3,"5개 일치 (1,500,000원) - "),
    FOURTH(4,"4개 일치 (50,000원) - "),
    FIFTH(5,"3개 일치 (5,000원) - ");

    private String message;

    private int rank;

    StatisitcsView(int rank, String message) {
        this.rank = rank;
        this.message = message;
    }
    public int getRank() {
        return rank;
    }
    public String getMessage() {
        return message;
    }

    public static String getStatistics(int rank){
        for(StatisitcsView statisitcsView: StatisitcsView.values()){
            if(statisitcsView.getRank() == rank){
                return statisitcsView.getMessage();
            }
        }
        return "";
    }
}
