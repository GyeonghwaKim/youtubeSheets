package com.example.youtubeSheet.controller;


import com.example.youtubeSheet.dto.UserCreateRequestDto;
import com.example.youtubeSheet.dto.UserRequestDto;
import com.example.youtubeSheet.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class UserController {


    private final UserService userService;

    @GetMapping("/signup")
    public String join(Model model){
        model.addAttribute("signupForm",new UserCreateRequestDto());
        return "newSignupForm";
    }

    @PostMapping("/signup")
    public String createUser(
            @Valid @ModelAttribute("signupForm") UserCreateRequestDto userCreateRequestDto,
            BindingResult bindingResult){


        //NotBlank
        if(bindingResult.hasErrors()) return "newSignupForm";

        //컨트롤러에서 처리하는것이 낫다(유효성 검사)
        if(!userCreateRequestDto.getPassword()
                .equals(userCreateRequestDto.getConfirmPassword())){
            //임의로 정한 오류 코드 passwordIncorrect
            bindingResult.rejectValue("confirmPassword","passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");


            return "newSignupForm";
        }

        try{

            this.userService.createUser(userCreateRequestDto);
        }catch (DataIntegrityViolationException e
        ){
            e.printStackTrace();
            bindingResult.reject("signupFailed","이미 등록된 사용자입니다");
            return "newSignupForm";
        }

        catch (Exception e){
            e.printStackTrace();
            bindingResult.rejectValue("signupFailed",e.getMessage());
            return "newSignupForm";
        }


        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){

        return "newLoginForm";
    }



}