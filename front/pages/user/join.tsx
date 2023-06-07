import React, { useState, useEffect } from "react";
import axios from "axios";

interface UserDto {
  userId: string;
  userNm: string;
  userPw: string;
  userTelno: string;
  userYn: string;
}

export default function join() {
  const [userDto, setUserDto] = useState<UserDto>({
    userId: "",
    userNm: "",
    userPw: "",
    userTelno: "",
    userYn: "n",
  });

  // 컴포넌트가 마운트될 때 서버에서 사용자 정보를 가져옵니다.
  // useEffect(() => {
  //   axios
  //     .get("/user/info") // 사용자 정보를 가져오는 엔드포인트라고 가정합니다.
  //     .then((response) => {
  //       const { userId, userNm, userTelno } = response.data;
  //       setUserDto((prevUserDto) => ({
  //         ...prevUserDto,
  //         userId,
  //         userNm,
  //         userTelno,
  //       }));
  //     })
  //     .catch((error) => {
  //       console.error(error);
  //     });
  // }, []);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setUserDto((prevUserDto) => ({
      ...prevUserDto,
      [name]: value,
    }));
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    axios
      .post(`${process.env.NEXT_PUBLIC_SERVER_URL}/user/join-proc`, userDto) //브라우저에서 사용하려면 NEXT_PUBLIC_ 붙여야함
      .then((response) => {
        console.log(response.data);
        // 성공 처리 로직 작성
      })
      .catch((error) => {
        console.error(error.response.data);
        console.error(userDto);
        // 오류 처리 로직 작성
      });
  };
  return (
    <div id="main">
      <div className="section pb-5">
        <div className="container">
          <div className="row mb-5 align-items-end justify-content-center">
            <div className="col-md-6" data-aos="fade-up">
              <h2>회원가입</h2>
            </div>
          </div>
          <div className="row justify-content-center">
            <div className="col-md-6 mb-5 mb-md-0 " data-aos="fade-up">
              <form name="myform" id="myform" onSubmit={handleSubmit}>
                <div className="row gy-3 ">
                  <div className="col-md-9 form-group">
                    <label>아이디</label>
                    <input
                      type="text"
                      className="form-control"
                      name="userId"
                      id="userId"
                      value={userDto.userId}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="col-md-3 form-group">
                    <label></label>
                    <button
                      type="button"
                      className="readmore d-block w-100"
                      name="idCheck"
                      id="idCheck"
                    >
                      중복확인
                    </button>
                  </div>
                  <div className="col-md-12 form-group">
                    <label>이름</label>
                    <input
                      type="text"
                      className="form-control"
                      name="userNm"
                      id="userNm"
                      value={userDto.userNm}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="col-md-6 form-group">
                    <label>비밀번호</label>
                    <input
                      type="password"
                      name="userPw"
                      className="form-control"
                      id="userPw"
                      value={userDto.userPw}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="col-md-6 form-group">
                    <label>비밀번호 확인</label>
                    <input
                      type="password"
                      className="form-control"
                      name="userPw2"
                      id="userPw2"
                      required
                    />
                  </div>
                  <div className="col-md-12 form-group">
                    <label>전화번호</label>
                    <input
                      type="tel"
                      className="form-control"
                      name="userTelno"
                      id="userTelno"
                      value={userDto.userTelno}
                      onChange={handleChange}
                      required
                    />
                  </div>

                  <div className="col-md-12 mt-20 form-group">
                    <div className="col-md-12 my-3">
                      <div
                        className="join_fail"
                        id="re"
                        style={{ display: "none" }}
                      >
                        모든 정보를 입력해주세요.
                      </div>
                    </div>
                    <button
                      type="submit"
                      className="readmore d-block w-100"
                      id="btnJoin"
                    >
                      가입하기
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
