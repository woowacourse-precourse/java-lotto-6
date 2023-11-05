package lotto;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {
    private static List<Lotto> Lottos = new ArrayList<>();
    private static List<Integer> winninglotto = new ArrayList<>();
    private static int[] MatchCount = new int[5];
    public void start(){
        int Chance = LottoIssue();
        Lottos = makeLottoNum(Chance);
        getWinningNumber();
        int BonusNum = getBonusNumber();
        WinningStatics(BonusNum);
        getRateOfReturn(Chance);
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
    public void WinningStatics(int BonusNum){
        PrintOutput printOutput = new PrintOutput();
        printOutput.printResult();
        WinningStatics winningStatics = new WinningStatics();
        MatchCount = winningStatics.HowMatch(Lottos,winninglotto,BonusNum);
        winningStatics.PrintWinningCount(MatchCount);
    }
    public void getRateOfReturn(int Chance){
        WinningStatics winningStatics = new WinningStatics();
        double ROR = winningStatics.getRateOfReturn(Chance);
        PrintOutput printOutput = new PrintOutput();
        printOutput.printRateOfReturn(ROR);
    }
}
