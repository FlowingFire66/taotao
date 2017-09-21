package com.taotao.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * User: FlowingFire
 * Date: 2017/9/19 0019
 * Time: 14:32
 * Description:
 */
public class TestPageHelper {
    @Test
    public void testPageHelper(){
        //创建一个spring 容器
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        TbItemMapper bean = applicationContext.getBean(TbItemMapper.class);
        TbItemExample example=new TbItemExample();
        PageHelper.startPage(1,10);
        List<TbItem> tbItems = bean.selectByExample(example);
        for(TbItem tbItem : tbItems) {
            System.out.println(tbItem.getTitle());
        }
        //从spring容器获得Mapper的代理对象
        //执行查询，并分页
    }
}
