package lotto.service;

import java.util.Collections;
import java.util.List;
import lotto.dto.MoneyDTO;
import lotto.enums.Constant;
import lotto.enums.OutputMessage;
import lotto.model.Lotto;
import lotto.repository.LottoRepository;
import lotto.utils.RandomGenerator;

public class OrderLottoServiceImpl implements OrderLottoService {
    private final LottoRepository lottoRepository;

    public OrderLottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void order(MoneyDTO moneyDTO) {
        Integer countOfLotto = getCountOfLotto(moneyDTO);

        for (int i = 0; i < countOfLotto; ++i) {
            Lotto lotto = new Lotto(createLotto());
            lottoRepository.save(lotto);
        }
    }

    @Override
    public List<Lotto> getOrderList() {
        List<Lotto> entireLotto = lottoRepository.findAll();
        return Collections.unmodifiableList(entireLotto);
    }

    private Integer getCountOfLotto(MoneyDTO moneyDTO) {
        return moneyDTO.getAmount() / Constant.MONEY_UNITS.getContentToInteger();
    }

    private List<Integer> createLotto() {
        return RandomGenerator.getRandomNumberList();
    }
}
