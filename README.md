# 우아한 테크코스 3주차 미션 로또

## 기능
### 입력
> - 로또 금액을 입력받는다. 입력 금액은 1000원 단위며, 1000원으로 나눠 떨어지지 않으면 예외대상이다.
> - 당첨번호를 총 6자리 입력받는다.(각 번호는 1~45 사이의 번호이다.) 번호는 쉼표로 구분된다.
> - 보너스 번호를 입력받는다.
> > 추가 예외사항
> > - 당첨번호 6자리와 보너스 번호는 중복되지 않는다.
> > - 보너스 번호 또한 1~45 사이의 숫자이다.

### 출력
> - 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
> - 당첨 내역을 출력한다.
> - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
> - 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
> > 추가 예외사항
> > - 금액을 출력할 경우 금액 단위에 맞게 출력한다.

### Lotto 클래스
- 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
- `numbers`의 접근 제어자인 private을 변경할 수 없다.
- `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
- `Lotto`의 패키지 변경은 가능하다.

### 클래스 기능
1. Lotto 클래스
- 로또 번호가 당첨 번호와 일치하는지 확인
```
class Lotto{
  private final List<Integer> number;

  private void validate(List<Integer> lottoNumbers){
    //로또 번호 6자리가 정상적으로 들어왔는지 확인
  }
  
  public int checkPrize(List<Integer> winnerList){
    //로또 번호와 당첨번호 중 일치하는 숫자 수 반환
  }
  
  public boolean checkBonus(int bonus){
    //보너스 번호와 일치하는 로또번호가 있는지 확인
  }

}
```
2. LottoStore 클래스
- 로또 번호를 발행
- 로또 번호들 중 당첨 결과 확인
- 성공률 확인
```
class LottoStore{
    private List<Lotto> tickets;
    private Map<Integer, Integer> winningResult;
    private Map<Integer, Integer> prizeMoneys;

    public void issueLottoTicket(int number){
      //입력한 수만큼 로또 티켓(로또번호 6자리) 발행
    }

    public void confirmWin(List<Integer> winnigNumber, int bonusNumber){
      //로또 당첨 결과 확인
    }

    public void setPrizeMoneys(){
      //등수에 따를 상금 지정
    }

    public void printTotalPrize(){
      //총 당첨결과를 출력
    }

    public void printPrizeRate(int ticketPrice){
      // 처음 구매한 금액과 당첨된 결과 수익 금액에 관한 수익률 계산 및 출력
    }

}
```

