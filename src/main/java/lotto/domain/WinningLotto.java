package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.WinningLottoDto;
import lotto.observer.Observer;
import lotto.observer.Subject;

public class WinningLotto extends Lotto implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public void startCompare() {
        notifyObservers();
    }

    public WinningLottoDto toDto() {
        return new WinningLottoDto(getNumbers(), bonusNumber);
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        WinningLottoDto dto = toDto();
        for (Observer o : observers) {
            o.compare(dto);
        }
    }
}
