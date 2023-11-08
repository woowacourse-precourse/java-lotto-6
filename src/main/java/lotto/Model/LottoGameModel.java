package lotto.Model;
import lotto.Controller.LottoGameController;

public class LottoGameModel {
    public LottoGameModel(){
        LottoGameController controller = new LottoGameController();
        controller.run();
    }
}
