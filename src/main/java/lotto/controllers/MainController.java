package lotto.controllers;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.views.GameEnd;
import lotto.views.GameInit;
import lotto.views.GameOn;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainController {
    private final GameInit gameInit;
    private final GameOn gameOn;
    private final GameEnd gameEnd;

    List<Lotto> lottoes = new ArrayList<Lotto>();
    ArrayList<Integer> collectNum = new ArrayList<>();
    String[] price= new String [7];

    public MainController(GameInit gameInit, GameOn gameOn, GameEnd gameEnd) {
        this.gameInit = gameInit;
        this.gameOn = gameOn;
        this.gameEnd = gameEnd;

        price[3]="5,000";
        price[4]="50,000";
        price[5]="1,500,000";
        price[6]="2,000,000,000";
        for (int index=0;index<=6;index++){
            collectNum.add(0);
        }
    }

    public void setLotto(){
        int paperSize = gameInit.buyLotto();
        int paperNum = paperSize/1000;
        gameInit.showLotto(paperNum);

        for(int i =0 ; i<paperNum; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoes.add(lotto);
        }
        for(Lotto lotto:lottoes){
            gameInit.lottoView(lotto.getNumbers());
        }
    }

    public void checkNum(){
        String resultLine = gameOn.showCase();
        String token = ", ";
        StringTokenizer stringTokenizer = new StringTokenizer(resultLine, token);

        ArrayList<Integer> resultList = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens()){
            int thisToken=Integer.valueOf(stringTokenizer.nextToken());
            resultList.add(thisToken);
        }
        Lotto goal = new Lotto(resultList);

        for(Lotto lotto : lottoes){
            int howMany=goal.howMany(lotto.getNumbers());
            int temp = collectNum.get(howMany);

            collectNum.set(howMany, temp+1);
        }
    }

    public void endGame(){
        gameEnd.showResult(collectNum, price);
    }
}
