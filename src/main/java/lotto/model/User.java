package lotto.model;

import lotto.controller.LottoMarket;
import lotto.view.UserInputView;
import lotto.view.UserOutputView;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final UserWallet userWallet;
    private final LottoMarket lottoMarket;
    private final UserInputView userInputView;
    private final UserOutputView userOutputView;
    private final WinningLotto winningNumber;

    private List<Lotto> myLottoNumbers = new ArrayList<>();
    private List<LottoRank> winningsMoney = new ArrayList<>();

    public User() {
        userInputView = new UserInputView();
        userOutputView = new UserOutputView();
        userWallet = UserWallet.createWallet(userInputView.userMoneyInput());
        lottoMarket = new LottoMarket();
        myLottoNumbers = lottoMarket.buyLotto(useMoney());
        userOutputView.boughtLottoPrint(myLottoNumbers);
        winningNumber = lottoMarket.winNumberLottoGenerate(
                userInputView.winLottoNumberInput(),
                userInputView.bonusNumberInput()
        );
    }

    public int useMoney() {
        return userWallet.buyLotto();
    }

    public void buyLotto() {
        List<LottoRank> winnings = winLottoCheck();
        userWallet.receiveWinningsMoney(
                lottoMarket.winningsReceive(winnings)
        );

        userOutputView.statistics(userWallet.usedMoney(),
                userWallet.getMoney(),
                lottoMarket.getMyHistory(winningsMoney)
        );
    }

    public List<LottoRank> winLottoCheck() {
        myLottoNumbers.forEach(
                lotto -> winningsMoney.add(lotto.getMyRank(winningNumber))
        );

        return winningsMoney;
    }
}
