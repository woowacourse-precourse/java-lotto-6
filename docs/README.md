## 기능 구현 목록

- 사용자로부터 입력 받기(한장 당 1000원)
    - 입력받은 금액이 숫자가 아닐시 `IllegalArgumentException` 발생
    - 입력 받은 금액이 1000의 배수가 아닐시 `IllegalArgumentException` 발생


- 입력받은 금액에 따라 중복되지 않는 1 ~ 45 사이의 랜덤한 숫자 6개를 생성


- 당첨번호 입력 받기
    - 입력 값이 숫자가 아닌 경우 `IllegalArgumentException` 발생 시키는 기능
    - 입력 값이 1~45 사이의 값이 아닌 경우 `IllegalArgumentException` 발생 시키는 기능
    - 입력 값에 중복된 수가 있을 경우 `IllegalArgumentException` 발생 시키는 기능


-보너스 번호를 입력 받기
    - 입력 값이 숫자가 아닌 경우 `IllegalArgumentException` 발생 시키는 기능
    - 입력 값이 1~45 사이가 아닌 경우 `IllegalArgumentException` 발생 시키는 기능


- 당첨 번호와 랜덤넘버를 비교하기
    - 6개 번호 모두 일치시 1등
    - 5개 일치 + 보너스 번호 일치 시 2등
    - 5개 일치 시 3등
    - 4개 일치 시 4등
    - 3개 일치 시 5등
    - 위의 결과를 출력하기

- 입금 금액과 당첨금액을 토대로 수익률을 계산
    - 당첨된 것 세기
    - 수익금 계산
    - 수익률 계산
