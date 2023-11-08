package lotto;

import view.View;

public class LottoGame {
    private final static int UNIT=1000;
    private Lotto answer;
    private Lotto[] consumerAnswer;
    private int total;
    private int bonus;

    public void gameStart(){
        lottoGameInput();
        lottoGameResult();
    }
    private void lottoGameInput(){
        LottoService lottoService=new LottoService();
        total= View.getPrice()/UNIT;
        answer=new Lotto(View.getAnswer());
        bonus=View.getBonus(answer);
        consumerAnswer=lottoService.makeLottoList(total);
        View.showTotalLotto(consumerAnswer);
    }
    private void lottoGameResult(){
        LottoService lottoService=new LottoService();
        int[] result=lottoService.compareAllLotto(consumerAnswer,answer,bonus);
        View.showLottoResult(result,total*UNIT);
    }
}
