package lotto.observer;

import lotto.dto.WinningLottoDto;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
