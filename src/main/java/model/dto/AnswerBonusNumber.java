package model.dto;

import model.LottoNumber;

public record AnswerBonusNumber(String answerBonusNumber) {

    public LottoNumber toLottoNumber() {
        return new LottoNumber(Integer.parseInt(answerBonusNumber));
    }
}
