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
        LottoService lottoService=new LottoService();
        total= View.getPrice()/1000;
        consumerAnswer=lottoService.makeLottoList(total);
        View.showTotalLotto(consumerAnswer);

    }

}
