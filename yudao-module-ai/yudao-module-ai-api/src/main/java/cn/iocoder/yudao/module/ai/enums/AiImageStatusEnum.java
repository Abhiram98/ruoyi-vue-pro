package cn.iocoder.yudao.module.ai.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ai绘画状态
 *
 * @author fansili
 * @time 2024/4/28 17:05
 * @since 1.0
 */
@AllArgsConstructor
@Getter
public enum AiImageStatusEnum {

    SUBMIT("submit", "提交任务"),
    WAITING("waiting", "等待"),
    IN_PROGRESS("in_progress", "进行中"),
    COMPLETE("complete", "完成"),
    FAIL("fail", "失败"),

    ;

    private String status;

    private String name;


    public static AiImageStatusEnum valueOfStatus(String status) {
        for (AiImageStatusEnum itemEnum : AiImageStatusEnum.values()) {
            if (itemEnum.getStatus().equals(status)) {
                return itemEnum;
            }
        }
        throw new IllegalArgumentException("Invalid MessageType value: " + status);
    }
}