package lotto.controller;

import static lotto.view.Input.inputAmount;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoSetNumber;
import lotto.model.PlayerPurchase;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private static List<Lotto> lottoAllNumbers;
    private static List<Integer> lottoList;

    public void run() {
        start();

    }

    public void start() {
        Output.input_Purchase_Amount(); // 구입 금액을 입력해주세요
        int lottoCount = inputPlayerAmount(); // 구입 금액 입력 후 계산 -> 8개 구매

        Output.print_Lotto_Count(lottoCount); // 8개를 구매했습니다.
        createLottoAllList(); // 로또 6개 번호

        Output.input_Winning_Number();
        Input.input_BonusNumber();

        Output.input_Bonus_Number();
        Input.input_BonusNumber();
    }


    public int inputPlayerAmount() {
        PlayerPurchase playerPurchase = new PlayerPurchase(inputAmount());
        return playerPurchase.calculateLottoCount();
    }

    // 랜덤으로 뽑아낸 8개 로또 찍어냄.
    private static List<Lotto> createLottoAllList() {
        lottoAllNumbers = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            lottoAllNumbers.add(createLottoList()); // 랜덤 숫자 6개를 8번 넣음.
        }
        return lottoAllNumbers;
    }

    private static Lotto createLottoList() {
        LottoSetNumber lottoSetNumber = new LottoSetNumber();
        lottoList = lottoSetNumber.setRandomNumbers();

        System.out.println(lottoList);
        return new Lotto(lottoList);
    }

    
}
