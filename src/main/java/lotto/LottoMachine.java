package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class LottoMachine {
    private int[] grades = new int[5];
    // 기본 생성자
    public LottoMachine() {
    }

    // 1~45 사이의 중복없는 무작위 로또 번호 반환하는 메서드
    public List<Integer> getRandomLottoNumbers() {

        List<Integer> LottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return LottoNumbers;
    }

    // 구매한 로또 리스트 반환
    public List<Integer>[] getBuyLottos(int numberOfLotto) {
        // count값 만큼 로또 번호 생성
        List<Integer>[] LottoNumberBox = new ArrayList[numberOfLotto];

        for (int i = 0; i < numberOfLotto; i++) {
            LottoNumberBox[i] = new ArrayList<>();
            List<Integer> lottoNumbers = getRandomLottoNumbers();
            LottoNumberBox[i].addAll(lottoNumbers);
            System.out.println(lottoNumbers);
        }
        return LottoNumberBox;
    }


    /**
     * 로또 등수 판별
     */
    public void rateLottosRank(List<Integer>[] LottoNumberBox, List<Integer> correctLottoNumber) {
        for (List<Integer> lottoNumbers : LottoNumberBox) {
            compareLotto(lottoNumbers, correctLottoNumber);
        }
    }



    /**
     *  매개변수로 두 리스트를 받아 비교
     *  matchLotto() 호출
     *
     * */
    public void compareLotto(List<Integer> numberOfLotto, List<Integer> correctNumber) {
        int count = 0;
        boolean bonus = false;
        for (int match : numberOfLotto) {
            if (correctNumber.indexOf(match) < 7 && correctNumber.indexOf(match) > -1) {   // 보너스 아닐 때
                count++;
            }
            if (correctNumber.indexOf(match) == 6) {
                bonus = true;
            }
        }
        matchLotto(count, bonus);
    }


    // 당첨 로또 개수 측정
    public void matchLotto(int matchingCount, boolean MatchingBonus) {
        if (matchingCount == Rate.THIRD.getMatchingNumbers()) {
            grades[0]++;
        }
        else if(matchingCount == Rate.FOURTH.getMatchingNumbers()){
            grades[1]++;
        }
        else if(matchingCount == Rate.FIFTH.getMatchingNumbers() && MatchingBonus){
            grades[3]++;
        }
        else if(matchingCount == Rate.FIFTH.getMatchingNumbers()){
            grades[2]++;
        }
        else if(matchingCount == Rate.SIXTH.getMatchingNumbers()){
            grades[4]++;
        }
    }

    // 당첨된 로또 측정후 출력
    public void printResult() {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + grades[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + grades[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + grades[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + grades[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + grades[4] + "개");

    }

    // 수익률 계산
    public void printEarningsRate(int price) {
        System.out.println(price);

        int earnings = 0;
        earnings += 5000*grades[0];
        earnings += 50000*grades[1];
        earnings += 15000000*grades[2];
        earnings += 30000000*grades[3];
        earnings += 2000000000*grades[4];

        System.out.println("총 수익률은 " + (100.0*earnings/price) + "%입니다.");
    }
}







