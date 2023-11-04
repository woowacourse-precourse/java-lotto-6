package lotto.gameUtil;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.domain.Enum.Rank;
import lotto.view.OutputView;

import java.util.*;

public class GameLogic {
    OutputView outputView;
    private Map<Rank, Integer> ranks = new HashMap<>();
    public GameLogic(){
        outputView = new OutputView();
        initRank();
    }
    private void initRank(){
        ranks.put(Rank.FIRST, 0);
        ranks.put(Rank.SECOND, 0);
        ranks.put(Rank.THIRD, 0);
        ranks.put(Rank.FORTH, 0);
        ranks.put(Rank.FIFTH, 0);
    }
    public List<Lotto> lottoNumber(int amount){
        int count = amount / 1000;
        outputView.countMessage(count);
        List<Lotto> lottoes = new ArrayList<>();

        for(int i=0;i<count;i++){
            List<Integer> lottoNumbers = makingLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lotto.sortNumber();
            lottoes.add(lotto);
            outputView.lottoNumberMessage(lotto.toString());
        }
        return lottoes;
    }
    public List<Integer> makingLottoNumbers(){
        List<Integer> tmpLottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        List<Integer> lottoNumbers = new ArrayList<>(tmpLottoNumbers);
        return lottoNumbers;
    }
    public Lotto winningNumber(String[] winningNumber){
        List<Integer> winningNumbers = new ArrayList<>();
        for(String str : winningNumber){
            winningNumbers.add(Integer.parseInt(str));
        }
        Lotto lotto = new Lotto(winningNumbers);
        return lotto;
    }
    public String[] splitNumber(String number){
        String[] splitNumber = number.split(",");
        return splitNumber;
    }
    public int matchCount(Lotto buyingLotto, Lotto winningLotto, int bonus){
        int[] buyingLottoNumber = buyingLotto.toIntegerArr();
        Set<Integer> winningLottoNumber = winningLotto.toSet();

        int count = 0;
        for(int i=0;i<6;i++){
            if(winningLottoNumber.contains(buyingLottoNumber[i]) || buyingLottoNumber[i] == bonus){
                count++;
            }
        }
        return count;
    }
    public boolean matchBonus(Lotto buyingLotto, int bonus){
        Set<Integer> buyingLottoNumber = buyingLotto.toSet();
        if(buyingLottoNumber.contains(bonus)){
            return true;
        }
        return false;
    }
    public void matchLotto(int count, boolean isSecond){
        if(count == 6 && !isSecond){
            firstRank();
        }
        if(count == 6 && isSecond){
            secondRank();
        }
        if(count ==5){
            thirdRank();
        }
        if(count == 4){
            forthRank();
        }
        if(count == 3){
            fifthRank();
        }
    }
    public void firstRank(){
        ranks.put(Rank.FIRST, ranks.get(Rank.FIRST)+1);
    }
    public void secondRank(){
        ranks.put(Rank.SECOND, ranks.get(Rank.SECOND)+1);
    }
    public void thirdRank(){
        ranks.put(Rank.THIRD, ranks.get(Rank.THIRD)+1);
    }
    public void forthRank(){
        ranks.put(Rank.FORTH, ranks.get(Rank.FORTH)+1);
    }
    public void fifthRank(){
        ranks.put(Rank.FIFTH, ranks.get(Rank.FIFTH)+1);
    }
    public Map<Rank, Integer> getRanks(){
        return ranks;
    }
    public void lottoResult(Map<Rank, Integer> ranks, int amount) {
        Double prize = 0D;
        prize += ranks.get(Rank.FIRST) * Rank.FIRST.getAmount();
        prize += ranks.get(Rank.SECOND) * Rank.SECOND.getAmount();
        prize += ranks.get(Rank.THIRD) * Rank.THIRD.getAmount();
        prize += ranks.get(Rank.FORTH) * Rank.FORTH.getAmount();
        prize += ranks.get(Rank.FIFTH) * Rank.FIFTH.getAmount();

        outputView.matchingMessage(ranks, (prize*100) / amount);
    }
}
