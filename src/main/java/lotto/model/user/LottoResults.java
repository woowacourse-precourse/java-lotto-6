package lotto.model.user;


public class LottoResults {
    private int firstPlaceCount = 0;
    private int secondPlaceCount = 0;
    private int thirdPlaceCount = 0;
    private int fourthPlaceCount = 0;
    private int fifthPlaceCount = 0;

    public LottoResults(int first, int second, int third, int fourth, int fifth){
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

    public String showResults(){
        return String.format("""
                3개 일치 (5,000원) - %d개
                4개 일치 (50,000원) - %d개
                5개 일치 (1,500,000원) - %d개
                5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                6개 일치 (2,000,000,000원) - %d개""",
                fifthPlaceCount, fourthPlaceCount, thirdPlaceCount, secondPlaceCount, firstPlaceCount
        );
    }

    public float earning() {
        return firstPlaceCount * 2_000_000_000
                + secondPlaceCount * 30_000_000
                + thirdPlaceCount * 1_500_000
                + fourthPlaceCount * 50_000
                + fifthPlaceCount * 5_000;
    }
}
