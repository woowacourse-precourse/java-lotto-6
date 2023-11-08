package lotto.domain.result;

import lotto.domain.customer.Customer;
import lotto.domain.winningnumber.WinningNumber;

import java.util.List;

public class Result {
    private Customer customer;
    private WinningNumber winningNumber;

    private List<Grade> grades;
    private float earningRate;

    public Result(Customer customer, WinningNumber winningNumber) {
        this.customer = customer;
        this.winningNumber = winningNumber;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public float getEarningRate() {
        return earningRate;
    }

    public void setEarningRate(float earningRate) {
        this.earningRate = earningRate;
    }
}
