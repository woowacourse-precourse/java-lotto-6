package lotto.model;

enum Rank {
    FIRST("6개 번호 일치", 2000000000),
    SECOND("5개 번호 + 보너스 번호 일치", 30000000),
    THIRD("5개 번호 일치", 1500000),
    FOURTH("4개 번호 일치",50000),
    FIFTH("3개 번호 일치", 5000);

    private final String state;
    private final int prize;
    Rank(String state, int prize) {
        this.state = state;
        this.prize = prize;
    }
}
