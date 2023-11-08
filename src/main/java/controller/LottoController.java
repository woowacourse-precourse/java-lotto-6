package controller;

import dto.UserDTO;
import java.util.LinkedList;
import java.util.List;
import lotto.Lotto;
import repository.RankRepository;
import util.LottoNumber;
import view.InputView;
import view.OutputView;

public class LottoController {

    private static final int START_INDEX = 0;
    private static final Integer UNIT_NUMBER = 1000;

    private List<Lotto> lottoList;
    private UserDTO userDTO;

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
        endGame();
    }

    public void endGame() {
        Integer purchasePrice = lottoList.size() * UNIT_NUMBER;
        OutputView.outputWinningStatistics();
        OutputView.outputRateOfReturn(RankRepository.getRateOfReturn(purchasePrice));
    }

    public void calcTwoNumberList() {
        lottoList.forEach(lotto -> {
            Integer rank = lotto.getRank(userDTO.getNumbers(), userDTO.getBonusNumber());
            RankRepository.increaseNumberOfWins(rank);
        });
    }

    public void createUser() {
        List<Integer> numbers = InputView.inputWinningNumbers();
        Integer bonusNumber = InputView.inputBonusNumber(numbers);
        userDTO = new UserDTO(numbers, bonusNumber);
    }

    public void makeLottoList() {
        Integer purchasePrice = InputView.inputPurchasePrice();
        Integer totalPurchaseQuantity = purchasePrice / UNIT_NUMBER;
        OutputView.outputTotalPurchaseQuantity(totalPurchaseQuantity);
        for (int i = START_INDEX;i < totalPurchaseQuantity;i++) {
            lottoList.add(new Lotto(LottoNumber.makeLottoNumbers()));
        }
        OutputView.outputLottoList(lottoList);
    }
}
