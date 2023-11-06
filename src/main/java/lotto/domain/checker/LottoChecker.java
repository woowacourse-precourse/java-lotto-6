package lotto.domain.checker;

import java.util.Arrays;
import lotto.domain.lotto.Lotto;
import lotto.domain.result.WinResult;
import lotto.domain.ticket.Ticket;
import lotto.util.reader.InputReader;

public class LottoChecker implements Checker {
        private final InputReader resultInputReader;
        private final InputReader magicNumberInputReader;

        private Lotto answer;
        private int magicNumber;

        public LottoChecker(InputReader resultInputReader, InputReader magicNumberInputReader) {
                this.resultInputReader = resultInputReader;
                this.magicNumberInputReader = magicNumberInputReader;
                initLottoAnswer();
                initMagicNumber();
        }

        private void initLottoAnswer() {
                String numbers = resultInputReader.readLine();
                answer = new Lotto(Arrays.stream(numbers.split(",")).map(Integer::parseInt).toList());
        }

        private void initMagicNumber() {
                do {
                        magicNumber = Integer.parseInt(magicNumberInputReader.readLine());
                } while (answer.hasNumber(magicNumber));
        }

        @Override
        public WinResult checkTicket(Ticket ticket) {
                return ticket.checkResult(answer, magicNumber);
        }
}
