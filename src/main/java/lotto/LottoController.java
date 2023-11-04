package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class LottoController {

    private LottoGame lg = new LottoGame();
    private int price = 0;
    private List<Lotto> lottoList;
    private Lotto winningNumbber;

    public List<Integer> lottoMaker(){
        List<Integer> lotto = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            int random = Randoms.pickNumberInRange(1,45);
            if(lotto.contains(random)){
                i--;
                continue;
            }
            lotto.add(random);
        }
        return lotto;
    }
    public void validatePrice(String number){
        validateNumber(number);
        isThousands(price);
    }
    public void validateNumber(String number){
        try{
            isNumber(number);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("[ERROR] 숫자만을 입력해야합니다.");
            lg.start();
        }
        price = Integer.parseInt(number);
    }
    public void isNumber(String number){
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i)<48 || number.charAt(i)>57) throw new IllegalArgumentException();
        }
    }
    public void isThousands(int number){
        try{
            if(price % 1000 != 0) throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("[ERROR] 1000원 단위로 입력해야합니다.");
            lg.start();
        }
    }
    public void buyLotto(){
        lottoList = new ArrayList<>();
        lottoList.add(new Lotto(lottoMaker()));
    }
}
