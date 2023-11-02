# MVC 패턴으로 제작한 로또 게임

## Controller
사용자 입력 > Service로 전달

전달 받은 정답 View로 전달


## Service
Controller에서 전달받은 데이터를 split 후 Repository에 전달

ㄴ int 값이 아니면 error

정답 개수 체크 및 갱신

ㄴ 전체 정답 배열 Controller 전달

수익률 게산

### 검증
범위 내의 값인지 확인

중복 값인지 확인

## View
구입 금액 입력 안내 출력

구매한 내역 출력

당첨 번호 입력 안내 출력

보너스 번호 입력 안내 출력

전달 받은 내역으로 > 당첨 통계 출력


## Repository
Lotto, 일치개수 Map store

Service에서 가공된 데이터 전달받은 걸로 store save

findAll

update


## Domain
Lotto

일치개수(Enum)