## 로또

### 소개
> 사용자에게 로또 구입 금액과 당첨 로또 번호를 입력받고, 그 금액만큼의 로또 번호를 뽑음<br/>
> 당첨 번호와 입력 번호를 비교하여 당첨 내역과 수익률을 계산

### 구현 명세
1. 로또 구입 금액 입력
    - 1000원으로 나누어 떨어지지 않는 경우 IllegalArgumentException
    - 나누어 떨어지는 값이 입력될 때 까지 다시 입력받음
    - WinLotto class 생성
2. 당첨 번호와 보너스 번호를 입력받는다.
    - 당첨 번호가 ,로 구분된 1~45의 6개의 숫자가 아니면 IllegalArgumentException
    - 보너스 번호가 1~45의 숫자 1개가 아니면 IllegalArgumentException
    - Exception이 발생하지 않는 입력을 받을 때까지 반복
    - 구매 Lotto class 생성, List에 추가
3. 당첨 통계 출력
    - List의 Lotto class들을 확인
    - 당첨 번호와 비교하여 당첨 등수 및 당첨 금액 계산 후 출력
    - 수익률 계산 