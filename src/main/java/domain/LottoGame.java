package domain;

import static constants.GameConstant.DEFAULT_LOTTO_NUMBER_LENGTH;
import static constants.GameConstant.MAX_LOTTO_NUMBER;
import static constants.GameConstant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    public List<Lotto> getLottoList(int lottoCount){
        List<Lotto> lottoList = new ArrayList<>();

        IntStream.range(0, lottoCount)
                .forEach(i -> {
                    List<Integer> lottoNumbers = createLottoNumbers();
                    lottoNumbers = getAscendingSort(lottoNumbers);
                    lottoList.add(new Lotto(lottoNumbers));
                });

        return lottoList;
    }

    private List<Integer> getAscendingSort(List<Integer> lottoList){
        return lottoList.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> createLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                DEFAULT_LOTTO_NUMBER_LENGTH);

    }

}
