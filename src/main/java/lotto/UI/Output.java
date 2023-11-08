package lotto.UI;

import java.util.List;

public class Output {
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;
    public void printRandomLottoNumbers(List<List<Integer>> randomLottoNumbers) {
        int numberOfLotto = randomLottoNumbers.size();
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        for (List<Integer> randomLottoNumber : randomLottoNumbers) {
            System.out.println(randomLottoNumber);
        }
    }

    public void printLottoResult(List<List<Integer>> matchedNumbers, int price) {
        for (List<Integer> matchedNumber : matchedNumbers) {
            getRank(matchedNumber);
        }
        System.out.println("3개 일치 (5,000원) - " + fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");

        double addOfLucky = 2000000000*first + 30000000*second + 1500000*third + 50000*fourth + 5000*fifth;
        printRateOfReturn(addOfLucky,price);
    }

    private void getRank(List<Integer> matchedNumber) {
        if (matchedNumber.get(0) == 6) {
            first++;
        }
        if (matchedNumber.get(0) == 5 && matchedNumber.get(1) == 1) {
            second++;
        }
        if (matchedNumber.get(0) == 5) {
            third++;
        }
        if (matchedNumber.get(0) == 4) {
            fourth++;
        }
        if (matchedNumber.get(0) == 3) {
            fifth++;
        }
    }

    public static void printRateOfReturn(double addOfLucky, int price){

       double rateOfReturn = (addOfLucky/(double)price)*100;
       rateOfReturn = Math.round(rateOfReturn *100) / 100.0;
        System.out.println("총 수익률은 "+rateOfReturn+"%입니다.");
    }
}
