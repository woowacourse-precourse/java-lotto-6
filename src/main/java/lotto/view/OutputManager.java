package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputManager {
    public void printMessage(String outputMessage) {
        System.out.println(outputMessage);
    }

    public void printLotto(List<Integer> lottoNumbers) {
        String message = lottoNumbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        message = "[" + message + "]";
        printMessage(message);
    }

    public void AnnounceStatistic(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {

    }

}
