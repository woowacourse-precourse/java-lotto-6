package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager();

        // 금액 입력
        System.out.println("구입 금액을 입력해 주세요.");
        while(gameManager.getMoneyYouPut() == 0) {
            String input = Console.readLine();
            gameManager.setMoneyYouPut(InputHandler.readCost(input)); 
        }
        System.out.println();

        // 로또 추출 및 출력
        gameManager.generateLotto();
        System.out.println(gameManager.getGameSize() + "개를 구매했습니다.");
        PrintHandler.printLottos(gameManager.getLottos());

        // 당첨 숫자, 보너스 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        while(gameManager.getWinningNumbers() == null) {
            String numberArray = Console.readLine();
            gameManager.setWinningNumbers(InputHandler.readWinningNumber(numberArray));
        }
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        while(gameManager.getBonusNumber() == null) {
            String numberInput = Console.readLine();
            gameManager.setBonusNumber(InputHandler.readBonusNumber(numberInput,gameManager.getWinningNumbers()));
        }
        System.out.println();
        // 당첨 통계 처리 및 출력
        gameManager.updateResult();
        gameManager.updateProfit();
        PrintHandler.printResults(gameManager.getResult());
        
    }
}
