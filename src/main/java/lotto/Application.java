package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    //전체 게임 여기서 컨트롤
    static void gameStart() {
        //1) 구매 금액 입력받기
        int price = readLottoPrice();
        int lotto_count = price / 1000;

        //2) 구매 가능한 로또 개수만큼 로또 자동 발급 기능

        //3) 발급한 로또 번호 출력 기능

        //4) 당첨 번호 입력 기능

        //5) 보너스 번호 입력 기능

        //6) 당첨에 대한 통계 기능

        //7) 수익률 계산 기능

    }

    /**
     * 1) [로또 구매 금액] 입력받기 관련
     *
     * @return
     */
    //가격 입력받아서 가격을 리턴하고 구매할 로또
    static int readLottoPrice() {
        //메시지
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

}
