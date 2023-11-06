package lotto.domain.checker;

import java.util.Arrays;
import lotto.domain.lotto.Lotto;
import lotto.domain.result.WinResult;
import lotto.domain.ticket.Ticket;
import lotto.util.reader.InputReader;

/**
 * Checker 를 구현한 개념 객체를 나타내는 클래스 입니다.
 */
public class LottoChecker implements Checker {
        /**
         * 당첨 번호를 입력받기 위한 유틸 클래스입니다.
         */
        private final InputReader resultInputReader;

        /**
         * 보너스 숫자를 입력받디 위한 유틸 클래스입니다.
         */
        private final InputReader magicNumberInputReader;

        /**
         * 당첨 번호를 가진 로또 객체 입니다.
         */
        private Lotto answer;
        /**
         * 보너스 숫자 입니다.
         */
        private int magicNumber;

        /**
         * LottoChecker 의 생성자 함스 입니다.
         * 당첨 번호와 보너스 숫자 입력을 위한 유틸 클래스를 주입받습니다.
         * 유틸 클래스를 통해 당참 로또 객체와 보너스 숫자를 초기화 합니다.
         *
         * @param resultInputReader 당첨 번호 유틸 클래스
         * @param magicNumberInputReader 보너스 숫자 유틸 클래스
         */
        public LottoChecker(InputReader resultInputReader, InputReader magicNumberInputReader) {
                this.resultInputReader = resultInputReader;
                this.magicNumberInputReader = magicNumberInputReader;
                initLottoAnswer();
                initMagicNumber();
        }

        /**
         * 당첨 번호를 입력 받아 당첨 로또 객체를 초기화 합니다.
         */
        private void initLottoAnswer() {
                String numbers = resultInputReader.readLine();
                answer = new Lotto(Arrays.stream(numbers.split(",")).map(Integer::parseInt).toList());
        }

        /**
         * 보너스 숫자를 입력 받아 보너스 숫자를 초기화 합니다.
         */
        private void initMagicNumber() {
                do {
                        magicNumber = Integer.parseInt(magicNumberInputReader.readLine());
                } while (answer.hasNumber(magicNumber));
        }

        /**
         * 전달 받은 티켓의 결과를 반환합니다.로
         *
         * @param ticket 고객이 구매한 로또 티켓
         * @return 로또 결과
         */
        @Override
        public WinResult checkTicket(Ticket ticket) {
                return ticket.checkResult(answer, magicNumber);
        }
}
