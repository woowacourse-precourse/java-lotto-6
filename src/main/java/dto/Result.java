package dto;

public class Result {
    private int sameCount;
    private boolean isSameBonus;

    public Result() {
    }

    public Result(int sameCount, boolean isSameBonus) {
        this.sameCount = sameCount;
        this.isSameBonus = isSameBonus;
    }

    public int getSameCount() {
        return sameCount;
    }

    public boolean isSameBonus() {
        return isSameBonus;
    }
}
