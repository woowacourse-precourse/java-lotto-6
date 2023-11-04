package lotto;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {
    private static List<Lotto> Lottos = new ArrayList<>();
    private static List<Integer> winninglotto = new ArrayList<>();
    public void start(){
        int Chance = LottoIssue();
        Lottos = makeLottoNum(Chance);
        getWinningNumber();
        int BonusNum = getBonusNumber();
        MergeWinningAndBonus(BonusNum);
        //System.out.println(Lottos.get(7).getNumbers());

    }
    public int LottoIssue(){
        LottoInput lottoInput = new LottoInput();
        int lottoMoney = lottoInput.getLottoPrice();
        LottoPrice lottoPrice = new LottoPrice(lottoMoney);
        return lottoPrice.makeReturnNum();
    }
    public List<Lotto> makeLottoNum(int Chance){
        GenLotto genLotto = new GenLotto();
        Lottos = genLotto.makeLottoNum(Chance);
        return Lottos;
    }
    public void getWinningNumber(){
        PrintInput printInput = new PrintInput();
        printInput.printWinningLotto();
        LottoInput lottoInput = new LottoInput();
        winninglotto = lottoInput.getWinningNum();
    }
    public int getBonusNumber(){
        PrintInput printInput = new PrintInput();
        printInput.printBonusLotto();
        LottoInput lottoInput = new LottoInput();
        return lottoInput.getBonusNum();
    }
    public void MergeWinningAndBonus(int BonusNum){
        winninglotto.add(BonusNum);
    }
}
