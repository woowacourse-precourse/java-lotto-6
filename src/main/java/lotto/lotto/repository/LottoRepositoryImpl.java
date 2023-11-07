package lotto.lotto.repository;

import lotto.lotto.dto.LottoDto;
import lotto.lotto.entity.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepositoryImpl implements LottoRepository {

    private final List<Lotto> lottos = new ArrayList<>();

    @Override
    public void saveLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        lottos.add(lotto);
    }

    @Override
    public LottoDto findOne(int idx) {
        LottoDto lottoDto = new LottoDto();
        lottoDto.setNumbers(lottos.get(idx).getNumbers());
        return lottoDto;
    }

    @Override
    public List<LottoDto> findAll() {
        List<LottoDto> findAllLottos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoDto lottoDto = new LottoDto();
            lottoDto.setNumbers(new ArrayList<>(lotto.getNumbers()));
            findAllLottos.add(lottoDto);
        }
        return findAllLottos;
    }
}
