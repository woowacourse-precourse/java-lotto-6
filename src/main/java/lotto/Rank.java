package lotto;

public enum Rank {
    FIFTH("3개 일치", 5000, 0),
    FOURTH("4개 일치", 50000, 0),
    THIRD("5개 일치", 1500000, 0),
    SECOND("5개 일치, 보너스 볼 일치", 30000000, 0),
    FIRST("6개 일치", 2000000000, 0);

    final private String message;
    final private int price;
    private int cnt;
    Rank(String message, int price, int cnt){
        this.message = message;
        this.price = price;
        this.cnt = cnt;
    }

    public String getMessage(){
        return message;
    }

    public int getPrice(){
        return price;
    }

    public int getCnt(){
        return cnt;
    }

    public void setCnt(){
        this.cnt += 1;
    }
}
