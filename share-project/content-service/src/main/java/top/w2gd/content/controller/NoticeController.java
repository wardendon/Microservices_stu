package top.w2gd.content.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.w2gd.content.common.ResponseResult;
import top.w2gd.content.service.NoticeService;

/**
 * @author w2gd
 */
@RestController
@RequestMapping("/notice")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/latest")
    public ResponseResult getNotice(){
        return ResponseResult.success(noticeService.getLatestNotice());
    }

}
