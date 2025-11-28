package kr.soft.study.service;

import kr.soft.study.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {
    @Autowired
    MemberMapper memberMapper;

    public void testConnection(){
        String text = memberMapper.textConnection();
        log.info("text: {}", text);
    }

}
