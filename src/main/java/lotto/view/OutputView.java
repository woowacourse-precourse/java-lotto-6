package lotto.view;

import java.util.List;
import lotto.domain.dto.LottoDto;

public class OutputView {

    private static final String READ_COST_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUYING_AMOUNT_MESSAGE = "%n%d개를 구매했습니다.%n";
    private static final String READ_WINNING_LOTTO_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


    public void printReadCostAmountMessage() {
        System.out.println(READ_COST_AMOUNT_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private void printLotto(LottoDto dto) {
        System.out.println(dto.numbers());
    }

    public void printBuyingAmountMessage(int amount) {
        System.out.printf(BUYING_AMOUNT_MESSAGE, amount);
    }

    public void printLottos(List<LottoDto> dtos) {dtos.forEach(this::printLotto); }

    public void printReadWinningLottoMessage() {
        System.out.println(READ_WINNING_LOTTO_MESSAGE);
    }
    public void printReadBonusNumberMessage() {
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
    }
}
