package lotto;

import camp.nextstep.edu.missionutils.*;

public class Application {

    public static void game() {
        System.out.println("구입금액을 입력해 주세요.");
        long purchaseAmount = Integer.parseInt(Console.readLine());
        //1000의 배수 인지 판단 -> 아니라면 에러 후 종료 (정상, 예외 테스트 추가)
        if ( purchaseAmount % 1000 != 0 ){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000의 배수여야 합니다.");
        }

        //1000의 배수라면
        //구입한 로또의 개수 출력
        CreateLottos(purchaseAmount / 1000);
        //구입한 로또의 번호 출력
        //당첨 번호 입력 받기
        //보너스 번호 입력 받기
        //로또 생성
        //구매한 로또의 번호를 보며, 몇 등인지 체크
        //수익률 계산
        //당첨 통계 출력
        //수익률 출력

    }

    public static void main(String[] args) {
        game();
    }
}
