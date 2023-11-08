package lotto;


public enum Rank {
    FIRST(6, 1, 2000000000, "6개 일치 (2,000,000,000원) - "), // 1등
    SECOND(5, 2, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    THIRD(5, 3, 1500000, "5개 일치 (1,500,000원) - "), // 3등
    FOURTH(4, 4, 50000, "4개 일치 (50,000원) - "), // 4등
    FIFTH(3, 5, 5000, "3개 일치 (5,000원) - "), // 5등
    MISS(0, 0, 0, "");
    Rank(int countOfMatch, int rank, int reward, String message) {
        this.countOfMatch = countOfMatch;
        this.rank = rank;
        this.reward = reward;
        this.message = message;
    }

    private int countOfMatch, rank, reward;
    private String message;
    public static int[] result;
    public static double returnRate;
    public static double sumReturn;


    public static void calculateEachLottoResult(int countOfMatch, boolean bonusCheck) {
        result = new int[7];
        if (SECOND.matchCount(countOfMatch) && bonusCheck) {
            result[SECOND.rank]++;
        }

        for (Rank rank : values()) {
            if (rank.matchCount(countOfMatch) && rank != SECOND) {
                result[rank.getRank()]++;
            }
        }
    }

    public static void calculateReturnRate(){
        for(int i=1; i<result.length-1; i++){
            if(FIRST.getRank() == i) sumReturn += (FIRST.getReward() * result[i]);
            if(SECOND.getRank() == i) sumReturn += (SECOND.getReward() * result[i]);
            if(THIRD.getRank() == i) sumReturn += (THIRD.getReward() * result[i]);
            if(FOURTH.getRank() == i) sumReturn += (FOURTH.getReward() * result[i]);
            if(FIFTH.getRank() == i) sumReturn += (FIFTH.getReward() * result[i]);
        }
        returnRate = ((sumReturn - Input.getTotalPrice())/Input.getTotalPrice())*100;
    }

    public int getRank() {
        return rank;
    }

    public Rank getRank(int num){
        if(FIRST.getRank() == num) return FIRST;
        if(SECOND.getRank() == num) return SECOND;
        if(THIRD.getRank() == num) return THIRD;
        if(FOURTH.getRank() == num) return FOURTH;
        if(FIFTH.getRank() == num) return FIFTH;
        return MISS;
    }

    public String getMessage(){
        return message;
    }

    public int getReward() {
        return reward;
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

}
