import React, { useState, useEffect } from "react";
import axios from "axios";
import { useForm } from "react-hook-form";
import { useRouter } from "next/router";

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
  const [isIdReadOnly, setIsIdReadOnly] = useState<boolean>(false); //ID중복 체크 후 readonly 변경
  const [error, setError] = useState<string>("");
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors },
  } = useForm();
  const router = useRouter();

  // 컴포넌트가 마운트될 때 서버에서 사용자 정보를 가져옵니다. (업데이트 코드)
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

  const idCheckButton = () => {
    const emailPattern = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if (!userDto.userId.match(emailPattern)) {
      setError("올바른 이메일 형식이 아닙니다.");
      setTimeout(() => {
        setError("");
      }, 5000); // 5초 후에 에러 메시지 초기화
      return;
    }
    axios
      .post(`${process.env.NEXT_PUBLIC_SERVER_URL}/user/id-check`, userDto, {
        headers: {
          "Content-Type": "application/json",
        },
      })
      .then((response) => {
        const data = response.data; // 서버에서 반환된 JSON 데이터
        const result = data.result; // HashMap에서 'result' 키의 값
        if (result === "impossible") {
          alert("이미 사용 중인 아이디입니다.");
        } else if (result === "possible") {
          alert("사용 가능한 아이디입니다.");
          setIsIdReadOnly(true);
        }
      })
      .catch((error) => {
        console.error("오류:", error);
      });
  };

  const validatePassword = (password: string) => {
    const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d|\W).{8,}$/;
    return regex.test(password);
  };

  const handleValidation = () => {
    let isValid = true;

    // 패스워드 유효성 검사 (10글자 이상)
    if (!validatePassword(userDto.userPw)) {
      setError(
        "비밀번호는 영어, 특수문자, 숫자 중 2개 이상을 포함하여 8자 이상이어야 합니다."
      );
      setTimeout(() => {
        setError("");
      }, 5000);
    }

    // 패스워드 일치 여부 검사
    if (userDto.userPw !== watch("userPw2")) {
      setError("비밀번호가 일치하지 않습니다.");
      setTimeout(() => {
        setError("");
      }, 5000); // 5초 후에 에러 메시지 초기화
      isValid = false;
    }

    return isValid;
  };

  // const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
  //   e.preventDefault();
  //   axios
  //     .post(`${process.env.NEXT_PUBLIC_SERVER_URL}/user/join-proc`, userDto) //브라우저에서 사용하려면 NEXT_PUBLIC_ 붙여야함
  //     .then((response) => {
  //       console.log(response.data);
  //       // 성공 처리 로직 작성
  //     })
  //     .catch((error) => {
  //       console.error(error.response.data);
  //       // 오류 처리 로직 작성
  //     });
  // };

  const onSubmit = () => {
    if (handleValidation()) {
      axios
        .post(`${process.env.NEXT_PUBLIC_SERVER_URL}/user/join-proc`, userDto)
        .then((response) => {
          router.push("/user/submit");
        })
        .catch((error) => {
          console.error(error.response.data);
          // 오류 처리 로직 작성
        });
    }
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
              <form name="myform" id="myform" onSubmit={handleSubmit(onSubmit)}>
                <div className="row gy-3 ">
                  <div className="col-md-9 form-group">
                    <label>아이디</label>
                    <input
                      type="email"
                      className="form-control"
                      {...register("userId", { required: true })}
                      name="userId"
                      id="userId"
                      value={userDto.userId}
                      onChange={handleChange}
                      readOnly={isIdReadOnly}
                      placeholder="이메일을 입력해주세요."
                    />
                  </div>
                  <div className="col-md-3 form-group">
                    <label></label>
                    <button
                      type="button"
                      className="readmore d-block w-100"
                      name="idCheck"
                      id="idCheck"
                      onClick={idCheckButton}
                    >
                      중복확인
                    </button>
                  </div>
                  <div className="col-md-12 form-group">
                    <label>이름</label>
                    <input
                      type="text"
                      className="form-control"
                      {...register("userNm", { required: true })}
                      name="userNm"
                      id="userNm"
                      value={userDto.userNm}
                      onChange={handleChange}
                      placeholder="이름을 입력해주세요."
                    />
                  </div>
                  <div className="col-md-12 form-group">
                    <label>비밀번호</label>
                    <input
                      type="password"
                      {...register("userPw", { required: true })}
                      name="userPw"
                      className="form-control"
                      id="userPw"
                      value={userDto.userPw}
                      onChange={handleChange}
                      placeholder="비밀번호는 10글자 이상 영어,숫자, 특수문자 중 2개를 포함해 주세요."
                    />
                  </div>
                  <div className="col-md-12 form-group">
                    <label>비밀번호 확인</label>
                    <input
                      type="password"
                      {...register("userPw2", { required: true })}
                      className="form-control"
                      name="userPw2"
                      id="userPw2"
                      placeholder="같은 비밀번호를 입력해주세요."
                    />
                  </div>
                  <div className="col-md-12 form-group">
                    <label>전화번호</label>
                    <input
                      type="tel"
                      className="form-control"
                      {...register("userTelno", { required: true })}
                      name="userTelno"
                      id="userTelno"
                      value={userDto.userTelno}
                      onChange={handleChange}
                      placeholder="전화번호를 입력해주세요."
                    />
                  </div>

                  <div className="col-md-12 mt-20 form-group">
                    <button
                      type="submit"
                      className="readmore d-block w-100"
                      id="btnJoin"
                    >
                      가입하기
                    </button>
                    <div className="col-md-12 my-3">
                      <div
                        className="join_fail"
                        id="re"
                        style={{ display: error ? "block" : "none" }}
                      >
                        {error}
                      </div>
                    </div>
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
