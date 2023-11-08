package lotto.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Domain.Human;
import lotto.Domain.Lotto;
import lotto.Domain.LottoDraw;
import lotto.Domain.WinningLotto;
import lotto.Enum.WinningType;
import lotto.RandomGenerator.LottoGenerator;

public class LottoController {
    private Human human;
    private LottoDraw lottoDraw;
    private LottoInputValidator lottoInputValidator;

    public boolean gameStart(String budgets) {
        lottoInputValidator = new LottoInputValidator();
        try {
            lottoInputValidator.validateBudget(budgets);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
        human = new Human(Long.parseLong(budgets));
        return false;
    }

    public void buyLottos() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        while (human.buyLotto()) {
            human.addLotto(lottoGenerator.getLottoNumber());
        }
        // Return -> is successful
    }

    public int getPurchasedLottoCnt() {
        return human.getLottosLength();
    }

    public List<Lotto> getPurchasedLottos() {
        return human.getLottos();
    }

    public void raffleLotto(String normalNumbers, String bonusNumbers) {
        // Exception Checking will be here
        // If Exception occur -> return
        lottoDraw = new LottoDraw(
                new WinningLotto(
                        Arrays.stream(normalNumbers.split(","))
                                .map(String::trim) // 부분 문자열의 앞뒤 공백 제거
                                .map(Integer::parseInt) // 문자열을 정수로 변환
                                .collect(Collectors.toList()),
                        Integer.valueOf(bonusNumbers))
        );

        lottoDraw.checkNumbers(human);

        // return Successful
    }

    public Map<WinningType, Integer> getWinningResult() {
        return human.getWinningResult();
    }

    public double getReturnRate() {
        return human.getReturnRate();
    }
}
