package lotto.model;

public enum PrintCorrect {
    THREE("3개 일치 (5,000원) - ", 0),
    FOUR("4개 일치 (50,000원) - ", 1),
    FIVE("5개 일치 (1,500,000원) - ", 2),
    FIVE_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 3),
    SIX("6개 일치 (2,000,000,000원) - ", 4);


    private final String print;
    private final int value;
    private PrintCorrect(String print, int value){
        this.print = print;
        this.value = value;
    }

    public String getPrint(){
        return this.print;
    }

    public int getValue(){
        return this.value;
    }

}
