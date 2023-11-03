package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.User;
import lotto.domain.Winner;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class LottoService {
    private static final Integer LOTTO_PRICE = 1000;
    private final InputView inputView;
    private final OutputView outputView;
    private User user;
    private Winner winner;

    public LottoService(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void decideHowMuchToBuy(){
        outputView.printInputHowMuchToBuyGuideMessage();
        Long totalAmount = inputView.inputTotalAmount();
        user = new User(totalAmount);
    }

    public void buyLotto(){
        Long amountOfLottoPapers = Long.valueOf(user.getTotalAmount()/LOTTO_PRICE);
        user.buyLotto(amountOfLottoPapers);
        outputView.printAllLottoNumbers(amountOfLottoPapers, user.getLottoList());
    }

    public void announceWinner(){
        outputView.printInputWinnerNumbersGuideMessage();
        List<Integer> numbers = inputView.inputWinnerNumbers();
        outputView.printInputBonusNumberGuideMessage();
        Integer bonusNumber = inputView.inputBonusNumber();

        winner = new Winner(numbers,bonusNumber);
    }

    public void matchLotto(){
        user.matchLotto(winner);
    }

    public void showStatistics(){
        List<Lotto> lottoList = user.getLottoList();
        Map<Rank,Integer> rankMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankMap.put(rank, 0);
        }

        lottoList.stream()
                .map(Lotto::getRank)
                .forEach(rank -> rankMap.put(rank,rankMap.get(rank)+1));
        Double percentage = (user.getTotalPrize().doubleValue() / user.getTotalAmount().doubleValue()) * 100.0;
        outputView.printStatistics(rankMap,percentage);
    }
}
