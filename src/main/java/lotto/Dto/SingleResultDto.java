package lotto.Dto;

public class SingleResultDto {

    // 3개 당첨시
    // 3개를 matched했고 상금이 prize인 로또를 won개 만큼 당첨 됨
    int matched;
    int prize;
    int won;

    public int getMatch() {
        return matched;
    }

    public void setMatched(int matched) {
        this.matched = matched;
    }


    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

}
