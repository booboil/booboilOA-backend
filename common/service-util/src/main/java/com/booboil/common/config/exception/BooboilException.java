package com.booboil.common.config.exception;

import com.booboil.common.result.ResultCodeEnum;
import lombok.Data;

@Data
public class BooboilException extends RuntimeException {

    private Integer code;//状态码
    private String msg;//描述信息

    public BooboilException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public BooboilException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
