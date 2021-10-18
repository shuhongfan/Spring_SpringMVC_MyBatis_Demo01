package com.shf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shf.beans.User;
import com.shf.beans.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping(value = "/quick")
    public String save(){
        System.out.println("Controller save running....");
//        转发资源地址
        return "success";
    }

    @RequestMapping("/quick2")
    public ModelAndView save2(){
//        Model模型 用于封装数据  view视图 用于展示数据
        ModelAndView modelAndView = new ModelAndView();
//        设置视图名称
        modelAndView.setViewName("success");
//        设置模型数据
        modelAndView.addObject("username","shf");
        return modelAndView;
    }

    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.setViewName("success");
        modelAndView.addObject("username","zhangsan");
        return modelAndView;
    }

    @RequestMapping("/quick4")
    public String save4(Model model){
        model.addAttribute("username","lisi");
        return "success";
    }

    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","原生servlet");
        return "success";
    }

    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello world");
    }

    @RequestMapping("/quick7")
    @ResponseBody  // 告知spring不进行视图跳转，直接进行数据相应
    public String save7(){
        return "hello spring";
    }

    @RequestMapping("/quick8")
    @ResponseBody
    public String save8() throws JsonProcessingException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(18);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public User save9(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(33);

        return user;
    }

    @RequestMapping("/quick10")
    @ResponseBody
    public void save10(String username,int age){
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(User user){
        System.out.println(user);
    }

    @RequestMapping("/quick12")
    @ResponseBody
    public void save12(String[] args){
        System.out.println(Arrays.asList(args));
    }

    @RequestMapping("/quick13")
    @ResponseBody
    public void save13(VO vo){
        System.out.println(vo);
    }

    @RequestMapping("/quick14")
    @ResponseBody
    public void save14(@RequestBody List<User> userList){
        System.out.println(userList);
    }

    @RequestMapping("/quick15")
    @ResponseBody
    public void save15(@RequestParam(value = "name",required = false,defaultValue = "zhangsan") String username){
        System.out.println(username);
    }

    @RequestMapping("/quick16/{username}")
    @ResponseBody
    public void save16(@PathVariable("username") String username) {
        System.out.println(username);
    }

    @RequestMapping("/quick17")
    @ResponseBody
    public void save17(Date date){
        System.out.println(date);
    }

    @RequestMapping("/quick18")
    @ResponseBody
    public void save18(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping("/quick19")
    @ResponseBody
    public void save19(@RequestHeader("User-Agent") String useragent){
        System.out.println(useragent);
    }

    @RequestMapping("/quick20")
    @ResponseBody
    public void save20(@CookieValue("JSESSIONID") String session){
        System.out.println(session);
    }

    @RequestMapping("/quick21")
    @ResponseBody
    public void save21(String username, MultipartFile[] upload) throws IOException {
//        获取上传文件的名称
        for (MultipartFile file : upload){
            String originalFilename = file.getOriginalFilename();
            file.transferTo(new File("D:\\FTP\\"+originalFilename));
        }
    }

}
