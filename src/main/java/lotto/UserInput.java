package lotto;

import java.util.List;

public class UserInput {
    public UserInput(){

    }

    public int getPrice(){
        // validatePrice로 입력받은 값을 확인하고
        // 입력 받은 가격을 리턴한다.
        // Lotto에 validate 참고
    }

    private void validatePrice(int price){
        // price가 유효한 값인지 확인한다.
        // 문제 없으면 그대로 함수 종료.
    }

    public List<Integer> getWinningNumber(){
        // 이용자가 입력한 로또 숫자를 받는다.
        // validateNumber에 넘기기. int형인지 검증받는다.
    }

    public int getBonusNumber(){
        // bonus number를 입력받는다.
    }

    public void validateNumber(){
        // winning number와 bonus number를 검증
        // 정수형인지 검증한다.
        // Lotto class 호출, 파라메터로 winning number 넘기기
    }

}
