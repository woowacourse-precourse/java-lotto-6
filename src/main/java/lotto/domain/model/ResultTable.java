package lotto.domain;
public class ResultTable {
    private int numberOfMatched; // 매칭된 번호의 개수
    private long prize; // 당첨 금액
    private int count; // 당첨된 로또의 개수

    public ResultTable(int matchCount, long prize) {
        this.numberOfMatched = matchCount;
        this.prize = prize;
        this.count = 0;
    }

    public void incrementCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%s원) - %d개", numberOfMatched,
                String.format("%,d", prize), count);
    }

    public String getFinalResult() {
        if (numberOfMatched == 7) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", 5,
                    String.format("%,d", prize), count);
        }
        return toString();
    }

    public int getNumberOfMatched() {
        return numberOfMatched;
    }

    public int getCount() {
        return count;
    }

    public long getTotalPrize() {
        return prize * count;
    }
}



