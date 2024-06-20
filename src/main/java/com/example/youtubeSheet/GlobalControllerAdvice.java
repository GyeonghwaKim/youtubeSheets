package com.example.youtubeSheet;


import com.example.youtubeSheet.entity.MusicSheet;
import com.example.youtubeSheet.entity.dto.MusicSheetForm;
import com.example.youtubeSheet.entity.dto.SiteUserDto;
import com.example.youtubeSheet.service.MusicSheetService;
import com.example.youtubeSheet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@ControllerAdvice
public class GlobalControllerAdvice {

    private final MusicSheetService musicSheetService;

    private final UserService userService;



    @ModelAttribute("musicSheetList")
    public List<MusicSheet> showsSheetList(Principal principal){

        if(principal ==null) return null;

        SiteUserDto siteUserDto=this.userService.getUser(principal.getName());

        return this.musicSheetService.showSheetList(siteUserDto);

    }

    @ModelAttribute("modifyTitle")
    public MusicSheetForm sheetTitleForm(){

        return new MusicSheetForm();
    }
}