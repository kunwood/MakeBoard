import React, { useEffect, useState } from 'react';
import axios from "axios";
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import { Button } from '@mui/material';

export default function SignUp() {

    const [requestResult, setRequestResult] = useState<string>('')

const signUpHandler = () => {
    const data = {
        userEmail: "gwkim92@gmail.com",
        userPassword: "qwer1234",
        userPasswordCheck: "qwer1234",
        userNickname: "kunwood",
        userPhoneNumber: "010-1111-9999",
        userAddress: "대한민국 부산시",
        userAddressDetail: "수영구"
    }
    axios.post('http://localhost:4000/api/auth/signUp', data)
         .then((response) => {
            setRequestResult('Success!!');
         })
         .catch((errer) => {
            setRequestResult('Failed!!');
         })
}

  return (
    <Card  sx={{ minWidth: 275, maxWidth: "50vw" }}>
      <CardContent>    <Box>
      <TextField fullWidth label="이메일 주소" variant="standard" />
      <TextField fullWidth label="비밀번호" variant="standard" />
      <TextField fullWidth label="비밀번호 확인" variant="standard" />
      <TextField fullWidth label="닉네임" variant="standard" />
      <TextField fullWidth label="휴대폰 번호" variant="standard" />
      <TextField fullWidth label="주소" variant="standard" />
      <TextField fullWidth label="상세주소" variant="standard" />
    </Box>
    </CardContent>
    
      <CardActions>
      <Button fullWidth onClick={() => signUpHandler()} variant="contained">회원가입</Button>
      </CardActions>
    </Card>
  )
}
