package lotto.domain;

public class LottoResult {

    private int place[] = new int[5];

    public void checkRanking(int match , boolean bonus) {
        if(is1stPlace(match)) {
            place[0]++;
            return;
        }

        if(is2stPlace(match , bonus)) {
            place[1]++;
            return;
        }

        place[checkRemainPlace(match , bonus)]++;
    }

    private boolean is1stPlace(int match) {
        return match >= 6;
    }

    private boolean is2stPlace(int match , boolean bonus) {
        return match == 5 && bonus;
    }

    private int checkRemainPlace(int match , boolean bonus) {
        if(bonus) {
            return match + 1;
        }

        return match;
    }

    public void printLottoResult() {

    }
}
