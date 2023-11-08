package lotto.dto;

public record WinningStatisticDTO(String description, int prize, int winningCount) {

    public long getPrizeCashAmount() {
        return (long) prize * (long) winningCount;
    }

}
