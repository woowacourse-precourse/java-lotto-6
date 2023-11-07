package lotto;

import lotto.Controller.LottoController;
import lotto.Model.User;
import lotto.View.LottoView;

public class Application {
    public static void main(String[] args) {
        User[] user = new User[3];
        LottoView lottoView = new LottoView();
        LottoController lottoControl = new LottoController(user,lottoView);
        lottoControl.start();
    }
}
