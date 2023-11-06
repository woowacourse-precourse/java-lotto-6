package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import static lotto.util.Instruction.LOTTOS_SIZE_SUFFIX_MESSAGE;

public class OutputView {
    private static final String OPENING_BRAKETS = "[";
    private static final String CLOSING_BRAKETS = "]";
    private static final String COMMA_SEPARATOR = ",";

    public static void printLottos(final Lottos lottos) {
        System.out.println(lottos.getTotalLottos().size() + LOTTOS_SIZE_SUFFIX_MESSAGE.getMessage());
        lottos.getTotalLottos()
                .stream()
                .forEach(lotto -> printLotto(lotto));
        System.out.println();
    }

    private static void printLotto(final Lotto lotto) {
        System.out.print(OPENING_BRAKETS);
        int lottoTicketSize = lotto.getLottoTicket().size();
        for (int i = 0; i < lottoTicketSize - 1 ; i++) {
            System.out.print(lotto.getLottoTicket().get(i).getLottoNumber() + COMMA_SEPARATOR);
        }
        System.out.print(lotto.getLottoTicket().get(lottoTicketSize-1).getLottoNumber());
        System.out.println(CLOSING_BRAKETS);
    }
}
