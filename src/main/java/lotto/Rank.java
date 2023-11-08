package lotto;


public enum Rank {
    FIRST(6, 1, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 2, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 3, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5, 5000, "3개 일치 (5,000원) - "),
    MISS(0, 0, 0, "");
    Rank(int countOfMatch, int rank, int reward, String message) {
        this.countOfMatch = countOfMatch;
        this.rank = rank;
        this.reward = reward;
        this.message = message;
    }

    private int countOfMatch, rank, reward;
    private String message;
    public static int[] result = new int[6];
    public static double returnRate;
    public static double sumReturn;


    public static void calculateEachLottoResult(int countOfMatch, boolean bonusCheck) {
        if(bonusCheck && SECOND.countOfMatch==countOfMatch)
            result[SECOND.rank]++;

        for (Rank rank : values()) {
            if (!bonusCheck && rank.countOfMatch==countOfMatch) {
                result[rank.rank]++;
            }
        }
    }

    public static void calculateReturnRate(){
        for(Rank rank : values()){
            sumReturn += (result[rank.rank] * rank.reward);
        }
        returnRate = ((sumReturn - Input.totalPrice)/Input.totalPrice)*100;
    }

    public int getRank() {
        return this.rank;
    }


    public Rank getRank(int num) {
        for(Rank rank : values()){
            if(rank.rank == num) return rank;
        }
        return MISS;
    }

    public String getMessage(){
        return this.message;
    }

    public int getReward() {
        return this.reward;
    }

}
