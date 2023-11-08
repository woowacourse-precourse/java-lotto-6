# 기능요구

### 🍿 구현할 기능 리스트

- 로또 구입 금액 입력
    - 빈값 입력시 IllegalArgumentException 발생
    - 1000원 단위로 나누어 떨어지지 않을시 IllegalArgumentException 발생
- 값을 1000원으로 나누어서 로또 갯수 계산
- 당첨 번호 입력
    - 당첨 번호 입력 ,기준 파싱
    - 빈값 입력시 IllegalArgumentException 발생
    - 자연수가 아닐시 IllegalArgumentException 발생
    - 6개가 아닐시 IllegalArgumentException 발생
    - 1~45사이의 숫자가 아닐시 IllegalArgumentException 발생
- 보너스 번호 입력
    - 빈값 입력시 IllegalArgumentException 발생
    - 자연수가 아닐시 IllegalArgumentException 발생
    - 1개가 아닐시 IllegalArgumentException 발생
    - 1~45사이의 숫자가 아닐시 IllegalArgumentException 발생
    - 당첨번호와 중복될 시 IllegalArgumentException 발생
- 모든 에러 메시지는 [ERROR]로 시작
- 에러가 발생한 부분부터 입력을 다시 받기
- 1~45 까지의 6자리 , 중복되지 않는 난수 생성기
- Enum을 통한 Rank 구현
- 당첨 번호와 모든 로또 비교
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 위에서 비교한 당첨 내역으로 당첨 통계 저장
- 수익률 계산
    - (당첨가격의 합 /구매가격 *100)
    - 소수점 둘째 자리 반올림
- 결과 출력
    - 로또 번호
    - 당첨 통계
    - 수익률

### 🍿 시나리오

1. 금액을 입력한다
2. 금액을 수량으로 바꾸고 로또를 생성한다
3. 모든 로또를 출력한다
4. 당첨번호를 입력한다
5. 보너스 번호를 입력한다
6. 로또 당첨 결과를 출력한다
7. 로또 수익률을 출력한다

### 🍿 패키지 구조

- controller
- domain
- exception
- util
- view