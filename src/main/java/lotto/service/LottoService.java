package lotto.service;


import java.util.List;

public interface LottoService {
    List<List<Integer>> buyLotto();
    List<Integer> getResult(List<List<Integer>> myLottoNumbers, List<Integer> numbers, int bonusNumber);
}
