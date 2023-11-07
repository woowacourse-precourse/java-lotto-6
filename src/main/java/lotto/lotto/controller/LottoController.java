package lotto.lotto.controller;

import static lotto.lotto.model.LottoConstant.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lotto.model.Lotto;
import lotto.lotto.view.LottoView;
import lotto.user.controller.UserController;
import lotto.util.convert.ConvertUtil;
import lotto.util.validate.LottoValidate;

public class LottoController {
    private LottoController(){ }
    private static final LottoController instance = new LottoController();

    public static LottoController getInstance(){
        return instance;
    }

    public void start(){
        UserController userController = UserController.getInstance();
        int money = userController.purchaseInput();
        makeLotto(money);
        List<Integer> numbers = userController.lottoNumberInput();
        int bonus = userController.lottoBonusNumberInput(numbers);
    }

    public List<Lotto> makeLotto(int money){
        int count = ConvertUtil.moneyToCount(money);
        List<Lotto> lottos = new ArrayList<>();
        try{
            for(int i=0;i<count;i++){
                Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, MAX_INPUT_NUMBER));
                lottos.add(lotto);
            }
            LottoValidate.checkLottos(lottos);
            LottoView.printUserLotto(lottos);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return lottos;
    }
}
