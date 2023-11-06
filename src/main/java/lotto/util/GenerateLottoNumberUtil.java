package lotto.util;

import lotto.domain.GenerateLottoNumber;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class GenerateLottoNumberUtil {
    private GenerateLottoNumber generateLottoNumber;
    private Lotto lotto;

    private List<List<Integer>> lottonumbers;

    public GenerateLottoNumberUtil() {
        lottonumbers = new ArrayList<>();
    }

    //랜덤 로또번호 생성 후, 로또 클래스에 저장
    public void generateLottoNumber(){
        generateLottoNumber = new GenerateLottoNumber();
        lotto = new Lotto(generateLottoNumber.selectNumber());

        lottonumbers.add(lotto.getNumbers());
    }
    
    // 로또 클래스에 저장된 숫자들 리턴
    public List<Integer> getGenerateLottoNumber() {
        return lotto.getNumbers();
    }

    public List<Integer> getLotto(){
        return lotto.getNumbers();
    }

    public List<List<Integer>> getLottos(){
        return lottonumbers;
    }


}
