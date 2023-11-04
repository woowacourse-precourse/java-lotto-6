package lotto.model;

import java.util.StringJoiner;

public enum Price {
     FIRST("6개 일치", "(2,000,000,000원)"),
     SECOND("5개 일치, 보너스 볼 일치 ", "(30,000,000원)"),
     THIRD("5개 일치", "(1,500,000원)"),
     FORTH("4개 일치", "(50,000원)"),
     FIFTH("3개 일치", "(5,000원)");

     private String guideline;
     private String reward;

     private Price(String guideline, String reward) {
          this.guideline = guideline;
          this.reward = reward;
     }

     public String getGuideline(Price price) {
           return price.guideline;
     }

     public String getReward(Price price) {
          return price.reward;
     }
}
