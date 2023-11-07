package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        
        // 이 곳에서 유저가 원하는 메뉴에 요청을 한다.
        // spring boot로 예시를 들면 controller @GetMapping 처럼..
        // 사용자가 해당 기능을 요청하는 것!!!

        controller.buyLotto();
        controller.saveLottoWinningAmount();
        controller.getWinningStatistics();
    }
}
