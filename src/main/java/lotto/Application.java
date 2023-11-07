package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {

    private static final int LOTTO_PRICE = 1000;

    static int[] winList = new int[4];
    static Lotto lotto;
    static List<Lotto> lottoList = new ArrayList<>();

    public static void main(String[] args) {

        InputGuide inputGuide = new InputGuide();
        // TODO: 프로그램 구현
        int totalPayment = inputGuide.inputPrice(); // 사용자 구입금액 입력

        makeLottoList(totalPayment); // 로또번호 생성

        printLottoList(lottoList); //로또번호 출력


        WinningNumber winningNumber = new WinningNumber(inputGuide.inputWinningNum()); //당첨번호 입력
        int bonusNum = inputGuide.inputBonusNum(); // 사용자 보너스 번호 입력

        RateOfReturn ROR = new RateOfReturn(compareWin(winningNumber, bonusNum),totalPayment);

    }

    private static int[][] compareWin(WinningNumber winningNumber, int bonusNum) {
        int[][] totalMatch = new int[lottoList.size()][2];
        int i = 0;
        for(Lotto lotto : lottoList){
            int winningMatch = checkWinning(lotto.getNumbers(),winningNumber.getWinningNumber());
            int bonusMatch = checkBonous(lotto.getNumbers(),bonusNum);
            totalMatch[i][0] = winningMatch + bonusMatch;
            totalMatch[i][1] = bonusMatch;
        }
        return totalMatch;
    }


    private static int checkWinning(List<Integer> lotto, HashSet<Integer> winningNumber) {
        int matchNum = 0;
        for (int number : lotto){
            matchNum += matchCheck(number,winningNumber);

        }
        return matchNum;
    }

    private static int matchCheck(int number, HashSet<Integer> winningNumber) {
        if(winningNumber.contains(number)) return 1;
        return 0;
    }

    private static int checkBonous(List<Integer> lotto, int bonusNum) {
        if(lotto.contains(bonusNum)) return 1;
        return 0;
    }


    private static void makeLottoList(int totalPayment){ //로또 목록 생성
        for(int i= 0;i < totalPayment/LOTTO_PRICE; i ++){ //로또번호 생성
            lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            lottoList.add(lotto);
        }
    }

    private static void printLottoList(List<Lotto> lottoList) { //각각의 로또 번호 출력
        for(Lotto lotto : lottoList){
            System.out.println(lotto.getNumbers());
        }
    }

}
