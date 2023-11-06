package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.enums.Rank;
import lotto.model.Lotto;
import lotto.utils.Validator;

public class GameService {

    public Lotto createLotto() {
        List<Integer> lottoNumbers = Lotto.generateLotto();
        return new Lotto(lottoNumbers);
    }

    private void validateLotto(List<Integer> numbers) {
        Validator.validateWinningNumber(numbers);
    }

    // Lotto 구입 개수 계산
    private int calculateWinNumber(String money) {
        int winCount = Integer.parseInt(money);
        return winCount/1000;
    }

    // 당첨 번호 리스트 생성
    private List<Integer> generateWinNumber(String numbers) {
        String[] winNumbers = numbers.replace(""," ").split(",");
        List<Integer> winNumberList = new ArrayList<>();
        validateLotto(winNumberList);

        for (String winNumber : winNumbers) {
            winNumberList.add(Integer.parseInt(winNumber));
        }
        return winNumberList;
    }

    // 당첨 여부 확인
    private Rank checkWinNumber(List<Integer> numbers, Lotto lotto, int bonusNumber) {
        int winCount = lotto.countNumber(numbers);
        boolean bonus = lotto.containBonusNumber(bonusNumber);

        for (Rank rank : Rank.values()) {
            if (rank.isMatchBonus(winCount, bonus)) {
                return rank;
            }
        }

        throw new NoSuchElementException();
    }



}
