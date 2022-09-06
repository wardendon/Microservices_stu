package top.w2gd.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.w2gd.user.common.ResponseResult;
import top.w2gd.user.domain.entity.User;
import top.w2gd.user.domain.entity.dto.UserDto;
import top.w2gd.user.service.UserService;

/**
 * @author w2gd
 */
@RestController
@Slf4j
@RequestMapping(value = "/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    public final UserService userService;

    @GetMapping("{id}")
    public ResponseResult getUserById(@PathVariable Integer id) {
        System.out.println("getUser......");
        return ResponseResult.success(userService.findById(id));
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody UserDto userDto) {
        return ResponseResult.success(userService.login(userDto));
    }
}
