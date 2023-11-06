package lotto.event;

import java.util.function.Consumer;
import java.util.function.Function;
import lotto.repository.LottoRepository;

public record EventListener(LottoRepository lottoRepository) {

    public void listen(Function<LottoRepository, Event> eventConstructor) {
        eventConstructor.apply(lottoRepository).execute();
    }

    /**
     * 결과만 있는 이벤트
     *
     * @param eventConstructor
     * @param <R>
     * @return
     */
    public <R> R listenWithResult(Function<LottoRepository, ReturnEvent<R>> eventConstructor) {
        return eventConstructor.apply(lottoRepository).execute();
    }

    /**
     * 파라미터만 있는 이벤트
     *
     * @param eventConstructor
     * @param <T>
     * @return
     */
    public <T> Consumer<T> listenWithParameter(Function<LottoRepository, ParameterEvent<T>> eventConstructor) {
        return (input) -> eventConstructor.apply(lottoRepository).execute(input);

    }

    /**
     * 파라미터와 결과 모두 있는 이벤트
     *
     * @param eventConstructor
     * @param <T>
     * @param <R>
     * @return
     */
    public <T, R> Function<T, R> listenWithParameterAndResult(Function<LottoRepository, ParameterAndReturnEvent<T, R>> eventConstructor) {
        return (input) -> eventConstructor.apply(lottoRepository).execute(input);
    }


    public interface Event {
        void execute();
    }

    public interface ParameterEvent<T> {
        void execute(T input);
    }

    public interface ReturnEvent<R> {
        R execute();
    }

    public interface ParameterAndReturnEvent<T, R> {
        R execute(T input);
    }
}
