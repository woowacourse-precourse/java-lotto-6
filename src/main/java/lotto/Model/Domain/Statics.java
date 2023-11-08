package lotto.Model.Domain;

public class Statics {

    private final int fifthCount;
    private final int fourthCount;
    private final int thirdCount;
    private final int secondCount;
    private final int firstCount;
    private final float revenue;

    public Statics(int fifthCount, int fourthCount, int thirdCount, int secondCount, int firstCount,
            float revenue) {
        this.fifthCount = fifthCount;
        this.fourthCount = fourthCount;
        this.thirdCount = thirdCount;
        this.secondCount = secondCount;
        this.firstCount = firstCount;
        this.revenue = revenue;
    }

    public int getFifthCount() {
        return fifthCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getFirstCount() {
        return firstCount;
    }

    public float getRevenue() {
        return revenue;
    }
}
