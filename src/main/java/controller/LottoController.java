package controller;

import domain.User;
import java.util.LinkedList;
import java.util.List;
import lotto.Lotto;
import repository.RankRepository;
import util.LottoNumber;
import util.ValidationBonusNumber;
import view.InputView;
import view.OutputView;

public class LottoController {

    private static final int START_INDEX = 0;

    private List<Lotto> lottoList;
    private User user;

    public LottoController() {

    }

    public void initGame() {
        lottoList = new LinkedList<>();
        makeLottoList();
        createUser();
    }

    public void startGame() {
        initGame();
        calcTwoNumberList();
    }

    public void calcTwoNumberList() {
        lottoList.forEach(lotto -> {
            Integer rank = lotto.getRank(user.getNumbers(), user.getBonusNumber());
            RankRepository.increaseNumberOfWins(rank);
        });
    }

    public void createUser() {
        List<Integer> numbers = InputView.inputWinningNumbers();
        Integer bonusNumber = InputView.inputBonusNumber(numbers);
        user = new User(numbers, bonusNumber);
    }

    public void makeLottoList() {
        Integer purchasePrice = InputView.inputPurchasePrice();
        Integer totalPurchaseQuantity = purchasePrice / 1000;
        OutputView.outputTotalPurchaseQuantity(totalPurchaseQuantity);
        for (int i=START_INDEX;i<totalPurchaseQuantity;i++) {
            lottoList.add(new Lotto(LottoNumber.makeLottoNumbers()));
        }
        OutputView.outputLottoList(lottoList);
    }
}
