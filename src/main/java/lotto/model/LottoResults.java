package lotto.model;


public class LottoResults {
    private int firstPlaceCount = 0;
    private int secondPlaceCount = 0;
    private int thirdPlaceCount = 0;
    private int fourthPlaceCount = 0;
    private int fifthPlaceCount = 0;

    LottoResults(int first, int second, int third, int fourth, int fifth){
        firstPlaceCount = first;
        secondPlaceCount = second;
        thirdPlaceCount = third;
        fourthPlaceCount = fourth;
        fifthPlaceCount = fifth;
    }

    @Override
    public boolean equals(Object obj) {
        LottoResults expectedResult = (LottoResults) obj;
        return firstPlaceCount == expectedResult.firstPlaceCount
                && secondPlaceCount == expectedResult.secondPlaceCount
                && thirdPlaceCount == expectedResult.thirdPlaceCount
                && fourthPlaceCount == expectedResult.fourthPlaceCount
                && fifthPlaceCount == expectedResult.fifthPlaceCount;
    }

    public float earning() {
        return firstPlaceCount * 2_000_000_000
                + secondPlaceCount * 30_000_000
                + thirdPlaceCount * 1_500_000
                + fourthPlaceCount * 50_000
                + fifthPlaceCount * 5_000;
    }
}
