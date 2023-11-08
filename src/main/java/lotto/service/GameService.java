package lotto.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.LottoNumber;
import lotto.enums.Rank;
import lotto.model.Lotto;
import lotto.utils.Validator;

public class GameService {

    // Lotto 구입 개수 계산
    public int calculateLottoCount(String money) {
        int lottoCount = Integer.parseInt(money);
        return lottoCount / 1000;
    }

    // Lotto list 생성
    public List<Lotto> createLotto(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = Lotto.generateLotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private void validateLotto(List<Integer> numbers) {
        Validator.validateWinningNumber(numbers);
    }

    // 당첨 번호 리스트 생성
    public List<Integer> generateWinNumber(String numbers) {
        String[] winNumbers = numbers.split(",\\s*");
        List<Integer> winNumberList = new ArrayList<>();

        for (String winNumber : winNumbers) {
            winNumberList.add(Integer.parseInt(winNumber));
        }

        Collections.sort(winNumberList);
        validateLotto(winNumberList);
        return winNumberList;
    }

    // 보너스 번호 검증 및 생성
    public int generateBonusNumber(String bonus) {
        int bonusNumber = Integer.parseInt(bonus);
        if (bonusNumber < LottoNumber.MIN.getValue() || bonusNumber > LottoNumber.MAX.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 수여야 합니다.");
        }
        return bonusNumber;
    }

    // 당첨 여부 확인
    private Rank checkWinNumber(List<Integer> numbers, Lotto lotto, int bonusNumber) {
        int winNumber = lotto.countNumber(numbers);
        boolean bonus = lotto.containBonusNumber(bonusNumber);

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatchBonus(winNumber, bonus))
                .findFirst()
                .orElse(Rank.FAIL);
    }

    public List<Rank> checkWinNumbers(List<Integer> winNumbers, List<Lotto> lottoList,
            int bonusNumber) {
        return lottoList.stream()
                .map(lotto -> checkWinNumber(winNumbers, lotto, bonusNumber))
                .collect(Collectors.toList());
    }

    // 수익률 계산
    public String calculateReturnRate(List<Rank> rankList, int lottoCount) {
        int money = lottoCount * 1000;
        int totalPrize = rankList.stream()
                .mapToInt(Rank::getPrize)
                .sum();

        double returnRate = ((double) totalPrize / money) * 100;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        String formattedReturnRate = decimalFormat.format(returnRate);

        return formattedReturnRate + "%입니다.";
    }
}
