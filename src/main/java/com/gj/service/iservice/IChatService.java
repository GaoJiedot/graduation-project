package com.gj.service.iservice;

import com.gj.pojo.Chat;
import com.gj.pojo.dto.ChatDto;

import java.util.List;

public interface IChatService {


    Chat sendChat(ChatDto chat);

    List<Chat> getChatListByUserId(Integer userId);

    List<Chat> getHistoryChat(Integer userId, Integer friendId);

    Chat uploadShopLogo(Integer userId, String avatarPath);
}
