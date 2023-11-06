package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        GameManager gameManager = new GameManager();
        
        // 금액 입력
        System.out.println("구입 금액을 입력해 주세요.");
        Integer money = null;
        while(money == null) {
            String input = Console.readLine();
            money = inputHandler.readCost(input);
        }
        
        // 로또 추출 및 출력
        gameManager.generateLotto(money);
        gameManager.printLottos();
        // 당첨 숫자, 보너스 번호 입력
        // 당첨 통계 처리 및 출력
    }
}
