package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.util.RandomUtil;
import lotto.util.Validator;


public class LottoService {


    public User initUser(int count) {
        List<Lotto> lottoNumbers = makeRandomLotto(count);
        return new User(count, lottoNumbers);
    }


    public int initMoneyToCount(String inputMoney) {
        int money = Validator.isNumber(inputMoney);
        return Validator.isDivide(money);
    }

    private List<Integer> sorting(List<Integer> randomUniqueNumbers) {
        List<Integer> sortedNumbers = new ArrayList<>(randomUniqueNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    private List<Lotto> makeRandomLotto(int count) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = sorting(RandomUtil.getRandomUniqueNumbers());
            lottoNumbers.add(new Lotto(randomNumbers));
        }

        return lottoNumbers;
    }

    public List<Integer> initWinningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers = parseAndValidateWinningNumbers(inputWinningNumbers);
        Lotto lotto = new Lotto(winningNumbers);
        return lotto.getNumbers();
    }

    private List<Integer> parseAndValidateWinningNumbers(String inputWinningNumbers) {
        String[] inputNumbers = inputWinningNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String inputNumber : inputNumbers) {
            int num = Validator.validateSingleNumber(inputNumber);
            winningNumbers.add(num);
        }

        return winningNumbers;
    }


    public int initBonusNumber(List<Integer> winningNumbers, String inputBonusNumber) {
        int num = Validator.validateSingleNumber(inputBonusNumber);
        Validator.isDuplicatedBonus(winningNumbers, num);

        return num;
    }


}
