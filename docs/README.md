# 로또 기능 구현 목록

## 기능
- [x] 입력
  - [x] 구입 금액 입력 
    - [x] (구입 금액/1000) 개 만큼 로또 생성
  - [x] 당첨 번호 입력
  - [x] 보너스 번호 입력
  - 
- [x] 계산
  - [x] 구매한 로또 각각 당첨 번호랑 비교 후 Map에 보관   

- [x] 출력
  - [x] 구매 로또 출력
  - [x] 당첨 통계 출력
  - [x] 총 수익률 출력

## 테스트
- [x] 로또 게임 기능 테스트
  - [x] 구매한 로또와 당첨 번호 비교 후 결과 테스트
  - [x] 맞은 개수 테스트
  - [x] 보너스 넘버 맞았는지 테스트
  - [x] 전체 맞은 개수 별 랭크 개수 증가 테스트
  - [x] 전체 당첨 금액 테스트
  - [x] 수익률 테스트
  
- [x] 예외 테스트
  - [x] 구매 금액 입력 예외
    - [x] 구매 금액에 문자 입력시 IllegalArgumentException.class 발생
    - [x] 구매 금액이 1000원으로 나누어 떨어지지 않을 시 IllegalArgumentException.class 발생
    - [x] 구매 금액이 1000원보다 작으면 IllegalArgumentException.class 발생
    
  - [x] 당첨 번호 입력 예외
    - [x] 당첨 번호에 문자 입력시 IllegalArgumentException.class 발생
    - [x] 당첨 번호가 1 미만 45 초과일 시 IllegalArgumentException.class 발생
    - [x] 당첨 번호가 6개가 아닐 시 IllegalArgumentException.class 발생
    - [x] 당첨 번호가 중복될 시 IllegalArgumentException.class 발생    
    
  - [x] 보너스 번호 입력 예외
    - [x] 보너스 번호에 문자 입력시 IllegalArgumentException.class 발생
    - [x] 보너스 번호가 1 미만 45 초과일 시 IllegalArgumentException.class 발생
    - [x] 보너스 번호가 기존의 당첨 번호랑 중복될 시 IllegalArgumentException.class 발생
