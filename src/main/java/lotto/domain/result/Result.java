package lotto.domain.result;

import lotto.domain.customer.Customer;
import lotto.domain.winningnumber.WinningNumber;

import java.util.List;

public class Result {
    private Customer customer;
    private WinningNumber winningNumber;

    private List<Grade> grades;
    private String earningRate;

    public Result(Customer customer, WinningNumber winningNumber) {
        this.customer = customer;
        this.winningNumber = winningNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public String getEarningRate() {
        return earningRate;
    }

    public void setEarningRate(String earningRate) {
        this.earningRate = earningRate;
    }
}
