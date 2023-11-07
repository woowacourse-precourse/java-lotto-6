package lotto.controller;

import lotto.domin.Lotto;
import lotto.domin.LottoNumbers;
import lotto.domin.PlayerLottoAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.OutputView.PrintLottoNumbers;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayerLottoAmount playerLottoAmount = null;
        playerLottoAmount = getPlayerLottoAmount(playerLottoAmount);
        int count = playerLottoAmount.calculateLottoCount();
        OutputView.printTicketCount(count);

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = null;
            getLottoList(lottoList, lotto);
        }


    }

    private static PlayerLottoAmount getPlayerLottoAmount(PlayerLottoAmount playerLottoAmount) {
        while (true) {
            try {
                return playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayPay());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getLottoList(List<Lotto> lottoList, Lotto lotto) {
        while (true) {
            try {
                lotto = makeLotto();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        lottoList.add(lotto);
    }

    public static Lotto makeLotto() throws IllegalArgumentException {
        List<Integer> numbers = new LottoNumbers().LottoNumbers();
        PrintLottoNumbers(numbers);
        return new Lotto(numbers);
    }



}
