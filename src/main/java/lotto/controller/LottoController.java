package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.service.LottoNumbers;

public class LottoController {
    public LottoController(){
    }

    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;

    public void run() {
        boolean validAmountEntered = false;
        while (!validAmountEntered) {
            try {
                start();
                validAmountEntered = true;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println("올바른 입력을 다시 시도하세요.");
            }
        }
    }

    public void start() {
        int ticketAmount = InputView.getAmount();
        int lottoCount = OutputView.getLottoCount(ticketAmount);

        lottoList = getLottoList(lottoCount);
    }

    private static List<Lotto> getLottoList(int lottoCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(MakeLottoNumber());
        }
        return lottoList;
    }

    private static Lotto MakeLottoNumber() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.getRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }
}
