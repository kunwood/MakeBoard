import { Button, CardActions, CardHeader, TextField } from "@mui/material";
import React, { useState } from "react";
import { Card } from "@mui/material";
import { CardContent } from "@mui/material";
import { Box } from "@mui/material";
import axios from "axios";
import { useCookies } from "react-cookie";
import { useUserStore } from "../../../stores";
import { Typography } from "@mui/material";
import { signInApi } from "../../../apis";

interface Props {
  setAuthView: (authView: boolean) => void;
}

// 로그인 페이지
export default function SignIn(props: Props) {
  const [userEmail, setUserEmail] = useState<string>("");
  const [userPassword, setUserPassword] = useState<string>("");

  const [cookies, setCookies] = useCookies();

  const { user, setUser } = useUserStore();

  const { setAuthView } = props;

  const signInHandler = async () => {
    if (userEmail.length === 0 || userPassword.length === 0) {
      alert("이메일과 비밀번호를 입력하세요.");
      return;
    }

    const data = {
      userEmail,
      userPassword,
    };

    const signInResponse = await signInApi(data);

    if (!signInResponse) {
      alert("로그인에 실패했습니다.");
      return;
    }
    if (!signInResponse.result) {
      alert("로그인에 실패했습니다.");
      return;
    }
    const { token, exprTime, user } = signInResponse.data;
    const expires = new Date();
    expires.setMilliseconds(expires.getMilliseconds() + exprTime);

    setCookies("token", token, { expires });
    setUser(user);

  };
  return (
    <Card sx={{ minWidth: 275, maxWidth: "40vw", padding: 5 }}>
      <Box>
        <Typography variant="h5">로그인</Typography>
      </Box>
      <Box height={"50vh"}>
        <TextField
          fullWidth
          label="이메일"
          type="email"
          variant="standard"
          onChange={(e) => setUserEmail(e.target.value)}
        />
        <TextField
          fullWidth
          label="비밀번호"
          type="password"
          variant="standard"
          onChange={(e) => setUserPassword(e.target.value)}
        />
      </Box>

      <Box component="div">
        <Button fullWidth onClick={() => signInHandler()} variant="contained">
          로그인
        </Button>
      </Box>
      <Box component="div" display="flex" mt={2}>
        <Typography>신규 사용자 이신가요?</Typography>
        <Typography fontWeight={800} ml={1} onClick={() => setAuthView(true)}>
          회원가입
        </Typography>
      </Box>
    </Card>
  );
}
