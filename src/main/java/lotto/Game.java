package lotto;

import java.util.List;

public class Game {
    final List<Integer> answerNumber;
    final int bonusNumber;
    private List<Lotto> lottoList;

    private Game(List<Integer> answerNumber, int bonusNumber){
        this.answerNumber = answerNumber;
        this.bonusNumber = bonusNumber;
    }

    public static void Run(){
        //로또 금액 입력 받기

        //금액 만큼 로또 발행하기

        //당첨 번호, 보너스 번호 입력 받기

        //당첨 결과 출력하기

        //총 수익률 출력하기

    }
    private void getMoney(int money){
        //돈 입력받고 예외처리하기
    }

    private void makeLotto(int count){
        //개수만큼 로또 발행하고 로또리스트에 넣기
    }

    private List<Integer> picknumbers(){
        //로또 발행을 위해 랜덤번호 뽑아서 리스트 리턴하기
        return null;
    }

    private void getLottoNumber(){
        //당첨번호, 보너스번호 받기
    }

    private void printResult(){
        //당첨 결과 출력하기
    }

    private void printRevenue(){
        //총 수익률 출력하기
    }
}
