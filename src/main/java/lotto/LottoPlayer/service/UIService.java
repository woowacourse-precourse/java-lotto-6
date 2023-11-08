package lotto.LottoPlayer.service;

import lotto.Lotto.entity.Lotto;
import lotto.LottoPlayer.dto.WinningStatistic;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.LottoPlayer.model.ExceptionGroup.NOT_VALID_ERROR;
import static lotto.LottoPlayer.model.ExceptionGroup.THOUSAND_UNIT_ERROR;
import static lotto.LottoPlayer.model.UIMessageGroup.*;

//UI 담당 로직
public class UIService {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    //돈을 입력받는 함수
    public int readMoney() {
        System.out.println(PURCHASE_AMOUNT.getMessage());
        String moneyInput = readLine();
        validateNumber(moneyInput);
        int money = Integer.parseInt(moneyInput);
        validateMoney(moneyInput);
        return money;
    }

    private void validateNumber(String moneyInput) {
        if (moneyInput.matches(".*[^0-9].*")) {
            throw new IllegalArgumentException(NOT_VALID_ERROR.getMessage());
        }
    }

    private void validateMoney(String moneyInput) {
        if (!moneyInput.matches("[0-9]+")) {
            throw new IllegalArgumentException(NOT_VALID_ERROR.getMessage());
        }
        int money = Integer.parseInt(moneyInput);
        if (money % LOTTO_PRICE != 0 || money <= 0) {
            throw new IllegalArgumentException(THOUSAND_UNIT_ERROR.getMessage());
        }
    }

    //발행한 로또 수량을 출력하는 함수
    public void printIssuedLottoCount(int amount) {
        System.out.println(String.format(PURCHASED_LOTTO_NUMBER.getMessage(),amount));
    }

    //입력된 로또 리스트의 번호를 출력하는 함수
    public void printIssuedLotto(List<Lotto> issued_lotto) {
        issued_lotto.stream()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    //입력된 당첨 통계를 출력하는 함수
    public void printStatistics(WinningStatistic statistics) {
        int firstPrize = statistics.getFirstPrizeCount();
        int secondPrize = statistics.getSecondPrizeCount();
        int thirdPrize = statistics.getThirdPrizeCount();
        int fourthPrize = statistics.getFourthPrizeCount();
        int fifthPrize = statistics.getFifthPrizeCount();

        System.out.println(STATISTICS_RESULT.getMessage());
        System.out.println(String.format(FIFTH_PRIZE_RESULT.getMessage(), fifthPrize));
        System.out.println(String.format(FOURTH_PRIZE_RESULT.getMessage(), fourthPrize));
        System.out.println(String.format(THIRD_PRIZE_RESULT.getMessage(), thirdPrize));
        System.out.println(String.format(SECOND_PRIZE_RESULT.getMessage(), secondPrize));
        System.out.println(String.format(FIRST_PRIZE_RESULT.getMessage(), firstPrize));
    }

    //입력된 수익률을 출력하는 함수
    public void printProfitRate(double profitRate) {
        System.out.println(String.format(PROFIT_RATE_RESULT.getMessage(), profitRate));
    }
}
