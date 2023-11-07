package lotto;

import java.util.List;
import repository.RankRepository;
import view.OutputView;

public class Application {
    public static void main(String[] args) {


        RankRepository.increaseNumberOfWins(5);
        System.out.println(RankRepository.getRateOfReturn(8000));
        OutputView.outputRateOfReturn(RankRepository.getRateOfReturn(8000));
    }
}
