package lotto.controller;

import lotto.View.ExceptionMessage;
import lotto.View.InputView;
import lotto.View.OutputLottoList;
import lotto.View.OutputLottoResult;
import lotto.domiain.*;


import java.util.ArrayList;
import java.util.List;

import static lotto.View.ExceptionMessage.*;
import static lotto.View.OutputLottoList.*;
import static lotto.View.OutputLottoResult.*;
import static lotto.domiain.LottoGenerator.*;

public class LottoController {
    private static int ticketCount;
    private static List<Lotto> lotto = new ArrayList<>();
    private static int bonusNumber;

    public void Start() {
        LottoResult lottoResult = new LottoResult();
        LottoAmount lottoAmount = null;
        //구입금액 및 로또 생성 카운트
        while (true) {
            try {
                lottoAmount = new LottoAmount(InputView.setPurchaseAmount());
                ticketCount = lottoAmount.getTicketCount();
                printTicketCount(ticketCount);

                //로또 리스트 생성
                randomNumber(lotto, ticketCount);
                myLottoList(lotto, ticketCount);

                //당첨 로또 리스트
                Lotto winnerLotto = new Lotto(InputView.setLottoNumber());
                List<Integer> winnerLottoList = winnerLotto.getNumbers();

                //보너스 숫자 입력
                bonusNumber = InputView.setBonusBall();
                printResultMessage();
                WinningNumber winningNumber = new WinningNumber(winnerLottoList, bonusNumber);

                lottoResult.calWinningResult(winningNumber, lotto);

                RateOnReturn rateOnReturn = new RateOnReturn(lottoAmount, lottoResult);
                printStatistics(lottoResult, rateOnReturn);
                break;
            } catch (IllegalArgumentException e) {
            }
        }
        //로또 결과

    }
}
