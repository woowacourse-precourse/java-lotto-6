package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.util.RandomUtil;
import lotto.util.Validator;


public class LottoService {

    private List<Integer> winningNumbers;

    public User initUser(int count) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        makeRandomLotto(lottoNumbers, count);
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

    private void makeRandomLotto(List<Lotto> lottoNumbers, int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = sorting(RandomUtil.getRandomUniqueNumbers());
            lottoNumbers.add(new Lotto(randomNumbers));
        }
    }

    public List<Integer> initWinningNumbers(String inputWinningNumbers) {
        winningNumbers = parseAndValidateWinningNumbers(inputWinningNumbers);
        return winningNumbers;
    }

    private List<Integer> parseAndValidateWinningNumbers(String inputWinningNumbers) {
        String[] inputNumbers = inputWinningNumbers.split(",");
        winningNumbers = new ArrayList<>();

        for (String inputNumber : inputNumbers) {
            int num = parseAndValidateSingleWinningNumber(inputNumber);
            winningNumbers.add(num);
        }

        return validateWinningNumbers(winningNumbers);
    }

    private int parseAndValidateSingleWinningNumber(String inputNumber) {
        int num = Validator.isNumber(inputNumber);
        Validator.isSmallAndBig(num);
        return num;
    }

    private List<Integer> validateWinningNumbers(List<Integer> winningNumbers) {
        Validator.isSize(winningNumbers);
        Validator.isDuplicated(winningNumbers);

        return winningNumbers;
    }

    public int initBonusNumber(String inputBonusNumber) {
        int num = Validator.isNumber(inputBonusNumber);
        Validator.isSmallAndBig(num);
        Validator.isDuplicatedBonus(winningNumbers, num);

        return num;
    }


}
