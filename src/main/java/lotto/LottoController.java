package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoController {

    private LottoGame lg;
    private PriceValidator priceValidator = new PriceValidator();
    private int price = 0;
    private List<Lotto> lottoList;
    private Lotto winningNumber;

    public void makeLottoGameInstance(LottoGame lottoGame){
        lg = lottoGame;
    }
    public boolean validatePrice(String number){
        if(!priceValidator.validateNumber(number, lg)) return false;
        price = Integer.parseInt(number);
        if(!priceValidator.validateThousands(price, lg)) return false;
        return true;
    }
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
    public String buyLotto(){
        lottoList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int times = price/1000;
        for(int i = 0; i < times; i++){
            Lotto lotto = new Lotto(lottoMaker());
            lottoList.add(lotto);
            sb.append(lotto.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean pickWinningNumber(String number){
        List<Integer> list = new ArrayList<>();
        boolean isValidated = priceValidator.validateWinningNumber(number, lg);
        if(isValidated) {
            StringTokenizer st = new StringTokenizer(number, ",");
            while(st.hasMoreElements()){
                int lottoNumber = Integer.parseInt(st.nextToken());
                list.add(lottoNumber);
            }
            winningNumber = new Lotto(list);
            return true;
        }
        return false;
    }
}
