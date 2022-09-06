package top.w2gd.content.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.w2gd.content.common.ResponseResult;
import top.w2gd.content.domain.dto.ShareDto;
import top.w2gd.content.domain.entity.Share;
import top.w2gd.content.domain.entity.User;
import top.w2gd.content.openfeign.UserService;
import top.w2gd.content.service.ShareService;

/**
 * @author w2gd
 */
@RestController
@Slf4j
@RequestMapping("/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {
    private final ShareService shareService;
    private final UserService userService;

    @GetMapping("{id}")
    public ResponseResult getShareById(@PathVariable Integer id) {
        Share share = shareService.findById(id);
        Integer userId = share.getUserId();
        ResponseResult res = userService.getUser(userId);
        String jsonString = JSONObject.toJSONString(res.getData());
        JSONObject obj = JSONObject.parseObject(jsonString);
        User user = JSONObject.toJavaObject(obj,User.class);

        System.out.println(user);

        ShareDto shareDto = ShareDto.builder().share(share).nickName(user.getNickname()).avatar(user.getAvatar()).build();

        return ResponseResult.success(shareDto);
    }
}
