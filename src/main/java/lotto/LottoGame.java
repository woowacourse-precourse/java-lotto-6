package lotto;

import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        List<Integer> lottoNumbers = InputHandler.getUserInputlotto();

        Lotto lotto = new Lotto(lottoNumbers);
    }
}
