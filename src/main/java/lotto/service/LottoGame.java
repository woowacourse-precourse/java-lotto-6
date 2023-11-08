package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Prize;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.util.Converter;
import lotto.util.OutputUtils;
import org.assertj.core.util.VisibleForTesting;

import java.util.stream.IntStream;

import static lotto.util.OutputUtils.*;
import static lotto.util.StatisticsUtils.*;

public class LottoGame {
    public static final int LOTTO_SELECTION_COUNT = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_PRICE = 1000;
    private final User user;
    private Lotto prizeLotto;
    private int bonusNumber;

    public LottoGame(User user) {
        this.user = user;
    }

    public void play() {
        user.readBuyAmount();

        issueLottoNumbers(user.getAmount());
        printIssuedLottos(user.getLottos());

        readPrizeLottoNumbers();
        readBonusNumber();

        drawUpPrize();
    }

    private void readPrizeLottoNumbers() {
        try {
            printReadPrizeNumber();
            String input = Console.readLine();
            this.prizeLotto = new Lotto(Converter.convertStringToIntegers(input));
        } catch (IllegalArgumentException e) {
            readPrizeLottoNumbers();
        }
    }

    private void readBonusNumber() {
        try {
            printReadBonusNumber();
            String input = Console.readLine();
            this.bonusNumber = Converter.convertValidLottoNumber(input);
        } catch (IllegalArgumentException e) {
            readBonusNumber();
        }
    }

    private void drawUpPrize() {
        OutputUtils.printStatisticsTitle();
        Prize[] prizes = calculatePrize(this.prizeLotto, user.getLottos(), this.bonusNumber);
        long totalReturn = calculateTotalReturn(prizes);

        OutputUtils.printStatisticsResult(prizes);
        double returnRate = calculateReturnRate(user.getAmount(), totalReturn);
        OutputUtils.printReturnRate(returnRate);
    }

    private void issueLottoNumbers(int amount) {
        int countToIssue = amount / LOTTO_PRICE;
        IntStream.range(0, countToIssue)
                .forEach(i -> user.getLottos()
                        .add(generateNewLotto()));
    }

    @VisibleForTesting
    protected Lotto generateNewLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                LOTTO_SELECTION_COUNT));
    }
}
