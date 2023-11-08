package lotto.util;

import lotto.domain.GenerateLottoNumber;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class GenerateLottoNumberUtil {
    private GenerateLottoNumber generateLottoNumber;
    private Lotto lotto;
    private List<List<Integer>> lottoNumbers;

    public GenerateLottoNumberUtil() {
        lottoNumbers = new ArrayList<>();
    }

    /**
     * 로또번호 랜덤 생성 후, 로또 클래스에 저장 -> 다수의 로또 클래스가 생성될 수 있으므로, 리스트를 담는 리스트타입의 lottoNumbers에 lotto 리스트 저장
     */
    public void generateLottoNumber(){
        generateLottoNumber = new GenerateLottoNumber();
        lotto = new Lotto(generateLottoNumber.selectNumber());
        lottoNumbers.add(lotto.getNumbers());
    }

    public List<Integer> getGenerateLottoNumber() {
        return lotto.getNumbers();
    }

    public List<Integer> getLotto(){
        return lotto.getNumbers();
    }

    public List<List<Integer>> getLottos(){
        return lottoNumbers;
    }


}
