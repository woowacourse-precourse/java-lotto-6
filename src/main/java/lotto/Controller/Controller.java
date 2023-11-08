package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import lotto.Domain.LottoTickets;
import lotto.Domain.PrizeBonusNumber;
import lotto.Function.GenerateLotto;
import lotto.Function.PrizeLottoCompare;
import lotto.Function.Rate;
import lotto.Function.Validate;
import lotto.Lotto;
import lotto.Util.ErrorMessage;
import lotto.Util.InputView;
import lotto.Domain.Money;
import lotto.Util.OutputView;

public class Controller {
    public void Run() {

        Money money = getLottoMoney();
        System.out.println(money.getMoney());

        LottoTickets lottoTickets = getLottoTickets(money);
        OutputView.printLottoTickets(lottoTickets);

        List<Integer> prizeLotto = inputPrizeLotto();
        System.out.println(prizeLotto);

        Integer bonusNumber = inputBonusNumber();
        System.out.println(bonusNumber);

        calculateLottoSystem(money, lottoTickets, prizeLotto, bonusNumber);
    }

    //돈 입력 및 입력 실패 시 다시 입력 받기
    private Money getLottoMoney() {
        try {
            System.out.println(InputView.MONEY_INPUT_MESSAGE);
            return new Money(Integer.parseInt(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INT_ERROR_MESSAGE);
            return getLottoMoney();
        }
    }

    //로또를 티켓 수 만큼 생성
    private LottoTickets getLottoTickets(Money money) {
        System.out.println(money.getTicket() + InputView.LOTTERY_NUMBER_MESSAGE);
        GenerateLotto generateLotto = new GenerateLotto();
        return new LottoTickets(generateLotto.generateLottoTickets(money.getTicket()));
    }

    //당첨 로또 번호 입력 및 입력 실패 시 다시 입력 받기
    private List<Integer> inputPrizeLotto() {
        try {
            System.out.println(InputView.PRIZE_INPUT_MESSAGE);
            List<Integer> prizeLotto = new ArrayList<>();
            String[] input = Console.readLine().split(",");

            Validate.validatePrizeNumber(input);
            functionInputPrizeLotto(prizeLotto, input);

            return prizeLotto;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INT_ERROR_MESSAGE);
            return inputPrizeLotto();
        }
    }

    //당첨 로또 번호 시스템 내 기능 분리
    private void functionInputPrizeLotto(List<Integer> prizeLotto, String[] input) {
        for (String s : input) {
            if (!prizeLotto.contains(Integer.parseInt(s))) {
                prizeLotto.add(Integer.parseInt(s));
            }
        }
    }

    //2등 보너스 번호 입력 및 입력 실패 시 다시 입력 받기
    private Integer inputBonusNumber() {
        try {
            System.out.println(InputView.BONUS_INPUT_MESSAGE);
            int prizeBonusNumber = Integer.parseInt(Console.readLine());
            Validate.validateBonusNumber(prizeBonusNumber);
            return prizeBonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INT_ERROR_MESSAGE);
            return inputBonusNumber();
        }
    }

    //입력 받은 값을 통해 계산하고 출력하는 기능 분리
    private void calculateLottoSystem(Money money, LottoTickets lottoTickets, List<Integer> prizeLotto, Integer bonusNumber) {
        PrizeBonusNumber prizeBonusNumber = new PrizeBonusNumber(prizeLotto, bonusNumber);
        PrizeLottoCompare prizeLottoCompare = new PrizeLottoCompare();
        prizeLottoCompare.calculatePrizeLottoCompare(prizeBonusNumber, lottoTickets);
        Rate rate = getRate(money, prizeLottoCompare);
        OutputView.printLotto_Result(prizeLottoCompare, rate);
    }

    //수익률 기능 분리
    private Rate getRate(Money money, PrizeLottoCompare prizeLottoCompare) {
        return new Rate(money, prizeLottoCompare);
    }


}
