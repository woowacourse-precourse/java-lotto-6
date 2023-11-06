package lotto;

public enum Rank {
    FIRST(1, "6개 번호 일치", 2000000000),
    SECOND(2, "5개 번호 + 보너스 번호 일치", 30000000),
    THIRD(3, "5개 번호 일치", 1500000),
    FOURTH(4, "4개 번호 일치", 50000),
    FIFTH(5, "3개 번호 일치", 5000);

    Rank(int rank, String matchCnt, int price) {
    }
}
