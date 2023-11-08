package lotto.model;

import lotto.controller.LottoMarket;
import lotto.view.UserInputView;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final UserWallet userWallet;
    private final LottoMarket lottoMarket;
    private final UserInputView userInputView;
    private final WinningLotto winningNumber;

    private List<Lotto> myLottoNumbers = new ArrayList<>();

    public User(){
        userInputView = new UserInputView();
        userWallet = UserWallet.createWallet(userInputView.userMoneyInput());
        lottoMarket = new LottoMarket();
        winningNumber = lottoMarket.winNumberLottoGenerate(
                userInputView.winLottoNumberInput(),
                userInputView.bonusNumberInput()
        );
    }

    public int useMoney(){
        return userWallet.buyLotto();
    }

    public void buyLotto(){
        myLottoNumbers = lottoMarket.buyLotto(useMoney());
        List<LottoRank> winnings = winLottoCheck();


        check();
    }

    public List<LottoRank> winLottoCheck(){
        List<LottoRank> winningsMoney = new ArrayList<>();
        myLottoNumbers.forEach(
                lotto -> winningsMoney.add(lotto.getMyRank(winningNumber))
        );

        return winningsMoney;
    }

    public void check(){

    }







}
