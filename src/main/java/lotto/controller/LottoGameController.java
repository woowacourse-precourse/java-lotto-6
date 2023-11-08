package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.GameData;
import lotto.domain.Lotto;
import lotto.verifier.LottoNumberVerifier;
import lotto.verifier.LottoPurchaseVerifier;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGameController {
    private static final int LOTTO_PRICE = 1000;
    public void play() {
        String purchaseAmout = InputView.receiveInputWinningNumberMsg();

        new LottoPurchaseVerifier(purchaseAmout);
        int purchaseCount = Integer.parseInt(purchaseAmout);
        List<Lotto> lottos = purchaseLottos(purchaseCount);
        String winningnumbers = InputView.receiveInputWinningNumberMsg();
        new LottoNumberVerifier(winningnumbers);
        Lotto winningLotto = new Lotto(parseWinningNumbers(winningnumbers));
        int bonusNumber = Integer.parseInt(InputView.receiveInputBonusNumberMsg());
        GameData gameData = new GameData(winningLotto, bonusNumber, lottos);

//        calculateResult(gameData);
    }
    public List<Integer> parseWinningNumbers(String winningnumbers){
        return Arrays.stream(winningnumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
    private List<Lotto> purchaseLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        OutputView.printPurchaseMsg(lottoCount);
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)))
                .collect(Collectors.toList());
    }





}
