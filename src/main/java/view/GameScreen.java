package view;

import camp.nextstep.edu.missionutils.Console;
import controller.LottoGame;
import lotto.Lotto;

import java.util.List;

public class GameScreen {
    LottoGame game;
    public GameScreen(){}

    public void runGame(){
        initialize();
        this.game.printLottoQuantity();
        try{
            this.game.createLottos();
            printLottos();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    private void initialize(){
        while(true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                this.game = new LottoGame(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void printLottos(){
        List<Lotto> lottos = this.game.getLottos();
        for(Lotto lotto : lottos)
        {
            System.out.println(lotto);
        }
    }
}
