package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import lotto.InputGuide;

public class Application {

    private static final int LOTTO_PRICE = 1000;

    ;

    static Lotto lotto;
    static List<Lotto> lottoList = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int totalPayment= setTotalPayment(); //로또 구입 금액 입력
        setLottoList(totalPayment);//로또 리스트 생성
        printLottoList(lottoList); //로또번호 출력
        WinningNumber winningNumber = setWinningNum(); //당첨  번호 생성
        int bonusNum = setBonusNum();// 보너스 번 호 생성
        RateOfReturn ROR = new RateOfReturn(compareWin(winningNumber, bonusNum),totalPayment);
    }

    private static int setBonusNum() {
        while(true){
            try{ // 사용자 보너스 번호 입력
                return InputGuide.inputBonusNum();
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static WinningNumber setWinningNum() {
        while(true){
            try{//당첨번호 입력
                return new WinningNumber(InputGuide.inputWinningNum());
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void setLottoList(int totalPayment) {
        while(true){
            try{
                makeLottoList(totalPayment); // 로또번호 생성
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static int setTotalPayment() {
        while (true){
            try{
                return InputGuide.inputPrice();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static int[][] compareWin(WinningNumber winningNumber, int bonusNum) {
        int[][] totalMatch = new int[lottoList.size()][2]; //[전체 로또 개수][전체 중복 개수(보너스 포함), 보너스 번호 중복 여부]
        int i = 0;
        for(Lotto lotto : lottoList){
            int winningMatch = checkWinning(lotto.getNumbers(),winningNumber.getWinningNumber()); //각 로또 번호, 당첨 번호 비교
            int bonusMatch = checkBonous(lotto.getNumbers(),bonusNum); //각 로또 번호, 보너스 번호 비교
            totalMatch[i][0] = winningMatch + bonusMatch; //로또 당첨 개수 + 보너스 번호 일치 여부
            totalMatch[i][1] = bonusMatch; // 보너스 번호 일치 여부
            i++;
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
        System.out.println();
        System.out.println(lottoList.size()+"개를 구매했습니다.");
        for(Lotto lotto : lottoList){
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

}
