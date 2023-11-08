package lotto.service;
import lotto.Input.InputView;
import lotto.Lotto;
import lotto.Output.OutputView;
import lotto.domain.UserLotto;

import java.util.*;
import java.util.stream.IntStream;

public class LottoService {
    private UserLotto userBuyingLottos;
    private final int lottoAmount = 1000;
    private Lotto correctLotto;
    private int lottoCount;
    private int bonusNumber;
    private int mainCorrect;
    private int bountCorrect;
    private final List<Integer> prizeCashes;
    private List<Integer> prizeCount;

    public LottoService(){
        prizeCashes = List.of(5000,50000,1500000,30000000,2000000000);
        prizeCount = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }
    public void calLottoCount(){
        OutputView.printLottoAmount();
        int totalPurchaseAmount = InputView.readPurchaseAmount();
        lottoCount = totalPurchaseAmount/(lottoAmount);
        OutputView.printLottoCount(lottoCount);
        userBuyingLottos = new UserLotto(lottoCount);
    }

    public void setCorrect(){
        OutputView.printAnswerMessage();
        List<Integer> corrects = InputView.readAnswerNumber();
        correctLotto = new Lotto(corrects);
        OutputView.printBonusMessage();
        int bonus = InputView.readBonusNumber();
        bonusNumber = bonus;
    }

    private long checkCorrect(List<Integer> userLottoNumbers){
        long corretCount = userLottoNumbers.stream()
                .filter(correctLotto.getLottoNumber()::contains)
                .count();
        return corretCount;
    }

    private int checkBonus(List<Integer> userLottoNumbers){
       return Collections.frequency(userLottoNumbers, bonusNumber);
    }

    private void calNumberResult(Lotto userLotto) {
        List<Integer> userLottoNumbers = userLotto.getLottoNumber();
        long correctCount = checkCorrect(userLottoNumbers);
        int bonusCount = checkBonus(userLottoNumbers);
        checkRank(correctCount,bonusCount);
    }

    public void runCheckUserLottos(){
        userBuyingLottos.userLottos.forEach(lotto -> calNumberResult(lotto));
        OutputView.printCorrectMessage(prizeCount);
    }
    private void checkRank(long correctCount,int bonusCount) {
        if(correctCount == 6){
            prizeCount.set(4, prizeCount.get(4) + 1);
        } else if (correctCount == 5 & bonusCount == 1) {
            prizeCount.set(3, prizeCount.get(3) + 1);
        } else if (correctCount == 5 & bonusCount == 0) {
            prizeCount.set(2, prizeCount.get(2) + 1);
        } else if (correctCount == 4 ) {
            prizeCount.set(1, prizeCount.get(1) + 1);
        } else if (correctCount == 3) {
            prizeCount.set(0, prizeCount.get(0) + 1);
        }
    }

    public void calReturnRate(){
        int totalReturnCash = IntStream.range(0, prizeCashes.size())
                .mapToObj(i -> prizeCashes.get(i) * prizeCount.get(i))
                .mapToInt(Integer::intValue)
                .sum();
        double totalPurchaseAmount = lottoCount*lottoAmount;
        double returnRate = ((totalReturnCash - totalPurchaseAmount) / totalPurchaseAmount) * 100;
        OutputView.printReturnRateMessage(returnRate);
    }
}
