package view;

import camp.nextstep.edu.missionutils.Console;
import controller.LottoGame;

public class GameScreen {
    public GameScreen(){}

    public void runGame(){
        System.out.println("구입금액을 입력해 주세요.");
        try{
            LottoGame game = new LottoGame(Console.readLine());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
