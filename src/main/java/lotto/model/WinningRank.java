package lotto.model;

public enum WinningRank {
    MISS(0, 0, ""),
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    THIRD(5, 150000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRTH(6, 2000000000, "6개 일치 (2,000,000,000원) - ");
    private static final int WINNING_MIN_COUNT = 3;
    private static final String ERROR_MESSAGE = "[ERROR]";

    private int countOfCorrect;
    private int reward;
    private String message;

    WinningRank(int countOfCorrect, int reward, String message) {
        this.countOfCorrect = countOfCorrect;
        this.reward = reward;
        this.message = message;
    }
    public static WinningRank resultLotto(int matchCount, boolean bonus){
        if(matchCount<WINNING_MIN_COUNT){
            return MISS;
        }
        if(matchCount==3 ){
            return FIFTH;
        }
        if(matchCount == 4){
            return FOURTH;
        }
        if(matchCount==5&&!bonus) {
            return THIRD;
        }
        if(matchCount==5 && bonus){
            return SECOND;
        }
        if(matchCount==6){
            return FIRTH;
        }
        throw new IllegalArgumentException("[ERROR]");
    }


    public int getCountOfCorrect(){
        return countOfCorrect;
    }
    public int getReward(){
        return reward;
    }
    public String getMessage(){
        return message;
    }



}
