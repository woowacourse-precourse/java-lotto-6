package lotto.model;

public class ResultEachLotto {
    private int matchCount;
    private int matchBonus;

    public ResultEachLotto(int matchCount, int matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchBonus() {
        return matchBonus;
    }

    public void setMatchBonus(int matchBonus) {
        this.matchBonus = matchBonus;
    }


    public int getRank() {
        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5) {
            if (matchBonus == 1) {
                return 2;
            }
            return 3;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 3) {
            return 5;
        }
        return -1;  // 일치하는 숫자가 3개 미만인 경우, 등수에 해당하지 않음
    }



}

