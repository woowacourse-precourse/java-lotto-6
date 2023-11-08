package lotto.domain.result;

import lotto.domain.customer.CustomerController;
import lotto.domain.winningnumber.WinningNumber;
import lotto.view.View;

import java.util.List;

public class ResultController {
    public WinningNumber winningNumber;
    public Result result;
    public ResultService resultService;
    public View view;

    public ResultController(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
        result = new Result(CustomerController.customer, winningNumber);
        resultService = new ResultService(result);
        resultService.giveStatistics();

        view = new View();
        view.statisticsTitle();
        List<Grade> grades = List.of(Grade.values());
        for (int i = 4; i >= 0; i--) {
            Grade grade = grades.get(i);
            view.notifyStatistics(grade, resultService.countGrade(grade));
        }
        view.notifyEarningRate(result.getEarningRate());
    }
}
