package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구매금액을 입력해 주세요.");
        String buyMoney = readLine();
        Game game;
        while(true){
            try{
                game = new Game(buyMoney);
                break;
            }catch(IllegalArgumentException e){
                System.out.printf("[ERROR] %s\n",e.getMessage());
            }
            buyMoney = readLine();
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = readLine();
        while(true){
            try{
                game.setWinNumbers(numbers);
                break;
            }catch(IllegalArgumentException e){
                System.out.printf("[ERROR] %s\n",e.getMessage());
            }
            numbers = readLine();
        }
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine();
        while(true){
            try{
                game.setBonusNumber(bonusNumber);
                break;
            }catch(IllegalArgumentException e){
                System.out.printf("[ERROR] %s\n",e.getMessage());
            }
            bonusNumber = readLine();
        }
        System.out.println();
        game.printResult();
    }
}
