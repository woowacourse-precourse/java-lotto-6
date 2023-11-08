package lotto.domain.checker;

import java.util.Arrays;
import lotto.domain.lotto.Lotto;
import lotto.domain.result.WinResult;
import lotto.domain.ticket.Ticket;
import lotto.util.reader.ConsoleReader;

/**
 * 로또의 결과를 판단하는 Checker 역할의 개념 객체를 나타내는 클래스 입니다.
 */
public class LottoChecker implements Checker {
        private final ConsoleReader winningNumberConsoleReader;
        private final ConsoleReader magicNumberInputReader;

        private Lotto answer;
        private int magicNumber;

        /**
         * LottoChecker 의 생성자 함수 입니다.
         * 당첨 번호와 보너스 숫자 입력을 위한 ConsoleReader 의 구현 클래스를 주입받습니다.
         * 주입받은 ConsoleReader 구현 클래스를 통해 당첨 로또 객체와 보너스 숫자를 초기화 합니다.
         *
         * @param resultInputReader      당첨 번호 유틸 클래스
         * @param magicNumberInputReader 보너스 숫자 유틸 클래스
         */
        public LottoChecker(ConsoleReader resultInputReader, ConsoleReader magicNumberInputReader) {
                this.winningNumberConsoleReader = resultInputReader;
                this.magicNumberInputReader = magicNumberInputReader;

                initLottoAnswer();
                initMagicNumber();
        }

        private void initLottoAnswer() {
                String numbers = winningNumberConsoleReader.readLine();
                answer = new Lotto(Arrays.stream(numbers.split(",")).map(Integer::parseInt).toList());
        }

        private void initMagicNumber() {
                do {
                        magicNumber = Integer.parseInt(magicNumberInputReader.readLine());
                } while (answer.hasNumber(magicNumber));
        }

        /**
         * 전달 받은 티켓의 결과를 판단하기 위해서, 티켓 객체에 당첨 번호와 보너스 숫자와 함께 결과를 요청합니다.
         * 티켓으로 부터 반환된 결과를 다시 반환합니다.
         *
         * @param ticket 고객이 구매한 로또 티켓
         * @return 로또 결과
         */
        @Override
        public WinResult checkTicket(Ticket ticket) {
                return ticket.checkResult(answer, magicNumber);
        }
}
