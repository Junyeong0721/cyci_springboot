package kr.soft.study.api;

import jakarta.servlet.http.HttpServletRequest;
import kr.soft.study.dto.BoardDTO;
import kr.soft.study.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class MemberController {

    @GetMapping("/")
    public void print(){
        System.out.println("first");


        log.info("가나다");
        MemberDTO member = new MemberDTO();
        member.setUserId("가나다");
        log.info("data : {}", member.toString());

        BoardDTO board = new BoardDTO();
        BoardDTO  board1 = BoardDTO
                .builder()
                .idx(5)
                .title("제목1")
                .content("내용1")
                .build();


    }
    @GetMapping("/data")
    public String data(){
        return "hello World";
    }
    @GetMapping("member")
    public MemberDTO member(){
        MemberDTO member = new MemberDTO();
        member.setUserId("superman");
        member.setUserPw("1234");

        return member;
    }
    @GetMapping("/idCheck")
    public MemberDTO idCheck(HttpServletRequest request){
        String id = request.getParameter("userId");


        MemberDTO member = new MemberDTO();
        member.setUserId(id);
        member.setUserPw("1234");

        return member;

    }

}
