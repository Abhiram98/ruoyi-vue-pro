package cn.iocoder.yudao.module.ai.dal.dataobject.chat;

import cn.iocoder.yudao.framework.ai.chat.messages.MessageType;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.module.ai.dal.dataobject.model.AiChatModalDO;
import cn.iocoder.yudao.module.ai.dal.dataobject.model.AiChatRoleDO;
import cn.iocoder.yudao.module.ai.enums.AiOpenAiModelEnum;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * AI Chat 消息 DO
 *
 * @since 2024/4/14 17:35
 * @since 2024/4/14 17:35
 */
@TableName("ai_chat_message")
@KeySequence("ai_chat_conversation_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiChatMessageDO extends BaseDO {

    /**
     * 编号，作为每条聊天记录的唯一标识符
     */
    private Long id;

    /**
     * 会话编号
     *
     * 关联 {@link AiChatConversationDO#getId()}
     */
    private Long conversationId;

    /**
     * 消息类型
     *
     * 也等价于 OpenAPI 的 role 字段
     *
     * 枚举 {@link MessageType}
     */
    private String type;
    /**
     * 用户编号
     *
     * 仅当 user 发送时非空
     *
     * 关联 AdminUserDO 的 userId 字段
     */
    private Long userId;
    /**
     * 角色编号
     *
     * 仅当 assistant 回复时非空
     *
     * 关联 {@link AiChatRoleDO#getId()} 字段
     */
    private Long roleId;

    /**
     * 模型标志
     *
     * 枚举 {@link AiOpenAiModelEnum}
     */
    private String model;
    /**
     * 模型编号
     *
     * 关联 {@link AiChatModalDO#getId()} 字段
     */
    private Long modelId;

    /**
     * 聊天内容
     */
    private String content;
    /**
     * 消耗 Token 数量
     */
    private Integer tokens;

    // TODO 芋艿：是否作为上下文语料？use_context，待定

    // ========== 会话配置 ==========

    /**
     * 温度参数
     *
     * 冗余 {@link AiChatConversationDO#getTemperature()}
     */
    private Double temperature;
    /**
     * 单条回复的最大 Token 数量
     *
     * 冗余 {@link AiChatConversationDO#getMaxTokens()}
     */
    private Integer maxTokens;
    /**
     * 上下文的最大 Message 数量
     *
     * 冗余 {@link AiChatConversationDO#getMaxContexts()}
     */
    private Integer maxContexts;

}