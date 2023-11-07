package lotto.service;


import camp.nextstep.edu.missionutils.Randoms;

import lotto.domain.Client;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Service {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;
    private static final int ONE = 1;
    private static final int ZERO =0;

    public void buyLotto(Client client){
        int count = client.getPurchaseAmount() / 1000;
        for(; count > ZERO;count--){
            Lotto lotto = generateLotto();
            client.addClientLotto(lotto);
        }
    }

    public Lotto generateLotto(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER,LOTTO_MAX_NUMBER,LOTTO_LENGTH));
        return new Lotto(numbers);
    }

    public void checkResult(Client client, Game game) {
        HashMap<Prize,Integer> result = client.getResult();
        for(Lotto lotto : client.getClientLottoList()){
            Prize prize = checkLottoPrize(game,lotto);
            result.put(prize, result.getOrDefault(prize,ZERO) + ONE);
        }
    }

    private Prize checkLottoPrize(Game game, Lotto lotto) {
        int correctCount = countCorrectLottoNumbers(game,lotto);
        boolean bonusNumberFlag = ContainBonusNumber(game,lotto);
        Prize prize = Prize.values()[correctCount];
        if(prize == Prize.THIRD && bonusNumberFlag){
            return Prize.SECOND;
        }
        return prize;
    }

    private boolean ContainBonusNumber(Game game, Lotto lotto) {
        return lotto.getNumbers().contains(game.getBonusNumber());
    }

    private int countCorrectLottoNumbers(Game game, Lotto lotto){
        int count = ZERO;
        List<Integer> winningNumbers = game.getWinningNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        for(int number : lottoNumbers){
            count += countContainNumber(winningNumbers,number);
        }
        return count;
    }

    private int countContainNumber(List<Integer> list, int number) {
        if (list.contains(number)) {
            return ONE;
        }
        return ZERO;
    }
}
