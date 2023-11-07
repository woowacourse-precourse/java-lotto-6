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

    // 보너스에 따라 rank3와 rank2를 결정한다.
    private static LottoOutcome decideRankUp(LottoOutcome lottoOutcome, int bonus){
        if(lottoOutcome == rank3 && bonus == 1)
            return rank2;
        return lottoOutcome;
    }

    //숫자들과 보너스 숫자에서 맞춘 개수에 따라서 LottoOutcome을 return한다.
    public static LottoOutcome getFromNumOfMatchAndBonus(int matchOfNum, int bonus){
        for(LottoOutcome outcome: LottoOutcome.values()){
            if(outcome.matchOfNum == matchOfNum)
                return decideRankUp(outcome, bonus);
        }
        return none;
    }
}
