package lotto;

import java.text.DecimalFormat;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
    private List<Lotto> lottos;

    private HashMap<LottoRank.Rank, Integer> ranks;
    private IOGetter ioGetter;
    private int n_lottos;
    private Lotto winningLotto;
    private int bonusNumber;

    public LottoGame() {
        this.lottos = new ArrayList<>();
        this.ranks = new HashMap<>();
        initRankCounter();
        this.ioGetter = new IOGetter();
        this.n_lottos = 0;
        this.winningLotto = null;
        this.bonusNumber = 0;
    }

    public void playGame(){
        try{
            n_lottos = moneyToLottos(ioGetter.getMoney());

            generateLottos(n_lottos);

            ioGetter.printNLottos(n_lottos);
            printAllLottos(n_lottos);

            String[] rawWinningNums =  ioGetter.getWinningLotterNumbers().split(",");
            winningLotto = new Lotto(parseLotteryNumbers(rawWinningNums));

            bonusNumber = varifyDigit(ioGetter.getBonusNumber());
            if(isDuplicatesLottoDigit(winningLotto.getNumbers(), bonusNumber)){
                throw new IllegalArgumentException("[ERROR]");
            }

            checkLotteryResult(n_lottos);
            makeResultView();
        }
        catch (Exception e){
            System.out.println("[ERROR]");
        }

    }

    public int moneyToLottos(String paid){
        int money = varifyDigit(paid);
        if(money % 1000 != 0){
            throw new IllegalArgumentException();
        }
        if(money < 1000){
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }

    public int varifyDigit(String var){
        try{
            return Integer.parseInt(var);
        }
        catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    public void generateLottos(int n_lottos){
        for(int i = 0; i < n_lottos; i++){
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public void printAllLottos(int n_lottos){
        String[] message = new String[n_lottos];
        for(int i = 0; i < n_lottos; i++){
            message[i] = lottos.get(i).toString();
        }
        ioGetter.printLottos(message);
    }

    public List<Integer> parseLotteryNumbers(String[] data){
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < data.length; i++){
            winningNumbers.add(varifyDigit(data[i]));
        }
        return winningNumbers;
    }

    public boolean isDuplicatesLottoDigit(List<Integer> list, int digit){
        return list.contains(digit);
    }

    public void checkLotteryResult(int n_lottos){
        for (int i = 0; i < n_lottos; i++){
            int correct = lottos.get(i).gradingLotto(winningLotto);
            boolean hasBonus = lottos.get(i).checkBonusNumber(bonusNumber);
            LottoRank.Rank r = LottoRank.Rank.getLottoResult(correct, hasBonus);
            if(r.getPrice() != 0){
                //ranks.add(r);
                ranks.put(r, ranks.get(r)+1);
            }
        }
    }

    public void initRankCounter(){
        for(LottoRank.Rank rank : LottoRank.Rank.values()){
            if(rank.price != 0){
                ranks.put(rank, 0);
            }
        }
    }

    public void makeResultView(){
        double incomeRate = 0;
        List<String> info = new LinkedList<>();
        for (LottoRank.Rank rank: LottoRank.Rank.values()){
            if(rank.price != 0){
                info.add(new String(rank.message + ranks.get(rank) + "개"));
                incomeRate += rank.price * ranks.get(rank);
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        info.add(decimalFormat.format((incomeRate / (n_lottos*1000)*100)));
        ioGetter.printResult(info);
    }

}
