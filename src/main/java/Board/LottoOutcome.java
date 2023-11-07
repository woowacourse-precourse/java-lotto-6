package Board;

public enum LottoOutcome {
    rank1(6, 0, 2000000000),
    rank2(5, 1, 30000000),
    rank3(5, 0, 1500000),
    rank4(4, 0, 50000),
    rank5(3, 0, 5000),
    none(0, 0, 0);

    int matchOfNum;
    int bonus;
    int prize;
    LottoOutcome(int matchOfNum, int bonus, int prize){
        this.matchOfNum = matchOfNum;
        this.bonus = bonus;
        this.prize = prize;
    }
}
