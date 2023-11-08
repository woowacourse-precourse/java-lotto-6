package lotto;

public enum MatchNums {
    THREE(3, 5_000, "3개 일치 (5,000원) - %d개"),
    FOUR(4, 50_000, "4개 일치 (50,000원) - %d개"),
    FIVE(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    FIVE_AND_BONUS(55, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개");


    private final int num;
    private final int cost;
    private final String printComment;

    MatchNums(int num, int cost, String printComment){
        this.num = num;
        this.cost = cost;
        this.printComment = printComment;
    }

    public int getNum(){
        return num;
    }

    public String getPrintComment() {
        return printComment;
    }

    public int calculateCost(int count){
        return count*cost;
    }
}
