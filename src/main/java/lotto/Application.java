package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        GameManager gameManager = new GameManager();
        Integer money = null;

        // 금액 입력
        System.out.println("구입 금액을 입력해 주세요.");
        while(money == null) {
            String input = Console.readLine();
            money = inputHandler.readCost(input);
        }
        System.out.println();

        // 로또 추출 및 출력
        gameManager.generateLotto(money);
        System.out.println(gameManager.getGameSize() + "개를 구매했습니다.");
        gameManager.printLottos();
        System.out.println();

        // 당첨 숫자, 보너스 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        while(gameManager.getWinningNumbers() == null) {
            String numberArray = Console.readLine();
            gameManager.setWinningNumbers(inputHandler.readWinningNumber(numberArray));
        }
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        while(gameManager.getBonusNumber() == null) {
            String numberInput = Console.readLine();
            gameManager.setBonusNumber(inputHandler.readBonusNumber(numberInput,gameManager.getWinningNumbers()));
        }

        
        // 당첨 통계 처리 및 출력
    }
}
