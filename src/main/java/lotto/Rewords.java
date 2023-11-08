package lotto;

public enum Rewords {
    REWORDS_1ST("2,000,000,000",2000000000),
    REWORDS_2ST("30,000,000",30000000),
    REWORDS_3ST("1,500,000",1500000),
    REWORDS_4ST("50,000", 50000),
    REWORDS_5ST("5,000",5000);

    private final String name;
    private final int value;

    Rewords(String name, int value) {
        this.name =name;
        this.value =value;
    }

    public int getValue(){
        return this.value;
    }

    public String getName(){
        return this.name;
    }

    public int calcReword(int cnt){
        return this.value*cnt;
    }
}
