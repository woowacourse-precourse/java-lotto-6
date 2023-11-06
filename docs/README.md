# 미션 - 로또

## Lotto 클래스
- 로또 1장을 나타냄
### 변수
- `numbers` : 로또 번호 6자리
```agsl
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
```

### 함수
- `Lotto()` : 인스턴스 초기화 함수
```agsl
- input : 로또 번호 6자리
```
- `compare_lottery_numbers()` : `numbers` 중 `winning_numbers`와 겹치는 수의 개수 계산
```agsl
- input : `winning_numbers`
- output: 일치 개수
```
- `compare_bonus_number()` : `numbers` 중 `bonus_number`가 포함되어있는지
```agsl
- input : `bonus_number`
- output: 있으면 1, 없으면 0
```
- `check_winnings()` : 로또 결과
```agsl
- input : `winning_numbers`, `bonus_number`
- output: 등수 (1-5등) or -1(당첨 X)
```
- `print_lottery_numbers()` : 로또 번호 출력

## Application

### 변수
- `my_lottery_tickects` : 사용자가 구매한 개수만큼 Lotto 객체를 List로 저장
- `order_price` : 로또 구매 금액
- `order_numbers` : 로또 구매 개수
- `winning_numbers` : 당첨 번호
- `bonus_number` : 보너스 번호


### 함수
- `get_order_price()` : `order_price` 입력 받은 후, `order_numbers` 계산
```agsl
- 예외 처리
- `IllegalArgumentException` : 입력 받은 값이 1000으로 나누어 떨어지지 않는 경우
```
- `get_winning_numbers()` : `winning_numbers` 입력 받기
```agsl
- 예외 처리
- `IllegalArgumentException` : 숫자가 1~45 사이의 정수가 아닌 경우, 문자 포함 등
```
- `get_bonus_number()` : `bonus_number` 입력 받기
```agsl
- 예외 처리
- `IllegalArgumentException` : 숫자가 1~45 사이의 정수가 아닌 경우, 문자 포함 등
```
- `purchase()` : `order_price`만큼 로또 구매 실행
- `show_result()` : 로또 구매 결과 계산 및 프린트
```agsl
- `my_result` : 로또 구매 결과 리스트
- 만약, `order_numbers`가 5라면,
  my_result는 초기에 [0, 0, 0, 0, 0, 0] 으로 선언됨
- my_result[0] : 꽝 개수
- my_result[i] : i등 개수

- 'IllegalStateException` : sum(my_result) != `order_numbers` 인 경우
```
