package lotto.dto;

public record WinStateInformationDTO(String description, int prize, int winningCount) {

    public long getPrizeCashAmount() {
        return (long) prize * (long) winningCount;
    }

}
