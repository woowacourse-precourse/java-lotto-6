package lotto.lotto.controller;

import static lotto.lotto.model.LottoConstant.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.calculation.controller.CalculationController;
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
        CalculationController calculationController = CalculationController.getInstance();

        int money = userController.purchaseInput();
        List<Lotto> lottos = makeLotto(money);
        List<Integer> numbers = userController.lottoNumberInput();
        int bonus = userController.lottoBonusNumberInput(numbers);
        int totalAmount = calculationController.calculation(lottos, numbers, bonus);
        calculationController.calcRevenue(money, totalAmount);
    }

    public List<Lotto> makeLotto(int money){
        int count = ConvertUtil.moneyToCount(money);
        List<Lotto> lottos = new ArrayList<>();
        try{
            for(int i=0;i<count;i++){
                Lotto lotto = new Lotto(makeRandomNumbers());
                lottos.add(lotto);
            }
            LottoValidate.checkLottos(lottos);
            LottoView.printUserLotto(lottos);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return lottos;
    }

    private List<Integer> makeRandomNumbers(){
        List<Integer> temp = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, MAX_INPUT_NUMBER));
        Collections.sort(temp);
        return temp;
    }
}
