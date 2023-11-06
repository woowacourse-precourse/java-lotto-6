package lotto;

import Input.LottoInput;
import View.View;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoGame {
    private Lotto answer;
    private Lotto[] consumerAnswer;
    private int total;
    private int bonus;

    public void gameStart(){
        lottoGameInput();
    }
    private void lottoGameInput(){
        LottoService lottoService=new LottoService();
        total= View.getPrice()/1000;
        answer=new Lotto(View.getAnswer());
        bonus=View.getBonus();
        consumerAnswer=lottoService.makeLottoList(total);
        View.showTotalLotto(consumerAnswer);
    }
}
