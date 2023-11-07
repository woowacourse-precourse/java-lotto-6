package lotto.Domain;
import lotto.Controller.LottoGameController;

public class LottoGameDomain {
    public LottoGameDomain(){
        LottoGameController controller = new LottoGameController();
        controller.run();
    }
}
