package com.deepexi.product.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.deepexi.product.service.ProductService;
import com.deepexi.product.domain.eo.Product;
//import com.deepexi.user.service.UcUserService;
import com.deepexi.user.domain.eo.User;
import com.deepexi.user.service.UserService;
import com.deepexi.util.JsonUtil;
import com.deepexi.util.config.Payload;
import com.deepexi.util.constant.ContentType;
import com.deepexi.util.pageHelper.PageBean;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Path("/api/v1/products")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    UserService userService;
    @Autowired
    private ProductService productService;

    @GET
    @Path("/")
    public Payload getProductList(@QueryParam("page") @DefaultValue("1")  Integer page,
                                  @QueryParam("size") @DefaultValue("10")  Integer size,
                                  @QueryParam("price") @DefaultValue("0")  Integer price) {
        System.out.println("getProductList");
        return new Payload(productService.getProductList(page, size, price));
    }

    @GET
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload getProductById(@PathParam("id") String id) {
        return new Payload(productService.getProductById(id));
    }

    @POST
    @Path("/")
    public Payload createProduct(Product product) {
        return new Payload(productService.createProduct(product));
    }

    @PUT
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload updateProductById(@PathParam("id") String id, Product product) {
        return new Payload(null);
    }

    @DELETE
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload deleteProductById(@PathParam("id") String id) {
        return new Payload(productService.deleteProductById(id));
    }

    @GET
    @Path("/getUserList")
    public PageBean getUserList(@QueryParam("page") @DefaultValue("1")   Integer page,
                                @QueryParam("size") @DefaultValue("10")   Integer size,
                                @QueryParam("age") @DefaultValue("0")  Integer age){
        System.out.println("进入了product.getUserList");
        PageBean<User> bean = userService.getUserList(page,size,age);
       return bean;
    }
    @ResponseBody
    @GET
   @Path("/insertUser")
    public String insertUser(@QueryParam("userName") String userName,
                               @QueryParam("age") int age,
                               @QueryParam("userNumber") String userNumber,
                               @QueryParam("nickName") String nickName,
                               @QueryParam("email") String email){
       System.out.println("进入insertUser");
        User user = new User();
        user.setId(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        user.setUserName(userName);
        user.setAge(age);
        user.setUserNumber(userNumber);
        user.setNickName(nickName);
        user.setEmail(email);
        Integer b = userService.createUser(user);
        return JSONUtils.toJSONString(b);
    }

    @GET
    @Path("/del")
    public String del(@QueryParam("id") String id){
        return JSONUtils.toJSONString(userService.deleteUserById(id));
    }

    @GET
    @Path("/update")
    public String update(@QueryParam("id") String id,
                          @QueryParam("userName") String userName,
                          @QueryParam("age") int age,
                          @QueryParam("userNumber") String userNumber,
                          @QueryParam("nickName") String nickName,
                          @QueryParam("email") String email){
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setAge(age);
        user.setUserNumber(userNumber);
        user.setNickName(nickName);
        user.setEmail(email);
        return JSONUtils.toJSONString(userService.update(user));
    }

    @GET
    @Path("/query")
    public User queryById(@QueryParam("id") String id){
        return userService.getUserById(id);
    }

}
