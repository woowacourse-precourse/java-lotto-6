package lotto.Controller;

import lotto.Util.LottoNumberValidator;
import lotto.View.InputView;

public class InputController {

    public static Lottonumbers setLottonumbers() {
        try {
            LottoNumberValidator validation = new LottoNumberValidator(InputView.RightNumber());
            return new Lottonumbers(validation.NUMBERS);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setLottonumbers();
        }
    }

    public static int setRoundNum() {
        try {
            LottoNumberValidator validation = new LottoNumberValidator(InputView.RightNumber());
            return Integer.parseInt(String.valueOf(validation.LOTTOS));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setRoundNum();
        }
    }
}
