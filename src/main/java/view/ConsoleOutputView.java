package view;

import domain.Lotto;
import domain.LottoNumber;
import dto.LottoTickets;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputView implements OutputView {
    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PRINT_LOTTO_TICKETS_SIZE = "개를 구매했습니다.";
    private static final String PRINT_LOTTO_NUMBERS = "[%s]%n";
    private static final String REQUEST_LOTTO_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";

    @Override
    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
    }

    @Override
    public void printLottoTickets(LottoTickets lottoTickets) {
        List<Lotto> tickets = lottoTickets.getLottoTickets();
        System.out.println(tickets.size() + PRINT_LOTTO_TICKETS_SIZE);
        tickets.forEach(this::printLottoNumbers);
    }

    private void printLottoNumbers(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        String numbersJoinComma = lottoNumbers.stream()
                .map(LottoNumber::lottoNumberValue)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.printf(PRINT_LOTTO_NUMBERS, numbersJoinComma);
    }

    @Override
    public void requestLottoWinningNumbers() {
        System.out.println(REQUEST_LOTTO_WINNING_NUMBERS);
    }

    @Override
    public void requestBonusLottoNumber() {
        System.out.println(REQUEST_BONUS_LOTTO_NUMBER);
    }
}
