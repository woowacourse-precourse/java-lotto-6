package lotto.service;


import java.util.List;

public interface LottoService {
    List<List<Integer>> buyLotto();
    void checkResult(List<List<Integer>> myLottoNumbers, List<Integer> numbers, int bonusNumber);
}
