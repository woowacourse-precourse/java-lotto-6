package lotto;

public enum ERating {
    eFIRST("6개 일치 (2,000,000,000원) - ",2000000000),
    eSECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ",30000000),
    eTHIRD("5개 일치 (1,500,000원) - ",1500000),
    eFOURTH("4개 일치 (50,000원) - ",50000),
    eFIFTH("3개 일치 (5,000원) - ",5000),
    eSIXTH("",0);



    private final String message;
    private final int reward;

    ERating(String message, int reward) {
        this.message = message;
        this.reward = reward;
    }

    public String getValue() {
        return message;
    }
    public int getReward() {
        return reward;
    }

}






