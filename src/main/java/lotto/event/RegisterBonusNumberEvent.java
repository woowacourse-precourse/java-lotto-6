package lotto.event;

import lotto.event.EventListener.ParameterEvent;
import lotto.repository.LottoRepository;

public record RegisterBonusNumberEvent(LottoRepository lottoRepository) implements ParameterEvent<Integer> {
    @Override
    public void execute(Integer input) {
        final var updateAnswerLotto = lottoRepository.findAnswerLotto()
                .registerBonusNumber(input);

        lottoRepository.save(updateAnswerLotto);
    }
}
