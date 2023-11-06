package lotto.model;

import java.util.stream.IntStream;

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
}
