import { useEffect, useState } from "react";
import { useRouter } from "next/router";

interface UserDto {
  userId: string;
}

export default function submit() {
  const router = useRouter();
  const [userNm, setUserNm] = useState<string>("");

  const handleClick = () => {
    router.push("/user/login");
  };

  useEffect(() => {
    const { query } = router;
    if (query.userNm) {
      const userName = Array.isArray(query.userNm)
        ? query.userNm[0]
        : query.userNm;
      setUserNm(userName);
    }
  }, [router]);

  return (
    <div id="main">
      <div className="section">
        <div className="container">
          <div className="row mb-6 align-items-center justify-content-center">
            <div className="col-md-6" data-aos="fade-up">
              <h2>환영합니다.</h2>
              <p>
                {userNm}님 안녕하세요. 회원가입이 완료되었습니다.
                <br />
                unislo를 이용해주셔서 감사합니다.
              </p>
              <p>
                <br></br>
              </p>
              <button
                type="button"
                className="readmore d-block w-50"
                onClick={handleClick}
              >
                로그인
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
