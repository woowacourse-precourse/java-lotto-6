package lotto.domain;

import lotto.view.ExceptionMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static PlayerLottoAmount playerLottoAmount;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;

    public void start() {
        int ticketCount = setPlayerAmount();
        lottoList = setLottoList(ticketCount);

        //setWinningNumber();


    }

    private List<Lotto> setLottoList(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(setLotto());
        }
        return lottoList;
    }

    private Lotto setLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();

        lotto = LottoNumbers.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private int setPlayerAmount() {
        int ticketCount = inputPlayerAmount();
        OutputView.printLottoCount(ticketCount);
        return ticketCount;
    }

    private int inputPlayerAmount() {
        try {
            playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        } catch (IllegalArgumentException e) {
            ExceptionMessage.wrongValueException();
            playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        }
        return playerLottoAmount.purchaseTicketCount();
    }
}
