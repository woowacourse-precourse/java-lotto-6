package lotto;

/*
*   구현할 클래스
*   [domain]
*   로또 : 로또 한 장. 6개의 번호를 가진다
*   + 로또 6장을 가지고 있을 클래스, 아래의 함수들도 호출할 거임) 이른바 로또매니저?
*
*   [controller]
*   로또 번호 생성기 : 랜덤한 6개의 번호를 뽑는다.
*   유효 인풋 확인기(static) : 인풋 지점) 당첨 번호, 보너스 번호, 로또 구매금액
*   당첨 확인기 : 인자로 로또 혹은 숫자리스트를 받아(테스트 위해 인터페이스로 변경?)
*               당첨 여부(등수)를 확인한다. (+ 프라이빗으로 당첨 가지고 있음, 생성자로 받기)
*   당첨금 계산기 : 내부 상수로 당첨금 별 금액 기억하기
*   수익률 계산기 : 총 수익금과 로또 개수를 통해 수익률 산출하기
*   인풋 받기 : 유저로부터 필요한 인풋을 받는다. (내부에서 유효 인풋 확인기를 호출?)
*
*   [viewer]
*   출력기 : 사용자가 가진 총 로또 개수를 출력한다.
* */

import lotto.controller.LottoManager;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
    }
}
