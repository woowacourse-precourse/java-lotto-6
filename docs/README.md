# MVC 패턴으로 제작한 로또 게임

## Controller
    [ ] 구매 금액 사용자 입력

    [ ] 랜덤 생성 Lotto 전달

    [ ] 당첨 번호 사용자 입력

    [ ] 보너스 번호 사용자 입력
    
    [ ] 당첨 통계 View로 전달


## Service
    [ ] 금액을 전달받아 랜덤값 Lotto 생성

        ㄴ [ ] int 값이 아니면 error
    
    [ ] 정답 개수 갱신
    
    [ ] 수익률 게산

### 정답 번호
    [ ] 생성자로 정답 지정

    [ ] 정답과 같은 개수를 반환 

## View
    [ ] 구입 금액 입력 안내 출력
    
    [ ] 구매한 내역 출력
    
    [ ] 당첨 번호 입력 안내 출력
    
    [ ] 보너스 번호 입력 안내 출력
    
    [ ] 당첨 통계 출력


## Repository
    [ ] Lotto, Match Map store

    [ ] Service에서 가공된 데이터 전달받은 걸로 store save
    
    [ ] 전체 조회 findAll
    
    [ ] 갱신 update


## Domain
    [ ] Lotto

    [ ] Match (일치 개수 Enum)