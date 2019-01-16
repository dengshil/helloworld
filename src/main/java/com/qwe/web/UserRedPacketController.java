package com.qwe.web;

import com.qwe.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {

    @Autowired
    private UserRedPacketService userRedPacketService;

    @RequestMapping(value = "/grapRedPacket.do")
    @ResponseBody
    public Map<String,Object>grapRedPacket(Long redPacketId,Long userId){
        //抢红包
        int result = userRedPacketService.grapRedPacket(redPacketId, userId);
        HashMap<String, Object> retMap = new HashMap<>();
        boolean flag =result > 0;
        retMap.put("success",flag);
        retMap.put("message",flag?"抢红包成功":"抢红包失败");
        return retMap;
    }
}
