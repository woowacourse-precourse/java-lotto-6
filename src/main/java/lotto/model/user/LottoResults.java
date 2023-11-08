package lotto.model.user;


import static lotto.model.constants.IntegerConstants.*;
import static lotto.model.constants.StringConstants.RESULT_FORMAT;

public class LottoResults {
    private final int firstPlaceCount;
    private final int secondPlaceCount;
    private final int thirdPlaceCount;
    private final int fourthPlaceCount;
    private final int fifthPlaceCount;

    public LottoResults(int first, int second, int third, int fourth, int fifth){
        firstPlaceCount = first;
        secondPlaceCount = second;
        thirdPlaceCount = third;
        fourthPlaceCount = fourth;
        fifthPlaceCount = fifth;
    }

    public String showResults(){
        return String.format(RESULT_FORMAT.get(),
                fifthPlaceCount, fourthPlaceCount, thirdPlaceCount, secondPlaceCount, firstPlaceCount
        );
    }

    public float earning() {
        return firstPlaceCount * FIRST_PRIZE.get()
                + secondPlaceCount * SECOND_PRIZE.get()
                + thirdPlaceCount * THIRD_PRIZE.get()
                + fourthPlaceCount * FOURTH_PRIZE.get()
                + fifthPlaceCount * FIFTH_PRIZE.get();
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
