package cn.iocoder.yudao.module.ai.service.chat;

import cn.iocoder.yudao.module.ai.controller.admin.chat.vo.conversation.AiChatConversationCreateMyReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.chat.vo.conversation.AiChatConversationUpdateMyReqVO;
import cn.iocoder.yudao.module.ai.dal.dataobject.chat.AiChatConversationDO;

import java.util.List;

/**
 * AI 聊天对话 Service 接口
 *
 * @author fansili
 */
public interface AiChatConversationService {

    /**
     * 创建【我的】聊天会话
     *
     * @param createReqVO 创建信息
     * @param userId 用户编号
     * @return 编号
     */
    Long createChatConversationMy(AiChatConversationCreateMyReqVO createReqVO, Long userId);

    /**
     * 更新【我的】聊天会话
     *
     * @param updateReqVO 更新信息
     * @param userId 用户编号
     */
    void updateChatConversationMy(AiChatConversationUpdateMyReqVO updateReqVO, Long userId);

    /**
     * 获得【我的】聊天会话列表
     *
     * @param userId 用户编号
     * @return 聊天会话列表
     */
    List<AiChatConversationDO> getChatConversationListByUserId(Long userId);

    /**
     * 获得聊天会话
     *
     * @param id 编号
     * @return 聊天会话
     */
    AiChatConversationDO getChatConversation(Long id);

    /**
     * 删除【我的】聊天会话
     *
     * @param id 编号
     * @param userId 用户编号
     */
    void deleteChatConversationMy(Long id, Long userId);

    /**
     * 校验 - 是否存在
     *
     * @param id
     * @return
     */
    AiChatConversationDO validateExists(Long id);

    /**
     * 删除 - 所有对话，置顶除外
     *
     * @param loginUserId
     */
    void deleteMyAllExceptPinned(Long loginUserId);
}