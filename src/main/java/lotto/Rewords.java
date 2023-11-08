package lotto;

public enum Rewords {
    REWORDS_1ST("2,000,000,000",2000000000,0),
    REWORDS_2ST("30,000,000",30000000,0),
    REWORDS_3ST("1,500,000",1500000,0),
    REWORDS_4ST("50,000", 50000,0),
    REWORDS_5ST("5,000",5000,0);

    private final String name;
    private final int value;
    private int cnt;

    Rewords(String name, int value, int cnt) {
        this.name =name;
        this.value =value;
        this.cnt = cnt;
    }

    public int getValue(){
        return this.value;
    }

    public String getName(){
        return this.name;
    }
    public int getCnt(){
        return this.cnt;
    }

    public void addCnt(){
        this.cnt++;
    }

    public int calcReword(){
        return this.value*this.cnt;
    }
}
