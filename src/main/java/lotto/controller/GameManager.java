package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    private static final int LOTTO_SIZE = 6;
    private int money;
    private int count;
    private List<Lotto> lottos;

    private InputManager inputManager;
    private MessageManager messageManager;

    public GameManager() {
        this.inputManager = new InputManager();
        this.messageManager = new MessageManager();
        money = -1;
        this.lottos = new ArrayList<>();
    }

    public void addCoin(){
        while (money == -1){
            money = inputManager.inputMoney();
        }
    }

    public void setCount(){
        count = money / 1000;
    }

    public void createUserLottos(){
        setCount();

        for(int i = 0; i<count; i++){
            lottos.add(createLotto());
        }

        messageManager.buyLottos(count, lottos);
    }

    protected Lotto createLotto(){
        List<Integer> lotto = new ArrayList<>();
        for(int i=0 ;i< LOTTO_SIZE; i++) {
            lotto.add(setRandomNumber(lotto));
        }
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    protected int setRandomNumber(List<Integer> lotto){
        int number;
        do{
            number = Randoms.pickNumberInRange(1, 45);
        } while(lotto.contains(number));

        return number;
    }



}
