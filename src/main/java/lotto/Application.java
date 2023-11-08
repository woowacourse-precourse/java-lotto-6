package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        inputMoney(gameManager);
        makeLotto(gameManager);
        inputWinningNumber(gameManager);
        inputBonusNumber(gameManager);
        makeResult(gameManager);
    }
    
    private static void inputMoney(GameManager gameManager) {
        System.out.println("구입 금액을 입력해 주세요.");
        while(gameManager.getMoneyYouPut() == 0) {
            String input = Console.readLine();
            gameManager.setMoneyYouPut(InputHandler.readCost(input));
        }
        System.out.println();
    }
    
    private static void makeLotto(GameManager gameManager) {
        gameManager.generateLotto();
        System.out.println(gameManager.getGameSize() + "개를 구매했습니다.");
        PrintHandler.printLottos(gameManager.getLottos());
    }
    
    private static void inputWinningNumber(GameManager gameManager) {
        System.out.println("당첨 번호를 입력해 주세요.");
        while(gameManager.getWinningNumbers() == null) {
            String numberArray = Console.readLine();
            gameManager.setWinningNumbers(InputHandler.readWinningNumber(numberArray));
        }
        System.out.println();
    }
    private static void inputBonusNumber(GameManager gameManager) {
        System.out.println("보너스 번호를 입력해 주세요.");
        while(gameManager.getBonusNumber() == null) {
            String numberInput = Console.readLine();
            gameManager.setBonusNumber(InputHandler.readBonusNumber(numberInput,gameManager.getWinningNumbers()));
        }
        System.out.println();
    }
    
    private static void makeResult(GameManager gameManager) {
        gameManager.updateResult();
        gameManager.updateProfit();
        PrintHandler.printResults(gameManager.getResult());
    }
}
