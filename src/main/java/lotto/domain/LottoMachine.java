package lotto.domain;

import static lotto.constant.Message.LOTTO_PRICE;
import static lotto.validation.LottoMachineValidation.validate_inputMoney;
import static lotto.validation.LottoMachineValidation.validate_winningLotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMachine {

    private int inputAmount;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    public LottoMachine(){
        lottos = new ArrayList<>();
    }

    public List<Lotto> issuanceLotto(String inputAmount) {
        this.inputAmount = validate_inputMoney(inputAmount);
        while (this.inputAmount > 0){
            createLotto();
        }
        return lottos;
    }

    private void createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        lottos.add(lotto);
        inputAmount -= LOTTO_PRICE;
    }

    public void createWinningLotto(String winningNums, String bonusNum){
        validate_winningLotto(winningNums, bonusNum);
        transToWinningLotto(winningNums, bonusNum);
    }

    private void transToWinningLotto(String nums, String bonusNum){
        List<Integer> winningNums = Arrays.stream(nums.split(","))
            .map(Integer::parseInt).toList();
        this.winningLotto = new WinningLotto(winningNums, Integer.parseInt(bonusNum));

    }

}
