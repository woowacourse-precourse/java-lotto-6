package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;

import lotto.Domain.LottoTickets;
import lotto.Function.GenerateLotto;
import lotto.Util.InputView;
import lotto.Domain.Money;
import lotto.Util.OutputView;

public class Controller {
//    - 로또 번호의 숫자 범위는 1~45까지이다. Input.lottoRange
//- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다. Input.validate_Overlap
//- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다. Input.lotto_Random
        /*    - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원*/ /*Output.lotto_Output*/

    /*로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
                로또 1장의 가격은 1,000원이다.*/ /*Input.buy_lottoTrial*/
//    당첨 번호와 보너스 번호를 입력받는다.
//    사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
//    사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
//    Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다

    public void Run(){
        System.out.println(InputView.MONEY_INPUT_MESSAGE);
        Money money= getLottoMoney();
        System.out.println(money.getMoney());

        System.out.println(InputView.LOTTERY_INPUT_MESSAGE);
        LottoTickets lottoTickets= getLottoTickets(money);
        OutputView.printLottoTickets(lottoTickets);



    }
    private Money getLottoMoney(){
        return new Money(Integer.parseInt(Console.readLine()));
//        return new Money(3000);
    }

    private LottoTickets getLottoTickets(Money money){
        GenerateLotto generateLotto = new GenerateLotto();
        return new LottoTickets(generateLotto.generateLottoTickets(money.getTicket()));
    }



}
